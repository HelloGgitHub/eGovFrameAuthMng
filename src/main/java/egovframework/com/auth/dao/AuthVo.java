package egovframework.com.auth.dao;

/**
 * @title : 권한코드 관리 입출력 Vo 
 * @package : egovframework.com.auth.dao
 * @filename : AuthVo.java
 * @author : "egov"
 * @since : 2020. 6. 15.
 * @version : 1.0
 * @desc : 권한코드 관리 입출력 Vo
 * 
 *  ======= 변경이력 =======
 * 
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 15.         "egov"           최초 생성(ver 1.0)
 * 
 */
public class AuthVo {

	private String authCd;
	private String authNm;
	private String authDc;
	
	public String getAuthCd() {
		return authCd;
	}
	public void setAuthCd(String authCd) {
		this.authCd = authCd;
	}
	public String getAuthNm() {
		return authNm;
	}
	public void setAuthNm(String authNm) {
		this.authNm = authNm;
	}
	public String getAuthDc() {
		return authDc;
	}
	public void setAuthDc(String authDc) {
		this.authDc = authDc;
	}
	
}
