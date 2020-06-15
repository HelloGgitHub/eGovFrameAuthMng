package egovframework.com.auth.dao;

/**
 * @title : 권한관리 입출력 Vo 
 * @package : egovframework.com.auth.dao
 * @filename : AuthInputParamVo.java
 * @author : "egov"
 * @since : 2020. 6. 15.
 * @version : 1.0
 * @desc : 권한관리 입출력 Vo
 * 
 *  ======= 변경이력 =======
 * 
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 15.         "egov"           최초 생성(ver 1.0)
 * 
 */
public class AuthInputParamVo {

	private int pageSize;
	private int page;
	
	private String UsrId;
	private String authCd;
	
	
	public String getUsrId() {
		return UsrId;
	}
	public void setUsrId(String usrId) {
		UsrId = usrId;
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
	
	public String getAuthCd() {
		return authCd;
	}
	public void setAuthCd(String authCd) {
		this.authCd = authCd;
	}
	
}
