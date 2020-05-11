package egovframework.com.auth.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
