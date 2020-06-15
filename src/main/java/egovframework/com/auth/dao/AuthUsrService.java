package egovframework.com.auth.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @title : 권한 사용자 매핑 관리 Service 
 * @package : egovframework.com.auth.dao
 * @filename : AuthUsrService.java
 * @author : "egov"
 * @since : 2020. 6. 15.
 * @version : 1.0
 * @desc : 권한 사용자 매핑 관련된 Service 모음
 * 
 *  ======= 변경이력 =======
 * 
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 15.         "egov"           최초 생성(ver 1.0)
 * 
 */
@Service
@Transactional
public class AuthUsrService {
	
	@Autowired
    private AuthUsrDao mapper;
	
	/**
	 * @name : selectAuthUsrList(권한코드기준 사용자 목록조회)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : List<HashMap<Object,Object>>
	 */
	public List<HashMap<Object, Object>> selectAuthUsrList(Map<Object, Object> param) {
        return mapper.selectAuthUsrList(param);
    }
	
	/**
	 * @name : selectUsrAuthList(사용자기준 권한코드 목록 조회)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : List<HashMap<Object,Object>>
	 */
	public List<HashMap<Object, Object>> selectUsrAuthList(Map<Object, Object> param) {
        return mapper.selectUsrAuthList(param);
    }
	
	/**
	 * @name : selectAuthUsrCnt(사용자 권한코드 기등록 여부 조회)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int selectAuthUsrCnt(Map<Object, Object> param) {
        return mapper.selectAuthUsrCnt(param);
    }
	
	/**
	 * @name : insertAuthUsr(권한코드 사용자 매핑)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int insertAuthUsr(Map<Object, Object> param) {
        return mapper.insertAuthUsr(param);
    }
	
	/**
	 * @name : deleteAuthUsr(권한코드 사용자 매핑 삭제)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int deleteAuthUsr(Map<Object, Object> param) {
        return mapper.deleteAuthUsr(param);
    }
	

}
