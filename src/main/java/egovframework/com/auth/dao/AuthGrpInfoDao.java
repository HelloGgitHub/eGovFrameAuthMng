package egovframework.com.auth.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AuthGrpInfoDao {
	
	//권한목록 조회
	List<HashMap<Object, Object>> selectAuthGrpList();
	//권한정보 조회
	HashMap<String, Object> selectAuthGrpDetail(Map<Object, Object> param);
	
	//권한그룹정보 등록
	int selectAuthGrpInfoCnt(Map<Object, Object> param);
	int insertAuthGrpInfo(Map<Object, Object> param);
	
	//그룹정보 변경
	int updateAuthGrpInfo(Map<Object, Object> param);
	//그룹정보 삭제
	int deleteAuthGrpInfo(Map<Object, Object> param);

	
	

	//권한그룹 권한목록 조회
	List<HashMap<Object, Object>> selectGrpAuthList(Map<Object, Object> param);
	
	//권한그룹 권한 등록
	int selectGrpAuthCnt(Map<Object, Object> param);
	int insertGrpAuth(Map<Object, Object> param);
	
	//그룹정보 삭제
	int deleteGrpAuth(Map<Object, Object> param);
	

	
	

	//권한그룹 권한목록 조회
	List<HashMap<Object, Object>> selectGrpAuthUsrList(Map<Object, Object> param);
	
	//권한그룹 권한 등록
	int updateGrpAuthUsr(Map<Object, Object> param);
	int insertGrpAuthUsr(Map<Object, Object> param);
	
	//그룹정보 삭제
	int deleteGrpAuthUsr(Map<Object, Object> param);
	
}
