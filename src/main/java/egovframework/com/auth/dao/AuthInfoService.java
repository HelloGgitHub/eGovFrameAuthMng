package egovframework.com.auth.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.cmm.ComUtil;

/**
 * @title : 권한정보 관리 Service
 * @package : egovframework.com.auth.dao
 * @filename : AuthInfoService.java
 * @author : "egov"
 * @since : 2020. 6. 15.
 * @version : 1.0
 * @desc : 권한정보 관리 Service모음
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
public class AuthInfoService {
	
	@Autowired
    private AuthInfoDao mapper;
	
	/**
	 * @name : selectAuthList(권한목록 조회)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : List<HashMap<Object,Object>>
	 */
	public List<HashMap<Object, Object>> selectAuthList() {
		
		List<HashMap<Object, Object>> rtnLst = new ArrayList<HashMap<Object, Object>> ();
		List<HashMap<Object, Object>> sqlLst = new ArrayList<HashMap<Object, Object>> ();
		
		sqlLst = mapper.selectAuthList();
		
		for(int i = 0; sqlLst.size() > i; i++) {
			HashMap<Object, Object> rtnMap= new HashMap<Object, Object>();
			rtnMap = sqlLst.get(i);
			rtnMap.put("change_dt", ComUtil.dbDatetoDataTimeFrm(rtnMap.get("change_dt").toString()));
			rtnMap.put("author_creat_dt", ComUtil.dbDatetoDataTimeFrm(rtnMap.get("author_creat_dt").toString()));
			rtnLst.add(rtnMap);
		}
		
        return rtnLst;
    }
	
	/**
	 * @name : selectAuthDetail(권한상세정보 조회)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : HashMap<String,Object>
	 */
	public List<HashMap<Object, Object>> selectAuthDetail(Map<Object, Object> param) {
		
		List<HashMap<Object, Object>> rtnLst = new ArrayList<HashMap<Object, Object>> ();
		List<HashMap<Object, Object>> sqlLst = new ArrayList<HashMap<Object, Object>> ();
		
		sqlLst = mapper.selectAuthDetail(param);
		
		for(int i = 0; sqlLst.size() > i; i++) {
			HashMap<Object, Object> rtnMap= new HashMap<Object, Object>();
			rtnMap = sqlLst.get(i);
			rtnMap.put("author_creat_dt", ComUtil.dbDatetoDataTimeFrm(rtnMap.get("author_creat_dt").toString()));
			rtnLst.add(rtnMap);
		}
		
        return rtnLst;
    }

	/**
	 * @name : selectAuthInfoCnt(권한코드 기등록여부 확인)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int selectAuthInfoCnt(Map<Object, Object> param) {
        return mapper.selectAuthInfoCnt(param);
    }

	/**
	 * @name : insertAuthInfo(권한 생성)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int insertAuthInfo(Map<Object, Object> param) {
        return mapper.insertAuthInfo(param);
    }

	/**
	 * @name : updateAuthInfo(권한정보 변경)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int updateAuthInfo(Map<Object, Object> param) {
        return mapper.updateAuthInfo(param);
    }

	/**
	 * @name : deleteAuthInfo(권한정보 삭제)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : int
	 */
	public int deleteAuthInfo(Map<Object, Object> param) {
        return mapper.deleteAuthInfo(param);
    }

	
	
	
	
	
	
	//상세정보 조회
	/**
	 * @name : selectUserDetail(  )
	 * @date : 2020. 6. 12.
	 * @author : "egov"
	 * @return_type : HashMap<Object,Object>
	 * @desc : 
	 */
	public HashMap<Object, Object> selectUserDetail(Map<Object, Object> param) {
        return mapper.selectUserDetail(param);
    }
 
	//사용자 pw체크
	public HashMap<String, Object> selectUserPwCk(Map<Object, Object> param) {
        return mapper.selectUserPwCk(param);
    }
}
