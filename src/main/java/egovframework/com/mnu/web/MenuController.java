package egovframework.com.mnu.web;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.auth.dao.AuthVo;
import egovframework.com.cmm.ComUtil;
import egovframework.com.mnu.dao.MenuService;
import egovframework.com.mnu.dao.MenuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @title : 메뉴 관리 
 * @package : egovframework.com.mnu.web
 * @filename : MenuController.java
 * @author : "egov"
 * @since : 2020. 8. 05.
 * @version : 1.0
 * @desc : 메뉴를 관리하는 기능 모음.
 * 
 *  ======= 변경이력 =======
 * 
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 8. 5.         "egov"           최초 생성(ver 1.0)
 * 
 */
@RestController
@Api(value = "MenuController", description = "메뉴 관리 REST API")
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	/**
	 * @name : AuthList(메뉴목록 조회)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @throws Exception 
	 * @return_type : String
	 * @desc : 메뉴 목록을 조회한다.
	 */
	@ApiOperation(value = "메뉴 트리 생성을 위한 메뉴목록 조회")
	@GetMapping(path = "/makelist")
	public String MenuList() throws Exception {
		String rtn = "";
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		ObjectMapper om = new ObjectMapper();

		try {
			List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
			lst = menuService.selectMakeMenuList();
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
	 * @name : InsertMenuInfo(메뉴등록)
	 * @date : 2020. 8. 5.
	 * @author : "egov"
	 * @return_type : String
	 * @desc : 메뉴를 등록한다.
	 */
	@ApiOperation(value = "메뉴등록", notes = "메뉴을 등록합니다.")
	@PostMapping(path = "/addnew")
	public String InsertMenuInfo(@RequestBody MenuVo param) throws Exception {

		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		
		try {
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
	
			sqlInpt.put("MENU_NM"            , param.getMenuNm() );
			sqlInpt.put("PROGRM_FILE_NM"     , param.getProgrmFileNm() );
			sqlInpt.put("MENU_NO"            , param.getMenuNo() );
			sqlInpt.put("UPPER_MENU_NO"      , param.getUpperMenuNo() );
			sqlInpt.put("MENU_ORDR"          , param.getMenuOrdr() );
			sqlInpt.put("MENU_DC"            , param.getMenuDc() );
			sqlInpt.put("RELATE_IMAGE_PATH"  , param.getRelateImagePath() );
			sqlInpt.put("RELATE_IMAGE_NM"    , param.getRelateImageNm() );
			
			int rowCnt = menuService.selectMenuCnt(sqlInpt);
			if(rowCnt == 0) {
				int inputCnt = menuService.insertMenu(sqlInpt);
				if(inputCnt > 0) {
					rtnMap.put("RESULTCD", "0");
					rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
				}else {
					rtnMap.put("RESULTCD", "1");
					rtnMap.put("RESULTMSG", "등록에 실패 하였습니다.");
				}
			}else {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "중복되는 메뉴 번호가 있습니다.");
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
	 * @name : MenuChange(메뉴 정보 수정)
	 * @date : 2020. 8. 5.
	 * @author : "egov"
	 * @return_type : String
	 * @desc : 메뉴 정보 내용을 수정한다.
	 */
	@ApiOperation(value = "메뉴 정보수정", notes = "메뉴정보를 수정한다.")
	@PutMapping(path = "/modifyInfo")
	public String MenuChange(@RequestBody MenuVo param) throws Exception {
		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		try {
			//입력값 파라미터 정의
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("MENU_NM"            , param.getMenuNm() );
			sqlInpt.put("PROGRM_FILE_NM"     , param.getProgrmFileNm() );
			sqlInpt.put("MENU_NO"            , param.getMenuNo() );
			sqlInpt.put("UPPER_MENU_NO"      , param.getUpperMenuNo() );
			sqlInpt.put("MENU_ORDR"          , param.getMenuOrdr() );
			sqlInpt.put("MENU_DC"            , param.getMenuDc() );
			sqlInpt.put("RELATE_IMAGE_PATH"  , param.getRelateImagePath() );
			sqlInpt.put("RELATE_IMAGE_NM"    , param.getRelateImageNm() );
			
			int inputCnt = menuService.updateMenu(sqlInpt);
			if(inputCnt > 0) {
				rtnMap.put("RESULTCD", "0");
				rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
			}else {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "등록된 메뉴가 없습니다.");
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
	 * @name : MenuDelete(권한삭제)
	 * @date : 2020. 6. 15.
	 * @author : "egov"
	 * @return_type : String
	 * @desc : 메뉴 삭제 한다.
	 */
	@ApiOperation(value = "메뉴 삭제", notes = "메뉴를 삭제한다.")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "menuNo", value = "메뉴번호",  required = true, dataType = "int", paramType = "query", defaultValue = "")
    })
	@DeleteMapping(path = "/delete")
	public String MenuDelete(@RequestParam(value = "menuNo") int menuNo) throws Exception {
		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		
		try {
			//입력값 파라미터 정의
			Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
			sqlInpt.put("MENU_NO"            , menuNo );
			
			int inputCnt = menuService.deleteMenu(sqlInpt);
			if(inputCnt > 0) {
				rtnMap.put("RESULTCD", "0");
				rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
			}else {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "삭제할 메뉴가 없습니다.");
			}
		}catch (Exception e) {
			e.printStackTrace();
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "처리중 오류가 발생하였습니다.");
		}
		rtn = om.writeValueAsString(rtnMap);
		return rtn;
	}

}
