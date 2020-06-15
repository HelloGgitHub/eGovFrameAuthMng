package egovframework.com.auth.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @title : 권한그룹 관리 Service
 * @package : egovframework.com.auth.dao
 * @filename : AuthGrpInfoService.java
 * @author : "egov"
 * @since : 2020. 6. 15.
 * @version : 1.0
 * @desc : 권한 그룹관리에 필요한 서비스 모음
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
public class AuthGrpInfoService {
	
	@Autowired
    private AuthGrpInfoDao mapper;
	
	/**
	 * @name : selectAuthGrpList(권한그룹코드 목록 조회)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : List<HashMap<Object,Object>>
	 */
	public List<HashMap<Object, Object>> selectAuthGrpList() {
        return mapper.selectAuthGrpList();
    }
	
	/**
	 * @name : selectAuthGrpDetail(권한그룹코드 상세정보 조회)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : HashMap<String,Object>
	 */
	public HashMap<String, Object> selectAuthGrpDetail(Map<Object, Object> param) {
        return mapper.selectAuthGrpDetail(param);
    }
	
	/**
	 * @name : selectAuthGrpInfoCnt(권한그룹코드 기등록 여부 확인)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int selectAuthGrpInfoCnt(Map<Object, Object> param) {
        return mapper.selectAuthGrpInfoCnt(param);
    }
	
	/**
	 * @name : insertAuthGrpInfo(권한그룹코드생성)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int insertAuthGrpInfo(Map<Object, Object> param) {
        return mapper.insertAuthGrpInfo(param);
    }
	
	/**
	 * @name : updateAuthGrpInfo(권한그룹 코드정보 변경)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int updateAuthGrpInfo(Map<Object, Object> param) {
        return mapper.updateAuthGrpInfo(param);
    }
	
	/**
	 * @name : deleteAuthGrpInfo(권한그룹 코드정보 삭제)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int deleteAuthGrpInfo(Map<Object, Object> param) {
        return mapper.deleteAuthGrpInfo(param);
    }

	
	
	/**
	 * @name : selectGrpAuthList(권한그룹 권한목록 조회)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : List<HashMap<Object,Object>>
	 */
	public List<HashMap<Object, Object>> selectGrpAuthList(Map<Object, Object> param) {
        return mapper.selectGrpAuthList(param);
    }
	
	/**
	 * @name : selectGrpAuthCnt(그룹권한 권한등록 중복 여부 확인)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int selectGrpAuthCnt(Map<Object, Object> param) {
        return mapper.selectGrpAuthCnt(param);
    }
	/**
	 * @name : insertGrpAuth(그룹권한 권한 등록)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int insertGrpAuth(Map<Object, Object> param) {
        return mapper.insertGrpAuth(param);
    }
	
	/**
	 * @name : deleteGrpAuth(그룹권한 권한 삭제)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int deleteGrpAuth(Map<Object, Object> param) {
        return mapper.deleteGrpAuth(param);
    }


	/**
	 * @name : selectGrpAuthUsrList(그룹권한 사용자 목록)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : List<HashMap<Object,Object>>
	 */
	public List<HashMap<Object, Object>> selectGrpAuthUsrList(Map<Object, Object> param) {
        return mapper.selectGrpAuthUsrList(param);
    }
	
	/**
	 * @name : updateGrpAuthUsr(그룹권한 사용자 등록)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 * @desc : 권한코드 단위로 등록된 사용자의 경우 권한그룹코드 업데이트
	 */
	public int updateGrpAuthUsr(Map<Object, Object> param) {
        return mapper.updateGrpAuthUsr(param);
    }
	/**
	 * @name : insertGrpAuthUsr(그룹권한 단위 사용자 권한 등록)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int insertGrpAuthUsr(Map<Object, Object> param) {
        return mapper.insertGrpAuthUsr(param);
    }
	
	/**
	 * @name : deleteGrpAuthUsr(그룹권한 단위 사용자 권한 삭제)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int deleteGrpAuthUsr(Map<Object, Object> param) {
        return mapper.deleteGrpAuthUsr(param);
    }

}
