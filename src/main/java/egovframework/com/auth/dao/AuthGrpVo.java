package egovframework.com.auth.dao;

/**
 * @title : 그룹권한 입출력 Vo 
 * @package : egovframework.com.auth.dao
 * @filename : AuthGrpVo.java
 * @author : "egov"
 * @since : 2020. 6. 15.
 * @version : 1.0
 * @desc : 그룹 권한 입출력 Vo
 * 
 *  ======= 변경이력 =======
 * 
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 15.         "egov"           최초 생성(ver 1.0)
 * 
 */
public class AuthGrpVo {

	private String authGrpCd;
	private String authGrpNm;
	private String authGrpDc;
	
	
	public String getAuthGrpCd() {
		return authGrpCd;
	}
	public void setAuthGrpCd(String authGrpCd) {
		this.authGrpCd = authGrpCd;
	}
	public String getAuthGrpNm() {
		return authGrpNm;
	}
	public void setAuthGrpNm(String authGrpNm) {
		this.authGrpNm = authGrpNm;
	}
	public String getAuthGrpDc() {
		return authGrpDc;
	}
	public void setAuthGrpDc(String authGrpDc) {
		this.authGrpDc = authGrpDc;
	}
	
}
