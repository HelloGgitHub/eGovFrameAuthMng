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

	
}
