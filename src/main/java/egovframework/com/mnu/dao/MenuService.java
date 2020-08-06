package egovframework.com.mnu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @title : 메뉴관리 Service
 * @package : egovframework.com.mnu.dao
 * @filename : MenuService.java
 * @author : "egov"
 * @since : 2020. 8. 5.
 * @version : 1.0
 * @desc : 메뉴관리 Service모음
 * 
 *  ======= 변경이력 =======
 * 
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 8. 5.         "egov"           최초 생성(ver 1.0)
 * 
 */
@Service
@Transactional
public class MenuService {
	
	@Autowired
    private MenuDao mapper;
	
	/**
	 * @name : selectMakeMenuList(메뉴 생성 목록 조회)
	 * @date : 2020. 8. 5.
	 * @author : "egov"
	 * @return_type : List<HashMap<Object,Object>>
	 */
	public List<HashMap<Object, Object>> selectMakeMenuList() {
        return mapper.selectMakeMenuList();
    }

	/**
	 * @name : selectMenuList(메뉴 목록 조회)
	 * @date : 2020. 8. 5.
	 * @author : "egov"
	 * @return_type : List<HashMap<Object,Object>>
	 */
	public List<HashMap<Object, Object>> selectMenuList(Map<Object, Object> param) {
        return mapper.selectMenuList(param);
    }


	/**
	 * @name : selectMenuCnt(메뉴번호 기등록여부 확인)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int selectMenuCnt(Map<Object, Object> param) {
        return mapper.selectMenuCnt(param);
    }

	/**
	 * @name : insertMenu(메뉴 생성)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int insertMenu(Map<Object, Object> param) {
        return mapper.insertMenu(param);
    }

	/**
	 * @name : updateMenu(메뉴정보 변경)
	 * @date : 2020. 8. 5.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int updateMenu(Map<Object, Object> param) {
        return mapper.updateMenu(param);
    }

	/**
	 * @name : deleteMenu(메뉴 삭제)
	 * @date : 2020. 8. 5.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int deleteMenu(Map<Object, Object> param) {
        return mapper.deleteMenu(param);
    }

	/**
	 * @name : deleteMenu(권한 메뉴 등록)
	 * @date : 2020. 8. 5.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int insertAuthMenu(Map<Object, Object> param) {
		int insertCnt = 0;

		String authGrpCd = param.get("AUTHGRPCD").toString();
		String menuNoList = param.get("MENU_NO").toString();
		int menuNoListCnt = (int)param.get("MENU_CNT");
		
		/*권한으로 들어간 메뉴 전부 삭제*/
		mapper.deleteAuthMenu(param);
		
		/*권한으로 들어온 메뉴 반복하며 등록*/
    	String[] menuno = menuNoList.split(",");
		for(int i=0; menuNoListCnt > i; i++) {
			Map<Object, Object> sqlParam = new HashMap<Object, Object>();
			sqlParam.put("AUTHGRPCD", authGrpCd);
			sqlParam.put("MENUNO", menuno[i]);
			mapper.insertAuthMenu(sqlParam);
			insertCnt++;
		}
		
        return insertCnt;
    }

	
}
