package egovframework.com.auth.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
