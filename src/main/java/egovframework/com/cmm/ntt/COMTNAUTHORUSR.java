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
public class COMTNAUTHORUSR implements Serializable {
	/***************************************
		 CREATE TABLE COMTNAUTHORUSR
		 (
		 	AUTHOR_CODE VARCHAR(30) NOT NULL COMMENT '권한코드',
		 	USR_ID VARCHAR(20) NOT NULL COMMENT '사용자ID',
		 	AUTHOR_GRP_CODE VARCHAR(30) COMMENT '권한그룹코드',
		 	ADD_DT VARCHAR(14) NOT NULL COMMENT '등록일시',
		 	PRIMARY KEY (AUTHOR_CODE,USR_ID)
		 ) COMMENT '권한사용자' ;
	 ***************************************/
    @Id
    @Column(columnDefinition = "VARCHAR(30) NOT NULL COMMENT '권한코드'")
    private String AUTHOR_CODE;
    
    @Id
    @Column(columnDefinition = "VARCHAR(20) NOT NULL COMMENT '사용자ID'")
    private String USR_ID;

    @Column(columnDefinition = "VARCHAR(30) COMMENT '권한그룹코드'")
    private String AUTHOR_GRP_CODE;

    @Column(columnDefinition = "VARCHAR(14) NOT NULL COMMENT '등록일시'")
    private String ADD_DT;

}
