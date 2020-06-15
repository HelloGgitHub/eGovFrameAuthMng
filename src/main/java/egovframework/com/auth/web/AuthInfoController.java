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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.auth.dao.AuthInfoService;
import egovframework.com.auth.dao.AuthVo;
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
	 * @return_type : String
	 * @desc : 등록된 권한 목록을 조회한다.
	 */
	@ApiOperation(value = "권한목록 조회")
	@GetMapping(path = "/list")
	public String AuthList() {
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
			e.getStackTrace();
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "조회에 실패하였습니다.");
		}
		
		try {
			rtn = om.writeValueAsString(rtnMap);
		} catch (JsonProcessingException e) {
			rtn = "json Mapper Error.";
			e.printStackTrace();
		}
		
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
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		try {
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("AUTHCD", URLDecoder.decode(authCd		,"UTF-8"));
			
			rtnMap = authService.selectAuthDetail(sqlInpt);
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
		}catch (Exception e) {
			e.getStackTrace();
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "조회에 실패하였습니다.");
		}
		
		try {
			rtn = om.writeValueAsString(rtnMap);
		} catch (JsonProcessingException e) {
			rtn = "json Mapper Error.";
			e.printStackTrace();
		}
		
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
			e.getStackTrace();
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
	
			int inputCnt = authService.updateAuthInfo(sqlInpt);
			if(inputCnt > 0) {
				rtnMap.put("RESULTCD", "0");
				rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
			}else {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "등록된 권한코드가 없습니다.");
			}
		}catch (Exception e) {
			e.getStackTrace();
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
	@DeleteMapping(path = "/deleteAuth")
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
			e.getStackTrace();
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "처리중 오류가 발생하였습니다.");
		}
		rtn = om.writeValueAsString(rtnMap);
		return rtn;
	}

	

}
