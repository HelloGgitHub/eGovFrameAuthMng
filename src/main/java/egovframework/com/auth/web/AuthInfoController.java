package egovframework.com.auth.web;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.auth.dao.AuthInfoService;
import egovframework.com.auth.dao.AuthVo;
import egovframework.com.auth.dao.UserVo;
import egovframework.com.cmm.ComUtil;
import egovframework.com.cmm.SecuritySha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @title : 권한코드 정보 관리 
 * @package : egovframework.com.auth.web
 * @filename : AuthInfoController.java
 * @author : "egov"
 * @since : 2020. 6. 15.
 * @version : 1.0
 * @desc : 권한코드 정보를 등록 수정 삭제 하는 기능 모음.
 * 
 *  ======= 변경이력 =======
 * 
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 15.         "egov"           최초 생성(ver 1.0)
 * 
 */
@RestController
@Api(value = "AuthInfoController", description = "권한 정보 관리 REST API")
@RequestMapping("/auth")
public class AuthInfoController {
	
	@Autowired
	AuthInfoService authService;
	
	/**
	 * @name : AuthList(권한목록 조회)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @throws Exception 
	 * @return_type : String
	 * @desc : 등록된 권한 목록을 조회한다.
	 */
	@ApiOperation(value = "권한목록 조회")
	@GetMapping(path = "/list")
	public String AuthList() throws Exception {
		String rtn = "";
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		ObjectMapper om = new ObjectMapper();

		try {
			List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
			lst = authService.selectAuthList();
			rtnMap.put("list", lst);
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
		}catch (Exception e) {
			e.printStackTrace();
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "조회에 실패하였습니다.");
		}
		
		rtn = om.writeValueAsString(rtnMap);
		
		return rtn;
	}
	
	/**
	 * @name : AuthDetailInfo(권한코드 정보 조회)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : String
	 * @desc : 권한코드에 대한 내용을 조회한다.
	 */
	@ApiOperation(value = "권한코드 정보 조회")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "authCd", value = "권한코드", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
	@GetMapping(path = "/detailInfo/{authCd}")
	public String AuthDetailInfo(@PathVariable("authCd") String authCd) throws Exception {

		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		Map<Object, Object> sqlInpt = new HashMap<Object, Object>();

		
		try {
			sqlInpt.put("AUTHCD", URLDecoder.decode(authCd		,"UTF-8"));
			
			lst = authService.selectAuthDetail(sqlInpt);

			rtnMap.put("list", lst);
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
		}catch (Exception e) {
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "조회에 실패하였습니다.");
			e.printStackTrace();
		}
		
		rtn = om.writeValueAsString(rtnMap);
		return rtn;
	}
	
	/**
	 * @name : InsertAuthInfo(권한등록)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : String
	 * @desc : 신규 권한 코드를 등록한다.
	 */
	@ApiOperation(value = "권한 등록", notes = "권한을 등록합니다.")
	@PostMapping(path = "/addnew")
	public String InsertAuthInfo(@RequestBody AuthVo param) throws Exception {

		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		
		try {
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
	
			sqlInpt.put("AUTHCD"	, param.getAuthCd());
			sqlInpt.put("AUTHNM"	, param.getAuthNm());
			sqlInpt.put("AUTHDC"	, param.getAuthDc());
			sqlInpt.put("DT"			, ComUtil.getTime("yyyyMMddHHmmss"));
			
			int rowCnt = authService.selectAuthInfoCnt(sqlInpt);
			if(rowCnt == 0) {
				int inputCnt = authService.insertAuthInfo(sqlInpt);
				if(inputCnt > 0) {
					rtnMap.put("RESULTCD", "0");
					rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
				}else {
					rtnMap.put("RESULTCD", "1");
					rtnMap.put("RESULTMSG", "등록에 실패 하였습니다.");
				}
			}else {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "중복되는 권한코드가 있습니다.");
			}
		}catch (Exception e) {
			e.printStackTrace();
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "처리중 오류가 발생하였습니다.");
		}
		rtn = om.writeValueAsString(rtnMap);
		return rtn;
	}

	
	/**
	 * @name : AuthChangeInfo(권한 정보 수정)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : String
	 * @desc : 등록된 권한정보 내용을 수정한다.
	 */
	@ApiOperation(value = "권한 정보수정", notes = "권한정보를 수정한다.")
	@PutMapping(path = "/modifyInfo")
	public String AuthChangeInfo(@RequestBody AuthVo param) throws Exception {
		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		try {
			//입력값 파라미터 정의
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("AUTHCD"	, param.getAuthCd());
			sqlInpt.put("AUTHNM"	, param.getAuthNm());
			sqlInpt.put("AUTHDC"	, param.getAuthDc());
			sqlInpt.put("DT"			, ComUtil.getTime("yyyyMMddHHmmss"));
			
			int inputCnt = authService.updateAuthInfo(sqlInpt);
			if(inputCnt > 0) {
				rtnMap.put("RESULTCD", "0");
				rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
			}else {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "등록된 권한코드가 없습니다.");
			}
		}catch (Exception e) {
			e.printStackTrace();
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "처리중 오류가 발생하였습니다.");
		}
		rtn = om.writeValueAsString(rtnMap);
		return rtn;
	}
	
	
	/**
	 * @name : AuthDeleteInfo(권한삭제)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : String
	 * @desc : 권한코드를 삭제 한다.
	 */
	@ApiOperation(value = "권한 삭제", notes = "권한을 삭제한다.")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "authCd"	, value = "권한코드"	, required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
	@DeleteMapping(path = "/delete")
	public String AuthDeleteInfo(@RequestParam(value = "authCd") String authCd) throws Exception {
		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		
		String pAuthCd = URLDecoder.decode(authCd,"UTF-8");
		try {
			//입력값 파라미터 정의
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("AUTHCD"	, pAuthCd);
			
			int inputCnt = authService.deleteAuthInfo(sqlInpt);
			if(inputCnt > 0) {
				rtnMap.put("RESULTCD", "0");
				rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
			}else {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "삭제할 권한이 없습니다.");
			}
		}catch (Exception e) {
			e.printStackTrace();
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "처리중 오류가 발생하였습니다.");
		}
		rtn = om.writeValueAsString(rtnMap);
		return rtn;
	}

	/**
	 * @name : UserLogin(사용자 로그인)
	 * @date : 2020. 6. 11.
	 * @author : "egov"
	 * @return_type : String
	 * @desc : 사용자의 ID/PW input 값으로 로그인 처리를 한다.
	 *              로그인의 결과값은 사용자 정보를 출력한다.
	 */
	@ApiOperation(value = "사용자 로그인", notes = "사용자 ID/PW를 입력받아 사용자 정보를 반환합니다.")
	@PostMapping(path = "/idpw")
	public String UserLogin(@RequestBody UserVo usr) throws Exception {
		
		String rtn = "";
		String pUserId 			= URLDecoder.decode(usr.getUsrId()		,"UTF-8");
		String pPassWord 	= URLDecoder.decode(usr.getPassword()	,"UTF-8");
		
		String pw = SecuritySha.SHA256(pPassWord);		//SHA-256 암호화
		Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		sqlInpt.put("USRID", 		pUserId);
		sqlInpt.put("USRPW", 	pw);
		HashMap<String, Object> rtnSqlMap = new HashMap<String, Object>();
		try {
			rtnSqlMap = authService.selectUserPwCk(sqlInpt);
			Map<Object, Object> sqlRtn = new HashMap<Object, Object>();
			if(rtnSqlMap == null) {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "등록된 사용자가 없습니다.");
			}else if (!pw.equals(rtnSqlMap.get("password").toString())) {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "패스워드가 올바르지 않습니다.");
			}else if (pw.equals(rtnSqlMap.get("password").toString())) {
				sqlRtn = authService.selectUserDetail(sqlInpt);
				rtnMap.put("list", sqlRtn);
				rtnMap.put("RESULTCD", "0");
				rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
			}else {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "ID/PW가 올바르지 않습니다.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		ObjectMapper om = new ObjectMapper();
		rtn = om.writeValueAsString(rtnMap);
		
		return rtn;
	}


}
