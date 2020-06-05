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

import egovframework.com.auth.dao.AuthGrpInfoService;
import egovframework.com.auth.dao.AuthGrpInputParamVo;
import egovframework.com.auth.dao.AuthGrpVo;
import egovframework.com.auth.dao.lgnplcyVo;
import egovframework.com.cmm.ComUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "AuthgrpinfoController", description = "권한그룹 정보 관리 REST APddddddddddI")
@RequestMapping("/authgrp")
public class AuthGrpInfoController {
	
	@Autowired
	AuthGrpInfoService authGrpService;
	
	@ApiOperation(value = "권한그룹목록 조회")
	@GetMapping(path = "/list")
	public String AutGrphList() {
		
		String rtn 							= "";
		Map<String, Object> rtnMap 	= new HashMap<String, Object>();
		ObjectMapper om 				= new ObjectMapper();

		try {
			List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
			lst = authGrpService.selectAuthGrpList();
			System.out.println(lst);
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
	
	@ApiOperation(value = "권한그룹코드 정보 조회")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "authGrpCd", value = "권한그룹코드", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
	@GetMapping(path = "/detailInfo/{authGrpCd}")
	public String AuthGrpDetailInfo(@PathVariable("authGrpCd") String authGrpCd) throws Exception {
		
		String rtn 							= "";
		ObjectMapper om 				= new ObjectMapper();
		Map<String, Object> rtnMap 	= new HashMap<String, Object>();
		
		try {
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("AUTHGRPCD", URLDecoder.decode(authGrpCd		,"UTF-8"));
			
			rtnMap = authGrpService.selectAuthGrpDetail(sqlInpt);
			System.out.println(rtnMap);
			if(rtnMap==null) {
				rtnMap = new HashMap<String, Object>();
				rtnMap.put("RESULTCD", "0");
				rtnMap.put("RESULTMSG", "대상건이 없습니다.");
			}else {
				rtnMap.put("RESULTCD", "0");
				rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
			}
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
	
	@ApiOperation(value = "권한그룹 정보 등록", notes = "권한그룹을 등록합니다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
	@PostMapping(path = "/addnew")
	public String InsertAuthGrpInfo(@RequestBody AuthGrpVo param) throws Exception {

		String rtn 							= "";
		ObjectMapper om 				= new ObjectMapper();
		Map<Object, Object> rtnMap 	= new HashMap<Object, Object>();
		
		try {
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
	
			//입력값 파라미터 정의
			sqlInpt.put("AUTHGRPCD"	, param.getAuthGrpCd());
			sqlInpt.put("AUTHGRPNM"	, param.getAuthGrpNm());
			sqlInpt.put("AUTHGRPDC"	, param.getAuthGrpDc());
			
			int rowCnt = authGrpService.selectAuthGrpInfoCnt(sqlInpt);
			System.out.println(rowCnt);
			
			if(rowCnt == 0) {
				int inputCnt = authGrpService.insertAuthGrpInfo(sqlInpt);
				if(inputCnt > 0) {
					rtnMap.put("RESULTCD", "0");
					rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
				}else {
					rtnMap.put("RESULTCD", "1");
					rtnMap.put("RESULTMSG", "등록에 실패 하였습니다.");
				}
			}else {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "중복되는 권한그룹코드가 있습니다.");
			}
		}catch (Exception e) {
			e.getStackTrace();
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "처리중 오류가 발생하였습니다.");
		}
		rtn = om.writeValueAsString(rtnMap);
		System.out.println(rtnMap);
		return rtn;
	}

	
	@ApiOperation(value = "권한그룹 정보수정", notes = "권한그룹 정보를 수정한다.")
	@PutMapping(path = "/modifyInfo")
	public String AuthGrpChangeInfo(@RequestBody AuthGrpVo param) throws Exception {
		
		String rtn 							= "";
		ObjectMapper om 				= new ObjectMapper();
		Map<Object, Object> rtnMap 	= new HashMap<Object, Object>();
		
		try {
			//입력값 파라미터 정의
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("AUTHGRPCD"	, param.getAuthGrpCd());
			sqlInpt.put("AUTHGRPNM"	, param.getAuthGrpNm());
			sqlInpt.put("AUTHGRPDC"	, param.getAuthGrpDc());
	
			int inputCnt = authGrpService.updateAuthGrpInfo(sqlInpt);
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
		System.out.println(rtnMap);
		return rtn;
	}
	
	
	@ApiOperation(value = "권한그룹 삭제", notes = "권한그룹을 삭제한다.")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "authGrpCd"	, value = "권한그룹코드"	, required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK !!"),
        @ApiResponse(code = 500, message = "Internal Server Error !!"),
        @ApiResponse(code = 404, message = "Not Found !!")
    })
	@DeleteMapping(path = "/delete")
	public String AuthGrpDeleteInfo(@RequestParam(value = "authGrpCd") String authGrpCd) throws Exception {
		
		String rtn 							= "";
		ObjectMapper om 				= new ObjectMapper();
		Map<Object, Object> rtnMap 	= new HashMap<Object, Object>();
		
		String pAuthGrpCd = URLDecoder.decode(authGrpCd,"UTF-8");
		try {
			//입력값 파라미터 정의
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("AUTHGRPCD"	, pAuthGrpCd);
			
			int inputCnt = authGrpService.deleteAuthGrpInfo(sqlInpt);
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
		System.out.println(rtnMap);
		return rtn;
	}
	
	
	
	
	
	
	
	/*권한 그룹 정보 관리*/
	/*권한 그룹 정보 관리*/
	/*권한 그룹 정보 관리*/
	/*권한 그룹 정보 관리*/
	
	@ApiOperation(value = "권한그룹 권한 목록조회")
	@PostMapping(path = "/gAuthList")
	public String GrpAuthList(@RequestBody AuthGrpInputParamVo param) throws Exception {
		
		String rtn 										= "";
		ComUtil cu 										= new ComUtil();
		ObjectMapper om 							= new ObjectMapper();
		Map<String, Object> rtnMap 				= new HashMap<String, Object>();
		List<HashMap<Object, Object>> lst 	= new ArrayList<HashMap<Object, Object>>();

		try {
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("AUTHGRPCD", 		URLDecoder.decode(param.getGrpAuthCd(),		"UTF-8"));
			sqlInpt.put("PAGE", 				param.getPage());
			sqlInpt.put("PAGESIZE", 		param.getPageSize());
			
			lst = authGrpService.selectGrpAuthList(sqlInpt);
			
			rtnMap.put("page", 			param.getPage());
			rtnMap.put("pageSize", 		param.getPageSize());
			rtnMap.put("totalCount", 	lst.size());
			
			if(param.getPage() > 0 && param.getPage() > 0) { //페이징관련 파라미터가 있을 경우만 페이징 처리 
				rtnMap.put("list", cu.listforPaging(lst, param.getPage(),param.getPageSize()));
			}else {
				rtnMap.put("list", lst);
			}
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
		} catch(Exception e) {
			System.out.println(e);
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

	
	@ApiOperation(value = "권한그룹에 권한 등록", notes = "권한그룹에 권한을 등록합니다.")
	@PostMapping(path = "/gAuthAdd")
	public String InsertGrpAuth(@RequestBody AuthGrpInputParamVo param) throws Exception {
 
		String rtn 							= "";
		ObjectMapper om 				= new ObjectMapper();
		Map<Object, Object> rtnMap 	= new HashMap<Object, Object>();
		
		try {
			//입력값 파라미터 정의
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("AUTHGRPCD", 	URLDecoder.decode(param.getGrpAuthCd(),	"UTF-8"));
			sqlInpt.put("AUTHCD",		URLDecoder.decode(param.getAuthCd(),		"UTF-8"));
			
			int rowCnt = authGrpService.selectGrpAuthCnt(sqlInpt);
			System.out.println(rowCnt);

			if(rowCnt == 0) {
				int inputCnt = authGrpService.insertGrpAuth(sqlInpt);
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


	@ApiOperation(value = "권한그룹 권한 삭제", notes = "권한그룹에 등록된 권한을 삭제한다.")
	@DeleteMapping(path = "/gAuthSbt")
	public String DeleteGrpAuth(@RequestBody AuthGrpInputParamVo param) throws Exception {
		
		String rtn 							= "";
		ObjectMapper om 				= new ObjectMapper();
		Map<Object, Object> rtnMap 	= new HashMap<Object, Object>();
		
		String pGrpAuth 	= URLDecoder.decode(param.getGrpAuthCd(),	"UTF-8");
		String pAuth 		= URLDecoder.decode(param.getAuthCd(),		"UTF-8");
		
		try {
			//입력값 파라미터 정의
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("AUTHGRPCD"		, pGrpAuth);
			sqlInpt.put("AUTHCD"			, pAuth);
			
			int inputCnt = authGrpService.deleteGrpAuth(sqlInpt);
			if(inputCnt > 0) {
				rtnMap.put("RESULTCD", "0");
				rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
			}else {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "회수 할 권한이 없습니다.");
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

	

	
	
	/*권한 그룹 사용자 정보 관리*/
	/*권한 그룹 사용자 정보 관리*/
	/*권한 그룹 사용자 정보 관리*/
	/*권한 그룹 사용자 정보 관리*/
	
	@ApiOperation(value = "권한그룹 사용자 목록조회")
	@PostMapping(path = "/uAuthGrpList")
	public String GrpAuthUsrList(@RequestBody AuthGrpInputParamVo param) throws Exception {
		
		String rtn 										= "";
		ComUtil cu 										= new ComUtil();
		ObjectMapper om 							= new ObjectMapper();
		Map<String, Object> rtnMap 				= new HashMap<String, Object>();
		List<HashMap<Object, Object>> lst 	= new ArrayList<HashMap<Object, Object>>();

		try {
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("AUTHGRPCD", 		URLDecoder.decode(param.getGrpAuthCd(),		"UTF-8"));
			sqlInpt.put("PAGE", 				param.getPage());
			sqlInpt.put("PAGESIZE", 		param.getPageSize());
			
			lst = authGrpService.selectGrpAuthUsrList(sqlInpt);
			
			rtnMap.put("page", 			param.getPage());
			rtnMap.put("pageSize", 		param.getPageSize());
			rtnMap.put("totalCount", 	lst.size());
			
			if(param.getPage() > 0 && param.getPage() > 0) { //페이징관련 파라미터가 있을 경우만 페이징 처리 
				rtnMap.put("list", cu.listforPaging(lst, param.getPage(),param.getPageSize()));
			}else {
				rtnMap.put("list", lst);
			}
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
		} catch(Exception e) {
			System.out.println(e);
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

	
	@ApiOperation(value = "권한그룹 목록을 사용자에게 부여", notes = "권한그룹 단위로 사용자에게 부여합니다.")
	@PostMapping(path = "/uAuthGrpAdd")
	public String InsertGrpAuthUsr(@RequestParam(value = "authGrpCd") String authGrpCd, @RequestParam(value = "usrId") String usrId) throws Exception {
 
		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		
		try {
			//입력값 파라미터 정의
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("AUTHGRPCD"	,URLDecoder.decode(authGrpCd	,"UTF-8"));
			sqlInpt.put("USRID"			,URLDecoder.decode(usrId			,"UTF-8"));

			
			int inputCnt = authGrpService.insertGrpAuthUsr(sqlInpt);
			int updateCnt = authGrpService.updateGrpAuthUsr(sqlInpt);
				
			if((inputCnt +updateCnt )> 0) {
				rtnMap.put("RESULTCD", "0");
				rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
			}else {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "등록에 실패 하였습니다.");
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


	@ApiOperation(value = "권한그룹 권한 삭제", notes = "권한그룹에 등록된 권한을 삭제한다.")
	@DeleteMapping(path = "/uAuthGrpSbt")
	public String DeleteGrpAuthUsr(@RequestBody AuthGrpInputParamVo param) throws Exception {
		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		
		String pGrpAuth 	= URLDecoder.decode(param.getGrpAuthCd(),	"UTF-8");
		String pAuth 		= URLDecoder.decode(param.getAuthCd(),		"UTF-8");
		
		try {
			//입력값 파라미터 정의
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("AUTHGRPCD"		, pGrpAuth);
			sqlInpt.put("AUTHCD"			, pAuth);
			
			int inputCnt = authGrpService.deleteGrpAuth(sqlInpt);
			if(inputCnt > 0) {
				rtnMap.put("RESULTCD", "0");
				rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
			}else {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "회수 할 권한이 없습니다.");
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
	

	@ApiOperation(value = "권한그룹 권한 삭제", notes = "권한그룹에 등록된 권한을 삭제한다.")
	@DeleteMapping(path = "/uAuthGffffffrpSbt")
	public String DeleteGrpAudddthUsr(@RequestBody lgnplcyVo param) throws Exception {
		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		
		String pGrpAuth 	= "";
		String pAuth 		= "";
		
		try {
			//입력값 파라미터 정의
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("AUTHGRPCD"		, pGrpAuth);
			sqlInpt.put("AUTHCD"			, pAuth);
			
			int inputCnt = authGrpService.deleteGrpAuth(sqlInpt);
			if(inputCnt > 0) {
				rtnMap.put("RESULTCD", "0");
				rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
			}else {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "회수 할 권한이 없습니다.");
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
