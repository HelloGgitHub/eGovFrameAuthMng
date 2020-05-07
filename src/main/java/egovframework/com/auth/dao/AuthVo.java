package egovframework.com.auth.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
