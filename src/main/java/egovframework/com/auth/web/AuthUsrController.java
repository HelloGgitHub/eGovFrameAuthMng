package egovframework.com.auth.web;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.auth.dao.AuthInputParamVo;
import egovframework.com.auth.dao.AuthUsrService;
import egovframework.com.cmm.ComUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @title :권한 사용자 정보관리 
 * @package : egovframework.com.auth.web
 * @filename : AuthUsrController.java
 * @author : "egov"
 * @since : 2020. 6. 15.
 * @version : 1.0
 * @desc : 등록된 권한을 사용자와 매핑 또는 권한과 사용자 정보를 조회하는 작업을 한다.
 * 
 *  ======= 변경이력 =======
 * 
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 15.         "egov"           최초 생성(ver 1.0)
 * 
 */
@RestController
@Api(value = "AuthUserController", description = "권한 사용자 정보 관리 REST API")
@RequestMapping("/auth")
public class AuthUsrController {
	
	@Autowired
	AuthUsrService authService;
	
	/**
	 * @name : AuthUsrList(권한보유 사용자 목록조회)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : String
	 * @desc : 권한 기준 등록된 사용자 목록을 조회한다.
	 */
	@ApiOperation(value = "권한보유 사용자 목록조회")
	@PostMapping(path = "/authUsrList")
	public String AuthUsrList(@RequestBody AuthInputParamVo param) throws Exception {
		String rtn = "";
		ComUtil cu = new ComUtil();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
		
		try {
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("AUTHCD", 		URLDecoder.decode(param.getAuthCd(),		"UTF-8"));
			sqlInpt.put("PAGE", 			param.getPage());
			sqlInpt.put("PAGESIZE", 	param.getPageSize());
			
			lst = authService.selectAuthUsrList(sqlInpt);
			
			rtnMap.put("page", param.getPage());
			rtnMap.put("pageSize", param.getPageSize());
			rtnMap.put("totalCount", lst.size());
			if(param.getPage() > 0 && param.getPage() > 0) { //페이징관련 파라미터가 있을 경우만 페이징 처리 
				rtnMap.put("list", cu.listforPaging(lst, param.getPage(),param.getPageSize()));
			}else {
				rtnMap.put("list", lst);
			}
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
		} catch(Exception e) {
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "조회에 실패하였습니다.");
			e.printStackTrace();
		}
		
		rtn = om.writeValueAsString(rtnMap);
		return rtn;
	}

	
	/**
	 * @name : UsrAuthList(사용자 보유권한 목록조회)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : String
	 * @desc : 사용자 기준 보유 권한 목록을 조회한다.
	 */
	@ApiOperation(value = "사용자 보유 권한 목록조회")
	@PostMapping(path = "/usrAuthList")
	public String UsrAuthList(@RequestBody AuthInputParamVo param) throws Exception {
		String rtn = "";
		ComUtil cu = new ComUtil();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
		
		try {
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("USR_ID", 		URLDecoder.decode(param.getUsrId(),		"UTF-8"));
			sqlInpt.put("PAGE", 			param.getPage());
			sqlInpt.put("PAGESIZE", 	param.getPageSize());
			
			lst = authService.selectUsrAuthList(sqlInpt);
			rtnMap.put("page", param.getPage());
			rtnMap.put("pageSize", param.getPageSize());
			rtnMap.put("totalCount", lst.size());
			if(param.getPage() > 0 && param.getPage() > 0) { //페이징관련 파라미터가 있을 경우만 페이징 처리 
				rtnMap.put("list", cu.listforPaging(lst, param.getPage(),param.getPageSize()));
			}else {
				rtnMap.put("list", lst);
			}
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
		} catch(Exception e) {
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "조회에 실패하였습니다.");
			e.printStackTrace();
		}
		
		rtn = om.writeValueAsString(rtnMap);
		return rtn;
	}

	
	/**
	 * @name : InsertAuthUsr(권한에 사용자 등록)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : String
	 * @desc : 권한코드와 사용자를 등록한다.
	 */
	@ApiOperation(value = "권한에 사용자 등록", notes = "권한에 사용자를 등록합니다.")
	@PostMapping(path = "/usrAdd")
	public String InsertAuthUsr(@RequestBody AuthInputParamVo param) throws Exception {
 
		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		
		try {
			//입력값 파라미터 정의
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("USR_ID"			, URLDecoder.decode(param.getUsrId()	,"UTF-8"));
			sqlInpt.put("AUTHCD"		, URLDecoder.decode(param.getAuthCd()	,"UTF-8"));
			sqlInpt.put("DT"				, ComUtil.getTime("yyyyMMddHHmmss"));
			
			int rowCnt = authService.selectAuthUsrCnt(sqlInpt);

			if(rowCnt == 0) {
				int inputCnt = authService.insertAuthUsr(sqlInpt);
				if(inputCnt > 0) {
					rtnMap.put("RESULTCD", "0");
					rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
				}else {
					rtnMap.put("RESULTCD", "1");
					rtnMap.put("RESULTMSG", "등록에 실패 하였습니다.");
				}
			}else {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "해당 권한은 사용자에게 이미 부여 되어있습니다.");
			}
		} catch (Exception e) {
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "처리중 오류가 발생하였습니다.");
			e.printStackTrace();
		}
		rtn = om.writeValueAsString(rtnMap);
		return rtn;
	}

	
	/**
	 * @name : DeleteAuthUsr(사용자 권한 삭제)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : String
	 * @desc : 권한코드와 사용자가 매핑된 내용을 삭제 한다.
	 */
	@ApiOperation(value = "사용자 권한 삭제", notes = "사용자 권한을 삭제한다.")
	@DeleteMapping(path = "/usrSbt")
	public String DeleteAuthUsr(@RequestBody AuthInputParamVo param) throws Exception {
		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		
		String pAuthCd 	= URLDecoder.decode(param.getAuthCd(),"UTF-8");
		String pUsrId 		= URLDecoder.decode(param.getUsrId(),"UTF-8");
		
		try {
			//입력값 파라미터 정의
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("AUTHCD"	, pAuthCd);
			sqlInpt.put("USR_ID"		, pUsrId);
			
			int inputCnt = authService.deleteAuthUsr(sqlInpt);
			if(inputCnt > 0) {
				rtnMap.put("RESULTCD", "0");
				rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
			}else {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "삭제할 사용자가 없습니다.");
			}
		}catch(Exception e) {
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "처리중 오류가 발생하였습니다.");
			e.printStackTrace();
		}
		rtn = om.writeValueAsString(rtnMap);
		return rtn;
	}

}
