package egovframework.com.auth.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthUsrService {
	
	@Autowired
    private AuthUsrDao mapper;
	
	//권한상세정보 조회
	public List<HashMap<Object, Object>> selectAuthUsrList(Map<Object, Object> param) {
        return mapper.selectAuthUsrList(param);
    }
	//권한상세정보 조회
	public List<HashMap<Object, Object>> selectUsrAuthList(Map<Object, Object> param) {
        return mapper.selectUsrAuthList(param);
    }
	

	//권한 생성
	public int selectAuthUsrCnt(Map<Object, Object> param) {
        return mapper.selectAuthUsrCnt(param);
    }
	//권한 생성
	public int insertAuthUsr(Map<Object, Object> param) {
        return mapper.insertAuthUsr(param);
    }
	//그룹정보 삭제
	public int deleteAuthUsr(Map<Object, Object> param) {
        return mapper.deleteAuthUsr(param);
    }
	

}
