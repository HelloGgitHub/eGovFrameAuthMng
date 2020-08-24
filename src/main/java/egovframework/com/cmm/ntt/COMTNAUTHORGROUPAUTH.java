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
public class COMTNAUTHORGROUPAUTH implements Serializable {
	/***************************************
		 CREATE TABLE COMTNAUTHORGROUPAUTH
		 (
		 	AUTHOR_GRP_CODE  VARCHAR(30) NOT NULL COMMENT '권한그룹코드',
		 	AUTHOR_CODE      VARCHAR(30) NOT NULL COMMENT '권한코드',
		 	ADD_DT           VARCHAR(14) NOT NULL COMMENT '등록일시',
		 	PRIMARY KEY (AUTHOR_GRP_CODE, AUTHOR_CODE)
		 ) COMMENT '권한그룹';
	 ***************************************/
	
    @Id
	@Column(columnDefinition = "VARCHAR(30) NOT NULL COMMENT '권한그룹코드'")
    private String AUTHOR_GRP_CODE;

    @Id
    @Column(columnDefinition = "VARCHAR(30) NOT NULL COMMENT '권한코드'")
    private String AUTHOR_CODE;

    @Column(columnDefinition = "VARCHAR(14) NOT NULL COMMENT '등록일시'")
    private String ADD_DT;

}
