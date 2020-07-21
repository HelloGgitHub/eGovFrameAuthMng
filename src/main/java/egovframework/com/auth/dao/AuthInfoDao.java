package egovframework.com.auth.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @title : 권한코드 정보 관리 Dao 
 * @package : egovframework.com.auth.dao
 * @filename : AuthInfoDao.java
 * @author : "egov"
 * @since : 2020. 6. 15.
 * @version : 1.0
 * @desc : 권한코드 관리 CRUD 모음.
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
public interface AuthInfoDao {
	
	List<HashMap<Object, Object>> selectAuthList();
	List<HashMap<Object, Object>> selectAuthDetail(Map<Object, Object> param);
	int insertAuthInfo(Map<Object, Object> param);
	int updateAuthInfo(Map<Object, Object> param);
	int deleteAuthInfo(Map<Object, Object> param);
	int deleteAuthGrp(Map<Object, Object> param);
	int selectAuthInfoCnt(Map<Object, Object> param);

	//로그인관련
	HashMap<Object, Object> selectUserDetail(Map<Object, Object> param);
	HashMap<String, Object> selectUserPwCk(Map<Object, Object> param);
    
}
