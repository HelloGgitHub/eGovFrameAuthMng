package egovframework;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		int rowCnt = 3;
		
		
		int page = 3;
		int pageSize = 2;
		
		List<Object> lst = new ArrayList<Object>();
		
		for(int i = 0; rowCnt > i; i++) {
			lst.add(i+1);
		}
		System.out.println( lst.size() + ">>>>" + lst + " === " + pageSize*page );
		
		List<Object> lst2 = new ArrayList<Object>();
		Test ts = new Test();
		

		
		lst2 = ts.PagingList(lst, page, pageSize);
		
		System.out.println( "++++++" + lst2.size() + "----" + lst2);
	}

	
	public List<Object> PagingList(Object pLst, int page, int pageSize){
		List<Object> reLst = new ArrayList<Object>();
		List<Object> pArrayList = (ArrayList<Object>)pLst;
		
		int getPage = 0;
		
		System.out.println("pArrayList.size()/pageSize\t>>>" + pArrayList.size()/pageSize);
		System.out.println("page\t\t\t\t\t>>>" + page);
		
		if((pArrayList.size()/pageSize)+1 < page) {
			System.out.println("aaaaaaaaaaaa");
		}
		
		if(page == 1) {
			getPage = 0;
		}else {
			getPage = (page-1)*pageSize;
		}
		
		System.out.println("page=" + page + ", pageSize=" + pageSize + ", pArrayList.size()="+pArrayList.size() + ", getPage=" + getPage);
		
		
		
		for(int i = 0; pageSize > i; i++) {
			if(getPage == pArrayList.size()) {break;}
			reLst.add(i, pArrayList.get(getPage));
			
			getPage++;
		}
		
		return reLst;
	}
	
}
