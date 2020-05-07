package egovframework.com.auth.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthInfoService {
	
	@Autowired
    private AuthInfoDao mapper;
	
	//권한목록 조회
	public List<HashMap<Object, Object>> selectAuthList() {
        return mapper.selectAuthList();
    }
	//권한상세정보 조회
	public List<HashMap<Object, Object>> selectAuthDetail(Map<Object, Object> param) {
        return mapper.selectAuthDetail(param);
    }
	//권한 생성
	public int insertAuthInfo(Map<Object, Object> param) {
        return mapper.insertAuthInfo(param);
    }
	//그룹정보 변경
	public int updateAuthInfo(Map<Object, Object> param) {
        return mapper.updateAuthInfo(param);
    }
	//그룹정보 삭제
	public int deleteAuthInfo(Map<Object, Object> param) {
        return mapper.deleteAuthInfo(param);
    }
	
	
	
	//그룹 사용자목록 조회
	public List<HashMap<Object, Object>> selectGrpUsrList(Map<Object, Object> param) {
        return mapper.selectGrpUsrList(param);
    }
	//그룹 사용자 추가
	public int insertGrpUsr(Map<Object, Object> param) {
        return mapper.insertGrpUsr(param);
    }
	//그룹 사용자 추가
	public int selectGrpUsrCk(Map<Object, Object> param) {
        return mapper.selectGrpUsrCk(param);
    }
	//그룹 사용자 삭제
	public int deleteGrpUsr(Map<Object, Object> param) {
        return mapper.deleteGrpUsr(param);
    }

}
