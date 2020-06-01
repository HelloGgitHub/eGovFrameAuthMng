package egovframework.com.auth.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthGrpInfoService {
	
	@Autowired
    private AuthGrpInfoDao mapper;
	
	//권한그룹목록 조회
	public List<HashMap<Object, Object>> selectAuthGrpList() {
        return mapper.selectAuthGrpList();
    }
	
	//권한그룹상세정보 조회
	public HashMap<String, Object> selectAuthGrpDetail(Map<Object, Object> param) {
        return mapper.selectAuthGrpDetail(param);
    }
	
	//그룹정보 기등록 여부 확인
	public int selectAuthGrpInfoCnt(Map<Object, Object> param) {
        return mapper.selectAuthGrpInfoCnt(param);
    }
	//권한 생성
	public int insertAuthGrpInfo(Map<Object, Object> param) {
        return mapper.insertAuthGrpInfo(param);
    }
	
	//그룹정보 변경
	public int updateAuthGrpInfo(Map<Object, Object> param) {
        return mapper.updateAuthGrpInfo(param);
    }
	
	//그룹정보 삭제
	public int deleteAuthGrpInfo(Map<Object, Object> param) {
        return mapper.deleteAuthGrpInfo(param);
    }

	
	
	
	
	
	//권한그룹 권한목록 조회
	public List<HashMap<Object, Object>> selectGrpAuthList(Map<Object, Object> param) {
        return mapper.selectGrpAuthList(param);
    }
	
	//그룹 권한등록 중복 여부 확인
	public int selectGrpAuthCnt(Map<Object, Object> param) {
        return mapper.selectGrpAuthCnt(param);
    }
	//그룹권한 그룹 등록
	public int insertGrpAuth(Map<Object, Object> param) {
        return mapper.insertGrpAuth(param);
    }
	
	//그룹정보 삭제
	public int deleteGrpAuth(Map<Object, Object> param) {
        return mapper.deleteGrpAuth(param);
    }



	
	

	//권한그룹 권한목록 조회
	public List<HashMap<Object, Object>> selectGrpAuthUsrList(Map<Object, Object> param) {
        return mapper.selectGrpAuthUsrList(param);
    }
	
	//그룹권한 그룹 업데이트
	public int updateGrpAuthUsr(Map<Object, Object> param) {
        return mapper.updateGrpAuthUsr(param);
    }
	//그룹권한 그룹 등록
	public int insertGrpAuthUsr(Map<Object, Object> param) {
        return mapper.insertGrpAuthUsr(param);
    }
	
	//그룹정보 삭제
	public int deleteGrpAuthUsr(Map<Object, Object> param) {
        return mapper.deleteGrpAuth(param);
    }

}
