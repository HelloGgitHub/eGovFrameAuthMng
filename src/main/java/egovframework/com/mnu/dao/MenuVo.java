package egovframework.com.mnu.dao;

/**
 * @title : 메뉴관리 입출력 Vo 
 * @package : egovframework.com.mnu.dao
 * @filename : MenuVo.java
 * @author : "egov"
 * @since : 2020. 8. 5.
 * @version : 1.0
 * @desc : 메뉴관리 입출력 Vo
 * 
 *  ======= 변경이력 =======
 * 
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 8. 5.         "egov"           최초 생성(ver 1.0)
 * 
 */
public class MenuVo {

	private String menuNm;
	private String progrmFileNm;
	private int menuNo;
	private int upperMenuNo;
	private int menuOrdr;
	private String menuDc;
	private String relateImagePath;
	private String relateImageNm;
	
	private int menuMakeCnt;
	private String menuMakeNo;
	private String authGrpCd;
	
	
	public int getMenuMakeCnt() {
		return menuMakeCnt;
	}
	public void setMenuMakeCnt(int menuMakeCnt) {
		this.menuMakeCnt = menuMakeCnt;
	}
	public String getMenuMakeNo() {
		return menuMakeNo;
	}
	public void setMenuMakeNo(String menuMakeNo) {
		this.menuMakeNo = menuMakeNo;
	}
	public String getAuthGrpCd() {
		return authGrpCd;
	}
	public void setAuthGrpCd(String authGrpCd) {
		this.authGrpCd = authGrpCd;
	}
	public String getMenuNm() {
		return menuNm;
	}
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}
	public String getProgrmFileNm() {
		return progrmFileNm;
	}
	public void setProgrmFileNm(String progrmFileNm) {
		this.progrmFileNm = progrmFileNm;
	}
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public int getUpperMenuNo() {
		return upperMenuNo;
	}
	public void setUpperMenuNo(int upperMenuNo) {
		this.upperMenuNo = upperMenuNo;
	}
	public int getMenuOrdr() {
		return menuOrdr;
	}
	public void setMenuOrdr(int menuOrdr) {
		this.menuOrdr = menuOrdr;
	}
	public String getMenuDc() {
		return menuDc;
	}
	public void setMenuDc(String menuDc) {
		this.menuDc = menuDc;
	}
	public String getRelateImagePath() {
		return relateImagePath;
	}
	public void setRelateImagePath(String relateImagePath) {
		this.relateImagePath = relateImagePath;
	}
	public String getRelateImageNm() {
		return relateImageNm;
	}
	public void setRelateImageNm(String relateImageNm) {
		this.relateImageNm = relateImageNm;
	}

}
