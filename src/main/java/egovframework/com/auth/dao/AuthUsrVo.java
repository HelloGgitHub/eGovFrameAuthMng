package egovframework.com.auth.dao;

/**
 * @title : 권한 사용자 매핑 관리 Vo 
 * @package : egovframework.com.auth.dao
 * @filename : AuthUsrVo.java
 * @author : "egov"
 * @since : 2020. 6. 15.
 * @version : 1.0
 * @desc : 권한 사용자 매핑 관리 Vo
 * 
 *  ======= 변경이력 =======
 * 
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 15.         "egov"           최초 생성(ver 1.0)
 * 
 */
public class AuthUsrVo {

	private String authCd;
	private String usrId;
	private String authGrpCd;

	public String getAuthCd() {
		return authCd;
	}

	public String getUsrId() {
		return usrId;
	}

	public String getAuthGrpCd() {
		return authGrpCd;
	}

	public void setAuthCd(String authCd) {
		this.authCd = authCd;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public void setAuthGrpCd(String authGrpCd) {
		this.authGrpCd = authGrpCd;
	}
}
