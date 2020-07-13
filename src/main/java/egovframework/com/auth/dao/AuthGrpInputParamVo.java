package egovframework.com.auth.dao;

/**
 * @title : 그룹권한 관리 입출력 Vo
 * @package : egovframework.com.auth.dao
 * @filename : AuthGrpInputParamVo.java
 * @author : "egov"
 * @since : 2020. 6. 15.
 * @version : 1.0
 * @desc : 그룹권한관리 입출력 Vo
 * 
 *  ======= 변경이력 =======
 * 
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 15.         "egov"           최초 생성(ver 1.0)
 * 
 */
public class AuthGrpInputParamVo {

	private int pageSize;
	private int page;
	
	private String grpAuthCd;
	private String authCd;
	private String userId;

	
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	
}
