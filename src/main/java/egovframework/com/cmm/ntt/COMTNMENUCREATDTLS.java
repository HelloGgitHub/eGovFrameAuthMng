package egovframework.com.cmm.ntt;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class COMTNMENUCREATDTLS implements Serializable {
	/***************************************
		 CREATE TABLE COMTNMENUCREATDTLS
		 (
		   MENU_NO 				DECIMAL(20,0) 	NOT NULL COMMENT '메뉴번호',
		   AUTHOR_GRP_CODE 		VARCHAR(30) 	NOT NULL COMMENT '권한그룹코드',
		   MAPNG_CREAT_ID 	VARCHAR(30) 	COMMENT '매핑생성ID',
		   PRIMARY KEY (`MENU_NO`,`AUTHOR_GRP_CODE`)
		 ) COMMENT '메뉴생성내역';
	 ***************************************/
	
    @Id
	@Column(columnDefinition = "DECIMAL(20,0) NOT NULL COMMENT '메뉴번호'")
    private String MENU_NO;

    @Id
    @Column(columnDefinition = "VARCHAR(30) NOT NULL COMMENT '권한그룹코드'")
    private String AUTHOR_GRP_CODE;

    @Column(columnDefinition = "VARCHAR(30) COMMENT '매핑생성ID'")
    private String MAPNG_CREAT_ID;

}
