package egovframework.com.auth.dao;

/**
 * @title : 사용자 로그인 입출력 Vo
 * @package : egovframework.com.user.dao
 * @filename : UserVo.java
 * @author : "egov"
 * @since : 2020. 6. 12.
 * @version : 1.0
 * @desc : 사용자 관리 입출력 항목
 * 
 *  ======= 변경이력 =======
 * 
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 12.         "egov"           최초 생성(ver 1.0)
 * 
 */
public class UserVo {

	private String usrId;
	private String usrNm;
	private String password;
	
	
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getUsrNm() {
		return usrNm;
	}
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
