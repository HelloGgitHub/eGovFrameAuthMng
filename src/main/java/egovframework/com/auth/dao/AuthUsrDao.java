package egovframework.com.auth.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AuthUsrDao {
	
	//권한 사용자 목록조회
	List<HashMap<Object, Object>> selectAuthUsrList(Map<Object, Object> param);
	//사용자 권한 목록조회
	List<HashMap<Object, Object>> selectUsrAuthList(Map<Object, Object> param);

	//권한정보 등록
	int selectAuthUsrCnt(Map<Object, Object> param);
	//권한정보 등록
	int insertAuthUsr(Map<Object, Object> param);

	//그룹정보 삭제
	int deleteAuthUsr(Map<Object, Object> param);
	
}
