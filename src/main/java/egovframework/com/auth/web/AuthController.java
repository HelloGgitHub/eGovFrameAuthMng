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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "AuthController", description = "권한 정보 관리 REST API")
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	AuthInfoService authService;
	
	@ApiOperation(value = "권한목록 조회")
	@GetMapping(path = "/list")
	public String AuthList() {
		
		String rtn = "";
		ObjectMapper om = new ObjectMapper();

		List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
		lst = authService.selectAuthList();
		System.out.println(lst);
		
		try {
			rtn = om.writeValueAsString(lst);
		} catch (JsonProcessingException e) {
			rtn = "json Mapper Error.";
			e.printStackTrace();
		}
		
		return rtn;
	}
	
	@ApiOperation(value = "권한코드 정보 조회")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "authCd", value = "권한코드", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
	@GetMapping(path = "/detailInfo/{authCd}")
	public String AuthDetailInfo(@PathVariable("authCd") String authCd) throws Exception {
		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
		
		Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
		sqlInpt.put("AUTHCD", URLDecoder.decode(authCd		,"UTF-8"));
		
		lst = authService.selectAuthDetail(sqlInpt);
		System.out.println(lst);
		
		try {
			rtn = om.writeValueAsString(lst);
		} catch (JsonProcessingException e) {
			rtn = "json Mapper Error.";
			e.printStackTrace();
		}
		
		return rtn;
	}
	
	@ApiOperation(value = "권한 등록", notes = "권한을 등록합니다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
	@PostMapping(path = "/addnew")
	public String InsertAuthInfo(@RequestBody AuthVo param) throws Exception {

		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		
		//입력값 파라미터 정의
		Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
		sqlInpt.put("AUTHCD"	, param.getAuthCd());
		sqlInpt.put("AUTHNM"	, param.getAuthNm());
		sqlInpt.put("AUTHDC"	, param.getAuthDc());
		
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		int inputCnt = authService.insertAuthInfo(sqlInpt);
		if(inputCnt > 0) {
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
		}else {
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "등록에 실패 하였습니다.");
		}
		
		rtn = om.writeValueAsString(rtnMap);
		System.out.println(rtnMap);
		return rtn;
	}

	
	@ApiOperation(value = "권한 정보수정", notes = "권한정보를 수정한다.")
	@PutMapping(path = "/modifyInfo")
	public String AuthChangeInfo(@RequestBody AuthVo param) throws Exception {
		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		
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
			rtnMap.put("RESULTMSG", "사용자 정보 변경에 실패 하였습니다.");
		}
		
		rtn = om.writeValueAsString(rtnMap);
		System.out.println(rtnMap);
		return rtn;
	}
	
	
	@ApiOperation(value = "권한 삭제", notes = "권한을 삭제한다.")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "groupId"	, value = "그룹ID"	, required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK !!"),
        @ApiResponse(code = 500, message = "Internal Server Error !!"),
        @ApiResponse(code = 404, message = "Not Found !!")
    })
	@DeleteMapping(path = "/deleteAuth")
	public String AuthDeleteInfo(@RequestParam(value = "authCd") String authCd) throws Exception {
		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		
		String pAuthCd = URLDecoder.decode(authCd,"UTF-8");
		
		//입력값 파라미터 정의
		Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
		sqlInpt.put("AUTHCD"	, pAuthCd);
		
		int inputCnt = authService.deleteAuthInfo(sqlInpt);
		if(inputCnt > 0) {
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
		}else {
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "삭제에 실패 하였습니다.");
		}
		
		rtn = om.writeValueAsString(rtnMap);
		System.out.println(rtnMap);
		return rtn;
	}
	
}
