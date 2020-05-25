package egovframework.com.cmm;

import java.util.ArrayList;
import java.util.List;

public class ComUtil {

	public List<Object> listforPaging(Object pLst, int page, int pageSize){
		List<Object> reLst = new ArrayList<Object>();
		List<Object> pArrayList = (ArrayList<Object>)pLst;
		
		if((pArrayList.size()/pageSize)+1 < page) {
			return reLst;
		}
		
		int getPage = 0;
		if(page == 1) {
			getPage = 0;
		}else {
			getPage = (page-1)*pageSize;
		}
		
		for(int i = 0; pageSize > i; i++) {
			if(getPage == pArrayList.size()) {break;}
			reLst.add(i, pArrayList.get(getPage));
			
			getPage++;
		}
		
		return reLst;
	}
	
}
