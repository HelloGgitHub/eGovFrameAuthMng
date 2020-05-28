package egovframework.com.auth.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthGrpInputParamVo {

	private int pageSize;
	private int page;
	
	private String grpAuthCd;
	private String authCd;

	
	public String getAuthCd() {
		return authCd;
	}
	public void setAuthCd(String authCd) {
		this.authCd = authCd;
	}
	public String getGrpAuthCd() {
		return grpAuthCd;
	}
	public void setGrpAuthCd(String grpAuthCd) {
		this.grpAuthCd = grpAuthCd;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
}
