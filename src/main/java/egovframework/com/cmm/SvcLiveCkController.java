package egovframework.com.cmm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @title : 사용자 정보 관리 서비스 체크
 * @package : egovframework.com.cmm
 * @filename : SvcLiveCkController.java
 * @author : "egov"
 * @since : 2020. 7. 08.
 * @version : 1.0
 * @desc : 사용자정보 관리 서비스 동작 체크.
 * 
 *  ======= 변경이력 =======
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 7. 8.         "egov"           최초 생성(ver 1.0)
 * 
 */
@RestController
@Api(value = "SvcLiveCkController", description = "서비스 체크 REST API")
@RequestMapping("/svc")
public class SvcLiveCkController {
	
	
	/**
	 * @name : SvcLiveCk
	 * @date : 2020. 7. 08.
	 * @author : "egov"
	 * @throws Exception 
	 * @return_type : String
	 * @desc : 사용자 정보 관리 서비스 체크
	 */
	@ApiOperation(value = "사용자 정보관리 서비스 체크")
	@GetMapping(path = "/ck")
	public String SvcLiveCk() throws Exception {
		String rtn = "Ok";
		return rtn;
	}
	
	
}
