package egovframework;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import egovframework.com.cmm.ComUtil;

@Component
public class DataRunner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try(Connection connection = dataSource.getConnection()){
			String sstime= ComUtil.getTime("yyyyMMddHHmmss");
//			String URL = connection.getMetaData().getURL();
//			String User = connection.getMetaData().getUserName();

            Statement statement = connection.createStatement();
            StringBuffer comtnUserMng = new StringBuffer();
            comtnUserMng.append("\n CREATE TABLE COMTNUSERMNG                       ");
            comtnUserMng.append("\n (                                               ");
            comtnUserMng.append("\n 	USR_ID               		VARCHAR(20) NOT NULL, ");
            comtnUserMng.append("\n 	PASSWORD              VARCHAR(200) NOT NULL,  ");
            comtnUserMng.append("\n 	PASSWORD_HINT      VARCHAR(100) ,             ");
            comtnUserMng.append("\n 	PASSWORD_CNSR     VARCHAR(100) ,              ");
            comtnUserMng.append("\n 	USR_NM               	VARCHAR(50) ,           ");
            comtnUserMng.append("\n 	ZIP                   		VARCHAR(6) ,        ");
            comtnUserMng.append("\n 	ADRES                 	VARCHAR(100) ,        ");
            comtnUserMng.append("\n 	AREA_NO               	VARCHAR(4) ,          ");
            comtnUserMng.append("\n 	USR_STTUS           	VARCHAR(15) ,           ");
            comtnUserMng.append("\n 	DETAIL_ADRES         VARCHAR(100) ,           ");
            comtnUserMng.append("\n 	END_TELNO             	VARCHAR(4)  ,         ");
            comtnUserMng.append("\n 	MBTLNUM               	VARCHAR(20)  ,        ");
            comtnUserMng.append("\n 	USR_FXNUM           	VARCHAR(20) ,           ");
            comtnUserMng.append("\n 	USR_EMAIL_ADRES  	VARCHAR(50) ,               ");
            comtnUserMng.append("\n 	MIDDLE_TELNO         VARCHAR(4) ,             ");
            comtnUserMng.append("\n 	SBSCRB_DE             	VARCHAR(14) ,            ");
            comtnUserMng.append("\n 	SEXDSTN_CODE      	VARCHAR(1) ,                 ");
            comtnUserMng.append("\n 	ESNTL_ID              	VARCHAR(20) ,            ");
            comtnUserMng.append("\n 	LOCK_AT               	VARCHAR(1) ,             ");
            comtnUserMng.append("\n 	LOCK_CNT              	NUMERIC(3) ,          ");
            comtnUserMng.append("\n 	LOCK_LAST_PNTTM   VARCHAR(14) ,                  ");
            comtnUserMng.append("\n 	CHANGE_DT					VARCHAR(14) ,               ");
            comtnUserMng.append("\n 	 PRIMARY KEY (USR_ID)                         ");
            comtnUserMng.append("\n )                                               ");
            statement.executeUpdate(comtnUserMng.toString());
    		String comtnUserMngQry = "INSERT INTO COMTNUSERMNG ( USR_ID , PASSWORD , PASSWORD_HINT , PASSWORD_CNSR , USR_NM , ZIP , ADRES , AREA_NO , USR_STTUS , DETAIL_ADRES , END_TELNO , MBTLNUM , USR_FXNUM , USR_EMAIL_ADRES , MIDDLE_TELNO , SBSCRB_DE , SEXDSTN_CODE , ESNTL_ID , LOCK_AT , LOCK_CNT , CHANGE_DT )";  
    		comtnUserMngQry = comtnUserMngQry +" VALUES ( 'TESTUSER' , '473287f8298dba7163a897908958f7c0eae733e25d2e027992ea2edc9bed2fa8' , 'P02' , 'P0002' , '홍길동' , '23121' , 'adres' , '112' , 'A' , '111-335' , '6432' , '010-0000-3333' , '02-332-3332' , 'test@egov.go.kr' , '2332' , null , 'M' , null , 'N' , 0 , '"+sstime+"' ) ";
			jdbcTemplate.execute("INSERT INTO COMTNUSERMNG (USR_ID,PASSWORD,PASSWORD_HINT,PASSWORD_CNSR,USR_NM,ZIP,ADRES,AREA_NO,USR_STTUS,DETAIL_ADRES,END_TELNO,MBTLNUM,USR_FXNUM,USR_EMAIL_ADRES,MIDDLE_TELNO,SBSCRB_DE,SEXDSTN_CODE,ESNTL_ID, CHANGE_DT) values ('USER','473287f8298dba7163a897908958f7c0eae733e25d2e027992ea2edc9bed2fa8','P01','전자정부표준프레임워크센터','일반회원','100775','서울 중구 무교동 한국정보화진흥원','02','P','전자정부표준프레임워크센터','2059','1566-2059','1566-2059','egovframesupport@gmail.com','1566',SYSDATE(),'F','USRCNFRM_00000000001', '"+sstime+"');");
			jdbcTemplate.execute(comtnUserMngQry);
			
			
        	StringBuffer comtnAuthorInfo = new StringBuffer();
        	comtnAuthorInfo.append("\n  CREATE TABLE COMTNAUTHORINFO          ");
        	comtnAuthorInfo.append("\n  (                                     ");
        	comtnAuthorInfo.append("\n  	AUTHOR_CODE VARCHAR(30) not null,    ");
        	comtnAuthorInfo.append("\n  	AUTHOR_NM VARCHAR(60),               ");
        	comtnAuthorInfo.append("\n  	AUTHOR_DC VARCHAR(200),              ");
        	comtnAuthorInfo.append("\n  	AUTHOR_CREAT_DT VARCHAR(14) not null,   ");
        	comtnAuthorInfo.append("\n  	CHANGE_DT VARCHAR(14) not null,      ");
        	comtnAuthorInfo.append("\n  	PRIMARY KEY (AUTHOR_CODE)            ");
        	comtnAuthorInfo.append("\n  )                                     ");
        	statement.executeUpdate(comtnAuthorInfo.toString());
        	String comtnAuthorInfoQry1 = "INSERT INTO COMTNAUTHORINFO (AUTHOR_CODE, AUTHOR_NM, AUTHOR_DC, AUTHOR_CREAT_DT, CHANGE_DT) VALUES('AUTH001', '기본권한', '시스템 기본 권한', '"+sstime+"', '"+sstime+"')"; 
        	String comtnAuthorInfoQry2 = "INSERT INTO COMTNAUTHORINFO (AUTHOR_CODE, AUTHOR_NM, AUTHOR_DC, AUTHOR_CREAT_DT, CHANGE_DT) VALUES('AUTH002', '권한관리', '권한관리 화면 편집 권한', '"+sstime+"', '"+sstime+"')"; 
        	String comtnAuthorInfoQry3 = "INSERT INTO COMTNAUTHORINFO (AUTHOR_CODE, AUTHOR_NM, AUTHOR_DC, AUTHOR_CREAT_DT, CHANGE_DT) VALUES('AUTH003', '권한그룹관리', '권한그룹관리 화면 편집 권한', '"+sstime+"', '"+sstime+"')"; 
        	jdbcTemplate.execute(comtnAuthorInfoQry1);
        	jdbcTemplate.execute(comtnAuthorInfoQry2);
        	jdbcTemplate.execute(comtnAuthorInfoQry3);
        	
        	
        	StringBuffer comtnAuthorUsr = new StringBuffer();
        	comtnAuthorUsr.append("\n CREATE TABLE COMTNAUTHORUSR          ");
        	comtnAuthorUsr.append("\n (                                    ");
        	comtnAuthorUsr.append("\n 	AUTHOR_CODE VARCHAR(30) not null,  ");
        	comtnAuthorUsr.append("\n 	USR_ID VARCHAR(20) not null,       ");
        	comtnAuthorUsr.append("\n 	AUTHOR_GRP_CODE VARCHAR(30),       ");
        	comtnAuthorUsr.append("\n 	ADD_DT VARCHAR(14) not null,       ");
        	comtnAuthorUsr.append("\n 	PRIMARY KEY (AUTHOR_CODE,USR_ID)   ");
        	comtnAuthorUsr.append("\n )                                    ");
        	statement.executeUpdate(comtnAuthorUsr.toString());
        	String comtnAuthorUsrQry = "INSERT INTO COMTNAUTHORUSR (AUTHOR_CODE, USR_ID, AUTHOR_GRP_CODE, ADD_DT) VALUES ('AUTH001', 'TESTUSER', '', '"+sstime+"')";
        	jdbcTemplate.execute(comtnAuthorUsrQry);
        	
        	
        	StringBuffer comtnAuthorGroupInfo = new StringBuffer();
        	comtnAuthorGroupInfo.append("\n CREATE TABLE COMTNAUTHORGROUPINFO                 ");
        	comtnAuthorGroupInfo.append("\n (                                                 ");
        	comtnAuthorGroupInfo.append("\n 	AUTHOR_GRP_CODE         VARCHAR(30) NOT NULL,   ");
        	comtnAuthorGroupInfo.append("\n 	AUTHOR_GRP_NM           VARCHAR(60),            ");
        	comtnAuthorGroupInfo.append("\n 	AUTHOR_GRP_DC           VARCHAR(200),           ");
        	comtnAuthorGroupInfo.append("\n 	AUTHOR_GRP_CREAT_DT     VARCHAR(14),               ");
        	comtnAuthorGroupInfo.append("\n 	CHANGE_DT               VARCHAR(14) NOT NULL,   ");
        	comtnAuthorGroupInfo.append("\n 	PRIMARY KEY (AUTHOR_GRP_CODE)                   ");
        	comtnAuthorGroupInfo.append("\n )                                                 ");
        	statement.executeUpdate(comtnAuthorGroupInfo.toString());
        	String comtnAuthorGroupInfoQry = "INSERT INTO COMTNAUTHORGROUPINFO (AUTHOR_GRP_CODE, AUTHOR_GRP_NM, AUTHOR_GRP_DC, AUTHOR_GRP_CREAT_DT, CHANGE_DT) VALUES('AUTHGRP001', '관리자', '시스템 운영 관리자', '"+sstime+"', '"+sstime+"')"; 
        	String comtnAuthorGroupInfoQry2 = "INSERT INTO COMTNAUTHORGROUPINFO (AUTHOR_GRP_CODE, AUTHOR_GRP_NM, AUTHOR_GRP_DC, AUTHOR_GRP_CREAT_DT, CHANGE_DT) VALUES('AUTHGRP002', '사용자', '일반 사용자', '"+sstime+"', '"+sstime+"')";
        	jdbcTemplate.execute(comtnAuthorGroupInfoQry);
        	jdbcTemplate.execute(comtnAuthorGroupInfoQry2);
        	
        	
        	StringBuffer comtnAuthorGroupAuth = new StringBuffer();
        	comtnAuthorGroupAuth.append("\n CREATE TABLE COMTNAUTHORGROUPAUTH            ");
        	comtnAuthorGroupAuth.append("\n (                                            ");
        	comtnAuthorGroupAuth.append("\n 	AUTHOR_GRP_CODE  VARCHAR(30) NOT NULL,      ");
        	comtnAuthorGroupAuth.append("\n 	AUTHOR_CODE      VARCHAR(30) NOT NULL,      ");
        	comtnAuthorGroupAuth.append("\n 	ADD_DT           VARCHAR(14) NOT NULL,      ");
        	comtnAuthorGroupAuth.append("\n 	PRIMARY KEY (AUTHOR_GRP_CODE, AUTHOR_CODE)  ");
        	comtnAuthorGroupAuth.append("\n )                                            ");
        	statement.executeUpdate(comtnAuthorGroupAuth.toString());
        	String comtnAuthorGroupAuthQry = "INSERT INTO COMTNAUTHORGROUPAUTH (AUTHOR_GRP_CODE, AUTHOR_CODE, ADD_DT) VALUES('AUTHGRP001', 'AUTH001', '"+sstime+"')"; 
        	jdbcTemplate.execute(comtnAuthorGroupAuthQry);
        	
        	
        	
        }
    }
}
