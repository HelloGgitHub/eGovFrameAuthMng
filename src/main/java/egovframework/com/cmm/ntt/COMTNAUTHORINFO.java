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
public class COMTNAUTHORINFO implements Serializable {
	/***************************************
		  CREATE TABLE COMTNAUTHORINFO
		  (
		  	AUTHOR_CODE VARCHAR(30) NOT NULL COMMENT '권한코드',
		  	AUTHOR_NM VARCHAR(60) COMMENT '권한명',
		  	AUTHOR_DC VARCHAR(200) COMMENT '권한설명',
		  	AUTHOR_CREAT_DT VARCHAR(14) NOT NULL COMMENT '권한생성일시',
		  	CHANGE_DT VARCHAR(14) NOT NULL COMMENT '변경일시',
		  	PRIMARY KEY (AUTHOR_CODE)
		  ) COMMENT '권한정보';
	 ***************************************/
    @Id
    @Column(columnDefinition = "VARCHAR(30) NOT NULL COMMENT '권한코드'")
    private String AUTHOR_CODE;
    
    @Column(columnDefinition = "VARCHAR(60) COMMENT '권한명'")
    private String AUTHOR_NM;

    @Column(columnDefinition = "VARCHAR(200) COMMENT '권한설명'")
    private String AUTHOR_DC;

    @Column(columnDefinition = "VARCHAR(14) NOT NULL COMMENT '권한생성일시'")
    private String AUTHOR_CREAT_DT;

    @Column(columnDefinition = "VARCHAR(14) NOT NULL COMMENT '변경일시'")
    private String CHANGE_DT;

}
