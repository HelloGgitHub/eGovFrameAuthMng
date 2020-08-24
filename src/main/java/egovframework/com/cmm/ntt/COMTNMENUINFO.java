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
public class COMTNMENUINFO implements Serializable {
	/***************************************
		 CREATE TABLE COMTNMENUINFO
		 (
		   `MENU_NO` DECIMAL(20,0) NOT NULL COMMENT '메뉴번호',
		   `MENU_NM` VARCHAR(60) NOT NULL COMMENT '메뉴명',
		   `PROGRM_FILE_NM` VARCHAR(60) NOT NULL COMMENT '프로그램파일명',
		   `UPPER_MENU_NO` DECIMAL(20,0) COMMENT '상위메뉴번호',
		   `MENU_ORDR` DECIMAL(5,0) NOT NULL COMMENT '메뉴순서',
		   `MENU_DC` VARCHAR(250) COMMENT '메뉴설명',
		   `RELATE_IMAGE_PATH` VARCHAR(100) COMMENT '관계이미지경로',
		   `RELATE_IMAGE_NM` VARCHAR(60) COMMENT '관계이미지명',
		   PRIMARY KEY (`MENU_NO`)
		 ) COMMENT '메뉴정보' ;
	 ***************************************/
	
    @Id
	@Column(columnDefinition = "DECIMAL(20,0) NOT NULL COMMENT '메뉴번호'")
    private String MENU_NO;

    @Column(columnDefinition = "VARCHAR(60) NOT NULL COMMENT '메뉴명'")
    private String MENU_NM;

    @Column(columnDefinition = "VARCHAR(60) NOT NULL COMMENT '프로그램파일명'")
    private String PROGRM_FILE_NM;

    @Column(columnDefinition = "DECIMAL(20,0) COMMENT '상위메뉴번호'")
    private String UPPER_MENU_NO;

    @Column(columnDefinition = "DECIMAL(5,0) NOT NULL COMMENT '메뉴순서'")
    private String MENU_ORDR;

    @Column(columnDefinition = "VARCHAR(250) COMMENT '메뉴설명'")
    private String MENU_DC;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '관계이미지경로'")
    private String RELATE_IMAGE_PATH;

    @Column(columnDefinition = "VARCHAR(60) COMMENT '관계이미지명'")
    private String RELATE_IMAGE_NM;

}
