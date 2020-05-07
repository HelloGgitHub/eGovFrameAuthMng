package egovframework.com.auth.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AuthInfoDao {
	
	//권한목록 조회
	List<HashMap<Object, Object>> selectAuthList();
	//권한정보 조회
	List<HashMap<Object, Object>> selectAuthDetail(Map<Object, Object> param);
	//권한정보 등록
	int insertAuthInfo(Map<Object, Object> param);
	//그룹정보 변경
	int updateAuthInfo(Map<Object, Object> param);
	//그룹정보 삭제
	int deleteAuthInfo(Map<Object, Object> param);

	
	
	//그룹 사용자목록 조회
	List<HashMap<Object, Object>> selectGrpUsrList(Map<Object, Object> param);
	//그룹 사용자 추가
	int insertGrpUsr(Map<Object, Object> param);
	//그룹 사용자 기등록여부 확인
	int selectGrpUsrCk(Map<Object, Object> param);
	//그룹 사용자 삭제
	int deleteGrpUsr(Map<Object, Object> param);

	
}
