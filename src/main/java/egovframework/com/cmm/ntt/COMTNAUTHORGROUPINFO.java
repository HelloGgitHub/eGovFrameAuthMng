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
public class COMTNAUTHORGROUPINFO implements Serializable {
	/***************************************
		 CREATE TABLE COMTNAUTHORGROUPINFO
		 (
		 	AUTHOR_GRP_CODE         VARCHAR(30) NOT NULL COMMENT '권한그룹코드',
		 	AUTHOR_GRP_NM           VARCHAR(60) COMMENT '권한그룹명',
		 	AUTHOR_GRP_DC           VARCHAR(200) COMMENT '권한그룹설명',
		 	AUTHOR_GRP_CREAT_DT     VARCHAR(14) COMMENT '권한그룹생성일시',
		 	CHANGE_DT               VARCHAR(14) NOT NULL COMMENT '변경시간',
		 	PRIMARY KEY (AUTHOR_GRP_CODE)
		 ) COMMENT '권한그룹정보' ;
	 ***************************************/
    @Id
	@Column(columnDefinition = "VARCHAR(30) NOT NULL COMMENT '권한그룹코드'")
    private String AUTHOR_GRP_CODE;

    @Column(columnDefinition = "VARCHAR(60) COMMENT '권한그룹명'")
    private String AUTHOR_GRP_NM;

    @Column(columnDefinition = "VARCHAR(200) COMMENT '권한그룹설명'")
    private String AUTHOR_GRP_DC;

    @Column(columnDefinition = "VARCHAR(14) COMMENT '권한그룹생성일시'")
    private String AUTHOR_GRP_CREAT_DT;

    @Column(columnDefinition = "VARCHAR(14) NOT NULL COMMENT '변경시간'")
    private String CHANGE_DT;

}
