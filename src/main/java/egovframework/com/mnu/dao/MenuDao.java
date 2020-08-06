package egovframework.com.mnu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @title : 메뉴관리 Dao 
 * @package : egovframework.com.mnu.dao
 * @filename : MenuDao.java
 * @author : "egov"
 * @since : 2020. 8. 5.
 * @version : 1.0
 * @desc : 메뉴관리 CRUD 모음.
 * 
 *  ======= 변경이력 =======
 * 
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 15.         "egov"           최초 생성(ver 1.0)
 * 
 */
@Repository
@Mapper
public interface MenuDao {
	
	List<HashMap<Object, Object>> selectMakeMenuList();
	List<HashMap<Object, Object>> selectMenuList(Map<Object, Object> param);
	
	int selectMenuCnt(Map<Object, Object> param);
	int insertMenu(Map<Object, Object> param);
	
	int updateMenu(Map<Object, Object> param);
	int deleteMenu(Map<Object, Object> param);

	
	int deleteAuthMenu(Map<Object, Object> param);
    int insertAuthMenu(Map<Object, Object> param);
	
}
