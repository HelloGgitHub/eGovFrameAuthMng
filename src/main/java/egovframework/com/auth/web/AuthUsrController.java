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

@RestController
@Api(value = "AuthUserController", description = "권한 정보 관리 REST API")
@RequestMapping("/auth")
public class AuthUsrController {
	
	@Autowired
	AuthUsrService authService;
	
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
			
			System.out.println(lst);
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
			System.out.println(lst);
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

	@ApiOperation(value = "권한에 사용자 등록", notes = "권한에 사용자를 등록합니다.")
	@PostMapping(path = "/usrAdd")
	public String InsertAuthUsr(@RequestBody AuthInputParamVo param) throws Exception {
 
		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		
		try {
			//입력값 파라미터 정의
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("USR_ID", 		URLDecoder.decode(param.getUsrId(),		"UTF-8"));
			sqlInpt.put("AUTHCD",		URLDecoder.decode(param.getAuthCd(),	"UTF-8"));
			
			int rowCnt = authService.selectAuthUsrCnt(sqlInpt);
			System.out.println(rowCnt);

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
			e.getStackTrace();
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "처리중 오류가 발생하였습니다.");
		}
		rtn = om.writeValueAsString(rtnMap);
		System.out.println(rtnMap);
		return rtn;
	}

	
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
				rtnMap.put("RESULTMSG", "삭제할 권한이 없습니다.");
			}
		}catch(Exception e) {
			e.getStackTrace();
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "처리중 오류가 발생하였습니다.");
		}
		rtn = om.writeValueAsString(rtnMap);
		System.out.println(rtnMap);
		return rtn;
	}

}
