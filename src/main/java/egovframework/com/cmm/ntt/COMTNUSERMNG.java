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
public class COMTNUSERMNG implements Serializable {
	/***************************************
		 CREATE TABLE COMTNUSERMNG
		 (
		 	USR_ID               		VARCHAR(20) NOT NULL COMMENT '사용자ID',
		 	PASSWORD              VARCHAR(200) NOT NULL COMMENT '비밀번호',
		 	PASSWORD_HINT      VARCHAR(100) COMMENT '비밀번호힌트',
		 	PASSWORD_CNSR     VARCHAR(100) COMMENT '비밀번호정답',
		 	USR_NM               	VARCHAR(50) COMMENT '사용자명',
		 	ZIP                   		VARCHAR(6) COMMENT '우편번호',
		 	ADRES                 	VARCHAR(100)COMMENT '주소' ,
		 	AREA_NO               	VARCHAR(4) COMMENT '지역번호',
		 	USR_STTUS           	VARCHAR(15) COMMENT '사용자상태',
		 	DETAIL_ADRES         VARCHAR(100) COMMENT '상세주소',
		 	END_TELNO             	VARCHAR(4) COMMENT '끝전화번호' ,
		 	MBTLNUM               	VARCHAR(20) COMMENT '이동전화번호' ,
		 	USR_FXNUM           	VARCHAR(20) COMMENT '회원팩스번호' ,
		 	USR_EMAIL_ADRES  	VARCHAR(50) COMMENT '회원이메일주소',
		 	MIDDLE_TELNO         VARCHAR(4) COMMENT '중간전화번호',
		 	SBSCRB_DE             	VARCHAR(14) COMMENT '가입일자',
		 	SEXDSTN_CODE      	VARCHAR(1) COMMENT '성별코드',
		 	ESNTL_ID              	VARCHAR(20) COMMENT '고유ID',
		 	LOCK_AT               	VARCHAR(1) COMMENT '잠금여부',
		 	LOCK_CNT              	NUMERIC(3) COMMENT '잠금회수',
		 	LOCK_LAST_PNTTM   VARCHAR(14) COMMENT '잠금최종시점',
		 	CHANGE_DT					VARCHAR(14) COMMENT '변경일시',
		 	 PRIMARY KEY (USR_ID)
		 );
	 ***************************************/
    @Id
    @Column(columnDefinition = "VARCHAR(20) NOT NULL COMMENT '사용자ID'")
    private String USR_ID;

    @Column(columnDefinition = "VARCHAR(200) NOT NULL COMMENT '비밀번호'")
    private String PASSWORD;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '비밀번호힌트'")
    private String PASSWORD_HINT;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '비밀번호정답'")
    private String PASSWORD_CNSR;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '사용자명'")
    private String USR_NM;

    @Column(columnDefinition = "VARCHAR(6) COMMENT '우편번호'")
    private String ZIP;

    @Column(columnDefinition = "VARCHAR(100)COMMENT '주소'")
    private String ADRES;

    @Column(columnDefinition = "VARCHAR(4) COMMENT '지역번호'")
    private String AREA_NO;

    @Column(columnDefinition = "VARCHAR(15) COMMENT '사용자상태'")
    private String USR_STTUS;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '상세주소'")
    private String DETAIL_ADRES;

    @Column(columnDefinition = "VARCHAR(4) COMMENT '끝전화번호'")
    private String END_TELNO;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '이동전화번호'")
    private String MBTLNUM;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '회원팩스번호'")
    private String USR_FXNUM;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '회원이메일주소'")
    private String USR_EMAIL_ADRES;

    @Column(columnDefinition = "VARCHAR(4) COMMENT '중간전화번호'")
    private String MIDDLE_TELNO;

    @Column(columnDefinition = "VARCHAR(14) COMMENT '가입일자'")
    private String SBSCRB_DE;

    @Column(columnDefinition = "VARCHAR(1) COMMENT '성별코드'")
    private String SEXDSTN_CODE;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '고유ID'")
    private String ESNTL_ID;

    @Column(columnDefinition = "VARCHAR(1) COMMENT '잠금여부'")
    private String LOCK_AT;

    @Column(columnDefinition = "NUMERIC(3) COMMENT '잠금회수'")
    private String LOCK_CNT;

    @Column(columnDefinition = "VARCHAR(14) COMMENT '잠금최종시점'")
    private String LOCK_LAST_PNTTM;

    @Column(columnDefinition = "VARCHAR(14) COMMENT '변경일시'")
    private String CHANGE_DT;

}
