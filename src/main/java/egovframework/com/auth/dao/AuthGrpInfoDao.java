package egovframework.com.auth.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @title : 권한그룹 관리 Dao
 * @package : egovframework.com.auth.dao
 * @filename : AuthGrpInfoDao.java
 * @author : "egov"
 * @since : 2020. 6. 15.
 * @version : 1.0
 * @desc : 그룹권한을 관리 하는데 필요한 CRUD
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
public interface AuthGrpInfoDao {
	
	List<HashMap<Object, Object>> selectAuthGrpList();
	List<HashMap<Object, Object>> selectAuthGrpDetail(Map<Object, Object> param);
	int selectAuthGrpInfoCnt(Map<Object, Object> param);
	int insertAuthGrpInfo(Map<Object, Object> param);
	int updateAuthGrpInfo(Map<Object, Object> param);
	int deleteAuthGrpInfo(Map<Object, Object> param);

	List<HashMap<Object, Object>> selectGrpAuthList(Map<Object, Object> param);
	int selectGrpAuthCnt(Map<Object, Object> param);
	int insertGrpAuth(Map<Object, Object> param);
	int deleteGrpAuth(Map<Object, Object> param);

	List<HashMap<Object, Object>> selectGrpAuthUsrList(Map<Object, Object> param);
	int updateGrpAuthUsr(Map<Object, Object> param);
	int insertGrpAuthUsr(Map<Object, Object> param);
	int deleteGrpAuthUsr(Map<Object, Object> param);
	List<HashMap<Object, Object>> selectUserList();
	HashMap<String, Object> selectAuthGrpUsrCnt(Map<Object, Object> param);
	
}
