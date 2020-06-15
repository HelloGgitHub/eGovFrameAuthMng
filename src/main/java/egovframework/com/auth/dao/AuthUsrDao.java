package egovframework.com.auth.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @title : 권한 사용자 목록 관리 Dao 
 * @package : egovframework.com.auth.dao
 * @filename : AuthUsrDao.java
 * @author : "egov"
 * @since : 2020. 6. 15.
 * @version : 1.0
 * @desc : 권한코드와 사용자 매핑이 관련된 CRUD 모음
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
public interface AuthUsrDao {
	
	List<HashMap<Object, Object>> selectAuthUsrList(Map<Object, Object> param);
	List<HashMap<Object, Object>> selectUsrAuthList(Map<Object, Object> param);

	int selectAuthUsrCnt(Map<Object, Object> param);
	int insertAuthUsr(Map<Object, Object> param);

	int deleteAuthUsr(Map<Object, Object> param);
	
}
