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
        	
        	
        	StringBuffer comtnmenuinfo = new StringBuffer();
        	comtnmenuinfo.append("\n CREATE TABLE COMTNMENUINFO (                                        ");
        	comtnmenuinfo.append("\n   `MENU_NO` DECIMAL(20,0) NOT NULL COMMENT '메뉴번호',              ");
        	comtnmenuinfo.append("\n   `MENU_NM` VARCHAR(60) NOT NULL COMMENT '메뉴명',                  ");
        	comtnmenuinfo.append("\n   `PROGRM_FILE_NM` VARCHAR(60) NOT NULL COMMENT '프로그램파일명',   ");
        	comtnmenuinfo.append("\n   `UPPER_MENU_NO` DECIMAL(20,0) COMMENT '상위메뉴번호',             ");
        	comtnmenuinfo.append("\n   `MENU_ORDR` DECIMAL(5,0) NOT NULL COMMENT '메뉴순서',             ");
        	comtnmenuinfo.append("\n   `MENU_DC` VARCHAR(250) COMMENT '메뉴설명',                        ");
        	comtnmenuinfo.append("\n   `RELATE_IMAGE_PATH` VARCHAR(100) COMMENT '관계이미지경로',        ");
        	comtnmenuinfo.append("\n   `RELATE_IMAGE_NM` VARCHAR(60) COMMENT '관계이미지명',             ");
        	comtnmenuinfo.append("\n   PRIMARY KEY (`MENU_NO`)                                           ");
        	comtnmenuinfo.append("\n )                                                                   ");
        	statement.executeUpdate(comtnmenuinfo.toString());
        	
        	
        	String comtnmenuinfo1  = "INSERT INTO COMTNMENUINFO (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES ('root', 'dir', 0, 0, 1, 'root', '/', '/')                                                  ";
        	String comtnmenuinfo2  = "INSERT INTO COMTNMENUINFO (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES ('로그인', 'Login', 1000000, 0, 1, '로그인', '/', '/')                                      ";
        	String comtnmenuinfo3  = "INSERT INTO COMTNMENUINFO (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES ('권한 관리', 'dir', 2000000, 0, 2, '권한 관리', '/', '/')                                  ";
        	String comtnmenuinfo4  = "INSERT INTO COMTNMENUINFO (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES ('권한 등록', 'AuthInfo', 2010000, 2000000, 1, '권한 등록', '/', '/')                       ";
        	String comtnmenuinfo5  = "INSERT INTO COMTNMENUINFO (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES ('권한 목록 조회', 'AuthList', 2020000, 2000000, 2, '권한 목록 조회', '/', '/')             ";
        	String comtnmenuinfo6  = "INSERT INTO COMTNMENUINFO (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES ('권한 사용자 등록', 'AuthInfoSetUsr', 2030000, 2000000, 3, '권한 사용자 등록', '/', '/')   ";
        	String comtnmenuinfo7  = "INSERT INTO COMTNMENUINFO (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES ('권한그룹 관리', 'dir', 3000000, 0, 3, '권한그룹 관리', '/', '/')                          ";
        	String comtnmenuinfo8  = "INSERT INTO COMTNMENUINFO (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES ('권한그룹 등록', 'AuthGroupInfo', 3010000, 3000000, 1, '권한그룹 등록', '/', '/')               ";
        	String comtnmenuinfo9  = "INSERT INTO COMTNMENUINFO (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES ('권한그룹 목록 조회', 'AuthGrpList', 3020000, 3000000, 2, '권한그룹 목록 조회', '/', '/')     ";
        	String comtnmenuinfo10 = "INSERT INTO COMTNMENUINFO (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES ('권한그룹 권한 등록', 'AuthGrpDetailSetAth', 3030000, 3000000, 3, '권한그룹 권한 등록', '/', '/')     ";
        	String comtnmenuinfo11 = "INSERT INTO COMTNMENUINFO (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES ('권한그룹 사용자 등록', 'AuthGrpDetailSetUsr', 3040000, 3000000, 4, '권한그룹 사용자 등록', '/', '/') ";
        	String comtnmenuinfo12 = "INSERT INTO COMTNMENUINFO (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES ('권한 메뉴 관리', 'dir', 4000000, 0, 4, '권한 메뉴 관리', '/', '/')                          ";
        	String comtnmenuinfo13 = "INSERT INTO COMTNMENUINFO (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES ('권한그룹 메뉴 등록', 'AuthGroupSetMenu', 4010000, 4000000, 1, '권한그룹 메뉴 등록', '/', '/')                                  ";
        	jdbcTemplate.execute(comtnmenuinfo1  );
        	jdbcTemplate.execute(comtnmenuinfo2  );
        	jdbcTemplate.execute(comtnmenuinfo3  );
        	jdbcTemplate.execute(comtnmenuinfo4  );
        	jdbcTemplate.execute(comtnmenuinfo5  );
        	jdbcTemplate.execute(comtnmenuinfo6  );
        	jdbcTemplate.execute(comtnmenuinfo7  );
        	jdbcTemplate.execute(comtnmenuinfo8  );
        	jdbcTemplate.execute(comtnmenuinfo9  );
        	jdbcTemplate.execute(comtnmenuinfo10 );
        	jdbcTemplate.execute(comtnmenuinfo11 );
        	jdbcTemplate.execute(comtnmenuinfo12 );
        	jdbcTemplate.execute(comtnmenuinfo13 );

        	
        	
        	
        	StringBuffer comtnmenucreatdtls = new StringBuffer();
        	comtnmenucreatdtls.append("\n CREATE TABLE COMTNMENUCREATDTLS (                               ");
        	comtnmenucreatdtls.append("\n   MENU_NO 				DECIMAL(20,0) 	NOT NULL COMMENT '메뉴번호',  ");
        	comtnmenucreatdtls.append("\n   AUTHOR_GRP_CODE 		VARCHAR(30) 	NOT NULL COMMENT '권한그룹코드',    ");
        	comtnmenucreatdtls.append("\n   MAPNG_CREAT_ID 	VARCHAR(30) 	COMMENT '매핑생성ID',           ");
        	comtnmenucreatdtls.append("\n   PRIMARY KEY (`MENU_NO`,`AUTHOR_GRP_CODE`)                         ");
        	comtnmenucreatdtls.append("\n )                                                               ");
        	statement.executeUpdate(comtnmenucreatdtls.toString());
        	String comtnmenucreatdtls1  = "INSERT INTO COMTNMENUCREATDTLS (MENU_NO, AUTHOR_GRP_CODE) VALUES (1000000, 'AUTHGRP001')";
        	String comtnmenucreatdtls2  = "INSERT INTO COMTNMENUCREATDTLS (MENU_NO, AUTHOR_GRP_CODE) VALUES (2000000, 'AUTHGRP001')";
        	jdbcTemplate.execute(comtnmenucreatdtls1);
        	jdbcTemplate.execute(comtnmenucreatdtls2);
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
//        	String comtnmenuinfo1     = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('root', 'dir', 0, 0, 1, 'root', '/', '/')";
//        	String comtnmenuinfo2     = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('사용자디렉토리/통합인증', 'dir', 1000000, 0, 1, '사용자디렉토리/통합인증', '/', '/')";
//        	String comtnmenuinfo3     = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('로그인', 'egovLoginUsr', 1010000, 1000000, 1, '로그인', '/', '/')";
//        	String comtnmenuinfo4     = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('로그인정책관리', 'selectLoginPolicyList', 1020000, 1000000, 2, '로그인정책관리', '/', '/')";
//        	String comtnmenuinfo5     = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('보안', 'dir', 2000000, 0, 2, '보안', '/', '/')";
//        	String comtnmenuinfo6     = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('권한관리', 'EgovAuthorList', 2010000, 2000000, 1, '권한관리', '/', '/')";
//        	String comtnmenuinfo7     = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('권한그룹관리', 'EgovAuthorGroupList', 2020000, 2000000, 2, '권한그룹관리', '/', '/')";
//        	String comtnmenuinfo8     = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('그룹관리', 'EgovGroupList', 2030000, 2000000, 3, '그룹관리', '/', '/')";
//        	String comtnmenuinfo9     = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('롤관리', 'EgovRoleList', 2040000, 2000000, 4, '롤관리', '/', '/')";
//        	String comtnmenuinfo10    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('부서권한관리', 'EgovDeptAuthorList', 2050000, 2000000, 5, '부서권한관리', '/', '/')";
//        	String comtnmenuinfo11    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('통계/리포팅', 'dir', 3000000, 0, 3, '통계/리포팅', '/', '/')";
//        	String comtnmenuinfo12    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('게시물통계', 'selectBbsStats', 3010000, 3000000, 1, '게시물통계', '/', '/')";
//        	String comtnmenuinfo13    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('사용자통계', 'selectUserStats', 3020000, 3000000, 2, '사용자통계', '/', '/')";
//        	String comtnmenuinfo14    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('접속통계', 'selectConectStats', 3030000, 3000000, 3, '접속통계', '/', '/')";
//        	String comtnmenuinfo15    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('화면통계', 'selectScrinStats', 3040000, 3000000, 4, '화면통계', '/', '/')";
//        	String comtnmenuinfo16    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('보고서통계', 'selectReprtStatsListView', 3050000, 3000000, 5, '보고서통계', '/', '/')";
//        	String comtnmenuinfo17    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('자료이용현황통계', 'selectDtaUseStatsList', 3060000, 3000000, 6, '자료이용현황통계', '/', '/')";
//        	String comtnmenuinfo18    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('협업', 'dir', 4000000, 0, 4, '협업', '/', '/')";
//        	String comtnmenuinfo19    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('게시판속성관리', 'SelectBBSMasterInfs', 4010000, 4000000, 1, '게시판속성관리', '/', '/')";
//        	String comtnmenuinfo20    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('게시판사용정보', 'selectBBSUseInfs', 4020000, 4000000, 2, '게시판사용정보', '/', '/')";
//        	String comtnmenuinfo21    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('템플릿관리', 'selectTemplateInfs', 4030000, 4000000, 3, '템플릿관리', '/', '/')";
//        	String comtnmenuinfo22    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('스크랩 목록', 'selectScrapList', 4040000, 4000000, 4, '스크랩 목록', '/', '/')";
//        	String comtnmenuinfo23    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('커뮤니티관리', 'selectCmmntyInfs', 4050000, 4000000, 5, '커뮤니티관리', '/', '/')";
//        	String comtnmenuinfo24    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('문자메시지', 'selectSmsList', 4060000, 4000000, 6, '문자메시지', '/', '/')";
//        	String comtnmenuinfo25    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('부서일정관리', 'EgovDeptSchdulManageList', 4070000, 4000000, 7, '부서일정관리', '/', '/')";
//        	String comtnmenuinfo26    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('일정관리', 'EgovIndvdlSchdulManageList', 4080000, 4000000, 8, '일정관리', '/', '/')";
//        	String comtnmenuinfo27    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('일지관리', 'EgovDiaryManageList', 4090000, 4000000, 9, '일지관리', '/', '/')";
//        	String comtnmenuinfo28    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('전체일정관리', 'EgovAllSchdulManageList', 4100000, 4000000, 10, '전체일정관리', '/', '/')";
//        	String comtnmenuinfo29    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('메일발송', 'insertSndngMailView', 4110000, 4000000, 11, '메일발송', '/', '/')";
//        	String comtnmenuinfo30    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('발송메일내역', 'selectSndngMailList', 4120000, 4000000, 12, '발송메일내역', '/', '/')";
//        	String comtnmenuinfo31    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('명함관리', 'selectNcrdInfs', 4130000, 4000000, 13, '명함관리', '/', '/')";
//        	String comtnmenuinfo32    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('내명함목록', 'selectMyNcrdUseInf', 4140000, 4000000, 14, '내명함목록', '/', '/')";
//        	String comtnmenuinfo33    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('주소록관리', 'selectAdbkList', 4150000, 4000000, 15, '주소록관리', '/', '/')";
//        	String comtnmenuinfo34    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('간부일정관리', 'selectLeaderSchdulList', 4160000, 4000000, 16, '간부일정관리', '/', '/')";
//        	String comtnmenuinfo35    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('부서업무함관리', 'selectDeptJobBxList', 4170000, 4000000, 17, '부서업무함관리', '/', '/')";
//        	String comtnmenuinfo36    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('부서업무정보', 'selectDeptJobList', 4180000, 4000000, 18, '부서업무정보', '/', '/')";
//        	String comtnmenuinfo37    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('주간/월간보고관리', 'selectWikMnthngReprtList', 4190000, 4000000, 19, '주간/월간보고관리', '/', '/')";
//        	String comtnmenuinfo38    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('메모할일관리', 'selectMemoTodoList', 4200000, 4000000, 20, '메모할일관리', '/', '/')";
//        	String comtnmenuinfo39    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('메모보고', 'selectMemoReprtList', 4210000, 4000000, 21, '메모보고', '/', '/')";
//        	String comtnmenuinfo40    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('사용자지원', 'dir', 5000000, 0, 5, '사용자지원', '/', '/')";
//        	String comtnmenuinfo41    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('기업회원관리', 'EgovEntrprsMberManage', 5010000, 5000000, 1, '기업회원관리', '/', '/')";
//        	String comtnmenuinfo42    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('업무사용자관리', 'EgovUserManage', 5020000, 5000000, 2, '업무사용자관리', '', '')";
//        	String comtnmenuinfo43    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('부서관리', 'selectDeptManageListView', 5030000, 5000000, 3, '부서관리', '/', '/')";
//        	String comtnmenuinfo44    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('일반회원관리', 'EgovMberManage', 5040000, 5000000, 4, '일반회원관리', '/', '/')";
//        	String comtnmenuinfo45    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('마이페이지관리', 'EgovIndvdlpgeCntntsList', 5050000, 5000000, 5, '마이페이지관리', '/', '/')";
//        	String comtnmenuinfo46    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('약관관리', 'StplatListInqire', 5060000, 5000000, 6, '약관관리', '/', '/')";
//        	String comtnmenuinfo47    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('저작권보호정책', 'CpyrhtPrtcPolicyListInqire', 5070000, 5000000, 7, '저작권보호정책', '/', '/')";
//        	String comtnmenuinfo48    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('개인정보보호정책확인', 'listIndvdlInfoPolicy', 5080000, 5000000, 8, '개인정보보호정책확인', '/', '/')";
//        	String comtnmenuinfo49    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('도움말', 'HpcmListInqire', 5090000, 5000000, 9, '도움말', '/', '/')";
//        	String comtnmenuinfo50    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('용어사전', 'WordDicaryListInqire', 5100000, 5000000, 10, '용어사전', '/', '/')";
//        	String comtnmenuinfo51    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('FAQ관리', 'FaqListInqire', 5110000, 5000000, 11, 'FAQ관리', '/', '/')";
//        	String comtnmenuinfo52    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('Q&amp;A관리', 'QnaListInqire', 5120000, 5000000, 12, 'Q&amp;A관리', '/', '/')";
//        	String comtnmenuinfo53    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('Q&amp;A답변관리', 'QnaAnswerListInqire', 5130000, 5000000, 13, 'Q&amp;A답변관리', '/', '/')";
//        	String comtnmenuinfo54    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('행정전문용어사전', 'listAdministrationWord', 5140000, 5000000, 14, '행정전문용어사전', '/', '/')";
//        	String comtnmenuinfo55    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('행정전문용어사전관리', 'listAdministrationWordManage', 5150000, 5000000, 15, '행정전문용어사전관리', '/', '/')";
//        	String comtnmenuinfo56    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('온라인매뉴얼', 'listOnlineManual', 5160000, 5000000, 16, '온라인매뉴얼', '/', '/')";
//        	String comtnmenuinfo57    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('사용자온라인매뉴얼', 'OnlineManualUserList', 5170000, 5000000, 17, '사용자온라인매뉴얼', '/', '/')";
//        	String comtnmenuinfo58    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('상담관리', 'CnsltListInqire', 5180000, 5000000, 18, '상담관리', '/', '/')";
//        	String comtnmenuinfo59    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('상담답변관리', 'CnsltAnswerListInqire', 5190000, 5000000, 19, '상담답변관리', '/', '/')";
//        	String comtnmenuinfo60    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('설문관리', 'EgovQustnrManageList', 5200000, 5000000, 20, '설문관리', '/', '/')";
//        	String comtnmenuinfo61    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('설문조사', 'EgovQustnrRespondInfoManageList', 5210000, 5000000, 21, '설문조사', '/', '/')";
//        	String comtnmenuinfo62    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('설문템플릿관리', 'EgovQustnrTmplatManageList', 5220000, 5000000, 22, '설문템플릿관리', '/', '/')";
//        	String comtnmenuinfo63    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('응답자관리', 'EgovQustnrRespondManageList', 5230000, 5000000, 23, '응답자관리', '/', '/')";
//        	String comtnmenuinfo64    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('질문관리', 'EgovQustnrQestnManageList', 5240000, 5000000, 24, '질문관리', '/', '/')";
//        	String comtnmenuinfo65    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('항목관리', 'EgovQustnrItemManageList', 5250000, 5000000, 25, '항목관리', '/', '/')";
//        	String comtnmenuinfo66    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('회의관리', 'EgovMeetingManageList', 5260000, 5000000, 26, '회의관리', '/', '/')";
//        	String comtnmenuinfo67    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('온라인poll관리', 'listOnlinePollManage', 5270000, 5000000, 27, '온라인poll관리', '/', '/')";
//        	String comtnmenuinfo68    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('온라인poll참여', 'listOnlinePollPartcptn', 5280000, 5000000, 28, '온라인poll참여', '/', '/')";
//        	String comtnmenuinfo69    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('뉴스관리', 'NewsInfoListInqire', 5290000, 5000000, 29, '뉴스관리', '/', '/')";
//        	String comtnmenuinfo70    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('사이트관리', 'SiteListInqire', 5300000, 5000000, 30, '사이트관리', '/', '/')";
//        	String comtnmenuinfo71    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('추천사이트관리', 'RecomendSiteListInqire', 5310000, 5000000, 31, '추천사이트관리', '/', '/')";
//        	String comtnmenuinfo72    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('행사/이벤트/캠페인', 'EgovEventCmpgnList', 5320000, 5000000, 32, '행사/이벤트/캠페인', '/', '/')";
//        	String comtnmenuinfo73    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('외부인사정보', 'EgovTnextrlHrInfoList', 5330000, 5000000, 33, '외부인사정보', '/', '/')";
//        	String comtnmenuinfo74    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('팝업창관리', 'listPopup', 5340000, 5000000, 34, '팝업창관리', '/', '/')";
//        	String comtnmenuinfo75    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('정보알림이', 'selectNotificationList', 5350000, 5000000, 35, '정보알림이', '/', '/')";
//        	String comtnmenuinfo76    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('배너관리', 'selectBannerList', 5360000, 5000000, 36, '배너관리', '/', '/')";
//        	String comtnmenuinfo77    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('MYPAGE배너관리', 'selectBannerMainList', 5370000, 5000000, 37, 'MYPAGE배너관리', '', '')";
//        	String comtnmenuinfo78    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('로그인화면이미지관리', 'selectLoginScrinImageList', 5380000, 5000000, 38, '로그인화면이미지관리', '/', '/')";
//        	String comtnmenuinfo79    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('최근검색어 목록', 'listRecentSrchwrd', 5390000, 5000000, 39, '최근검색어 목록', '/', '/')";
//        	String comtnmenuinfo80    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('메인이미지관리', 'selectMainImageList', 5400000, 5000000, 40, '메인이미지관리', '/', '/')";
//        	String comtnmenuinfo81    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('메인이미지 반영결과보기', 'getMainImageResult', 5410000, 5000000, 41, '메인이미지 반영결과보기', '/', '/')";
//        	String comtnmenuinfo82    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('통합링크관리', 'listUnityLink', 5420000, 5000000, 42, '통합링크관리', '/', '/')";
//        	String comtnmenuinfo83    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('사용자부재관리', 'selectUserAbsnceListView', 5430000, 5000000, 43, '사용자부재관리', '/', '/')";
//        	String comtnmenuinfo84    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('인터넷서비스안내및관리', 'selectIntnetSvcGuidanceList', 5440000, 5000000, 44, '인터넷서비스안내및관리', '/', '/')";
//        	String comtnmenuinfo85    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('Wiki기능', 'listWikiBookmark', 5450000, 5000000, 45, 'Wiki기능', '/', '/')";
//        	String comtnmenuinfo86    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('RSS태그관리', 'listRssTagManage', 5460000, 5000000, 46, 'RSS태그관리', '/', '/')";
//        	String comtnmenuinfo87    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('RSS태그서비스', 'listRssTagService', 5470000, 5000000, 47, 'RSS태그서비스', '/', '/')";
//        	String comtnmenuinfo88    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('Twitter연동', 'selectTwitterMain', 5480000, 5000000, 48, 'Twitter연동', '/', '/')";
//        	String comtnmenuinfo89    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('쪽지관리', 'registEgovNoteManage', 5490000, 5000000, 49, '쪽지관리', '/', '/')";
//        	String comtnmenuinfo90    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('받은쪽지함관리', 'listNoteRecptn', 5500000, 5000000, 50, '받은쪽지함관리', '/', '/')";
//        	String comtnmenuinfo91    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('보낸쪽지함관리', 'listNoteTrnsmit', 5510000, 5000000, 51, '보낸쪽지함관리', '/', '/')";
//        	String comtnmenuinfo92    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('회의실관리', 'selectMtgPlaceManageList', 5520000, 5000000, 52, '회의실관리', '/', '/')";
//        	String comtnmenuinfo93    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('회의실예약관리', 'selectMtgPlaceResveManageList', 5530000, 5000000, 53, '회의실예약관리', '/', '/')";
//        	String comtnmenuinfo94    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('직원경조사관리', 'selectCtsnnManageList', 5540000, 5000000, 54, '직원경조사관리', '/', '/')";
//        	String comtnmenuinfo95    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('직원경조사승인관리', 'EgovCtsnnConfmList', 5550000, 5000000, 55, '직원경조사승인관리', '/', '/')";
//        	String comtnmenuinfo96    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('휴가관리', 'EgovVcatnManageList', 5560000, 5000000, 56, '휴가관리', '/', '/')";
//        	String comtnmenuinfo97    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('휴가승인관리', 'EgovVcatnConfmList', 5570000, 5000000, 57, '휴가승인관리', '/', '/')";
//        	String comtnmenuinfo98    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('당직관리', 'EgovBndtManageList', 5580000, 5000000, 58, '당직관리', '/', '/')";
//        	String comtnmenuinfo99    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('당직체크관리', 'EgovBndtCeckManageList', 5590000, 5000000, 59, '당직체크관리', '/', '/')";
//        	String comtnmenuinfo100    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('포상관리', 'selectRwardManageList', 5600000, 5000000, 60, '포상관리', '/', '/')";
//        	String comtnmenuinfo101    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('포상승인관리', 'EgovRwardConfmList', 5610000, 5000000, 61, '포상승인관리', '/', '/')";
//        	String comtnmenuinfo102    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('기념일관리', 'selectAnnvrsryManageList', 5620000, 5000000, 62, '기념일관리', '/', '/')";
//        	String comtnmenuinfo103    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('기념일목록(확인용)', 'selectAnnvrsryMainList', 5630000, 5000000, 63, '기념일목록(확인용)', '/', '/')";
//        	String comtnmenuinfo104    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('행사신청관리', 'EgovEventReqstManageList', 5640000, 5000000, 64, '행사신청관리', '/', '/')";
//        	String comtnmenuinfo105    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('행사접수관리', 'EgovEventRcrptManageList', 5650000, 5000000, 65, '행사접수관리', '/', '/')";
//        	String comtnmenuinfo106    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('행사접수승인관리', 'selectEventRceptConfmList', 5660000, 5000000, 66, '행사접수승인관리', '/', '/')";
//        	String comtnmenuinfo107    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('시스템관리', 'dir', 6000000, 0, 6, '시스템관리', '/', '/')";
//        	String comtnmenuinfo108    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('공통분류코드', 'EgovCcmCmmnClCodeList', 6010000, 6000000, 1, '공통분류코드', '/', '/')";
//        	String comtnmenuinfo109    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('공통상세코드', 'EgovCcmCmmnDetailCodeList', 6020000, 6000000, 2, '공통상세코드', '/', '/')";
//        	String comtnmenuinfo110    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('공통코드', 'EgovCcmCmmnCodeList', 6030000, 6000000, 3, '공통코드', '/', '/')";
//        	String comtnmenuinfo111    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('우편번호관리', 'EgovCcmZipList', 6040000, 6000000, 4, '우편번호관리', '/', '/')";
//        	String comtnmenuinfo112    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('행정코드관리', 'EgovCcmAdministCodeList', 6050000, 6000000, 5, '행정코드관리', '/', '/')";
//        	String comtnmenuinfo113    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('기관코드수신', 'getInsttCodeRecptnList', 6060000, 6000000, 6, '기관코드수신', '/', '/')";
//        	String comtnmenuinfo114    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('로그관리', 'SelectSysLogList', 6070000, 6000000, 7, '로그관리', '/', '/')";
//        	String comtnmenuinfo115    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('사용로그관리', 'SelectUserLogList', 6080000, 6000000, 8, '사용로그관리', '/', '/')";
//        	String comtnmenuinfo116    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('송/수신로그관리', 'SelectTrsmrcvLogList', 6090000, 6000000, 9, '송/수신로그관리', '/', '/')";
//        	String comtnmenuinfo117    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('시스템이력관리', 'SelectSysHistoryList', 6100000, 6000000, 10, '시스템이력관리', '/', '/')";
//        	String comtnmenuinfo118    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('웹로그관리', 'SelectWebLogList', 6110000, 6000000, 11, '웹로그관리', '/', '/')";
//        	String comtnmenuinfo119    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('접속로그관리', 'SelectLoginLogList', 6120000, 6000000, 12, '접속로그관리', '/', '/')";
//        	String comtnmenuinfo120    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('메뉴리스트관리', 'EgovMenuListSelect', 6130000, 6000000, 13, '메뉴리스트관리', '/', '/')";
//        	String comtnmenuinfo121    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('메뉴관리리스트', 'EgovMenuManageSelect', 6140000, 6000000, 14, '메뉴관리리스트', '/', '/')";
//        	String comtnmenuinfo122    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('메뉴생성관리', 'EgovMenuCreatManageSelect', 6150000, 6000000, 15, '메뉴생성관리', '/', '/')";
//        	String comtnmenuinfo123    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('사이트맵', 'EgovSiteMapng', 6160000, 6000000, 16, '사이트맵', '/', '/')";
//        	String comtnmenuinfo124    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('바로가기메뉴관리', 'selectBkmkMenuManageList', 6170000, 6000000, 17, '바로가기메뉴관리', '/', '/')";
//        	String comtnmenuinfo125    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('프로그램관리', 'EgovProgramListManageSelect', 6180000, 6000000, 18, '프로그램관리', '/', '/')";
//        	String comtnmenuinfo126    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('프로그램변경요청관리', 'EgovProgramChangeRequstSelect', 6190000, 6000000, 19, '프로그램변경요청관리', '/', '/')";
//        	String comtnmenuinfo127    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('프로그램변경요청처리', 'EgovProgramChangeRequstProcessListSelect', 6200000, 6000000, 20, '프로그램변경요청처리', '/', '/')";
//        	String comtnmenuinfo128    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('프로그램변경이력', 'EgovProgramChgHstListSelect', 6210000, 6000000, 21, '프로그램변경이력', '/', '/')";
//        	String comtnmenuinfo129    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('배치작업관리', 'getBatchOpertList', 6220000, 6000000, 22, '배치작업관리', '/', '/')";
//        	String comtnmenuinfo130    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('배치결과관리', 'getBatchResultList', 6230000, 6000000, 23, '배치결과관리', '/', '/')";
//        	String comtnmenuinfo131    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('스케줄처리', 'getBatchSchdulList', 6240000, 6000000, 24, '스케줄처리', '/', '/')";
//        	String comtnmenuinfo132    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('백업관리', 'getBackupOpertList', 6250000, 6000000, 25, '백업관리', '/', '/')";
//        	String comtnmenuinfo133    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('백업결과관리', 'getBackupResultList', 6260000, 6000000, 26, '백업결과관리', '/', '/')";
//        	String comtnmenuinfo134    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('네트워크관리', 'selectNtwrkList', 6270000, 6000000, 27, '네트워크관리', '/', '/')";
//        	String comtnmenuinfo135    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('서버정보관리', 'selectServerEqpmnList', 6280000, 6000000, 28, '서버정보관리', '/', '/')";
//        	String comtnmenuinfo136    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('서버(S/W)목록', 'selectServerList', 6290000, 6000000, 29, '서버(S/W)목록', '/', '/')";
//        	String comtnmenuinfo137    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('장애신청관리', 'selectTroblReqstList', 6300000, 6000000, 30, '장애신청관리', '/', '/')";
//        	String comtnmenuinfo138    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('장애처리결과관리', 'selectTroblProcessList', 6310000, 6000000, 31, '장애처리결과관리', '/', '/')";
//        	String comtnmenuinfo139    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('시스템/서비스연계', 'dir', 7000000, 0, 7, '시스템/서비스연계', '/', '/')";
//        	String comtnmenuinfo140    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('시스템연계관리', 'getSystemCntcList', 7010000, 7000000, 1, '시스템연계관리', '/', '/')";
//        	String comtnmenuinfo141    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('연계현황관리', 'getCntcSttusList', 7020000, 7000000, 2, '연계현황관리', '/', '/')";
//        	String comtnmenuinfo142    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('연계메시지관리', 'getCntcMessageList', 7030000, 7000000, 3, '연계메시지관리', '/', '/')";
//        	String comtnmenuinfo143    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('연계기관관리', 'getCntcInsttList', 7040000, 7000000, 4, '연계기관관리', '/', '/')";
//        	String comtnmenuinfo144    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('자산 관리', 'dir', 8000000, 0, 8, '자산 관리', '/', '/')";
//        	String comtnmenuinfo145    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('개인지식관리', 'EgovComDamPersonalList', 8010000, 8000000, 1, '개인지식관리', '/', '/')";
//        	String comtnmenuinfo146    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('지식맵관리(유형)', 'EgovComDamMapMaterialList', 8020000, 8000000, 2, '지식맵관리(유형)', '/', '/')";
//        	String comtnmenuinfo147    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('지식맵관리(조직)', 'EgovComDamMapTeamList', 8030000, 8000000, 3, '지식맵관리(조직)', '/', '/')";
//        	String comtnmenuinfo148    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('지식전문가관리', 'EgovComDamSpecialistList', 8040000, 8000000, 4, '지식전문가관리', '/', '/')";
//        	String comtnmenuinfo149    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('지식정보관리', 'EgovComDamManagementList', 8050000, 8000000, 5, '지식정보관리', '/', '/')";
//        	String comtnmenuinfo150    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('지식평가관리', 'EgovComDamAppraisalList', 8060000, 8000000, 6, '지식평가관리', '/', '/')";
//        	String comtnmenuinfo151    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('지식정보제공', 'listRequestOffer', 8070000, 8000000, 7, '지식정보제공', '/', '/')";
//        	String comtnmenuinfo152    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('요소기술', 'dir', 9000000, 0, 9, '요소기술', '/', '/')";
//        	String comtnmenuinfo153    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('공휴일관리(달력)', 'EgovRestdeList', 9010000, 9000000, 1, '공휴일관리(달력)', '/', '/')";
//        	String comtnmenuinfo154    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('송수신모니터링', 'getTrsmrcvMntrngList', 9020000, 9000000, 2, '송수신모니터링', '/', '/')";
//        	String comtnmenuinfo155    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('DB서비스모니터링', 'getDbMntrngList', 9030000, 9000000, 3, 'DB서비스모니터링', '/', '/')";
//        	String comtnmenuinfo156    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('HTTP서비스모니터링', 'EgovComUtlHttpMonList', 9040000, 9000000, 4, 'HTTP서비스모니터링', '/', '/')";
//        	String comtnmenuinfo157    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('프로세스모니터링', 'EgovComUtlProcessMonList', 9050000, 9000000, 5, '프로세스모니터링', '/', '/')";
//        	String comtnmenuinfo158    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('네트워크서비스모니터링', 'selectNtwrkSvcMntrngList', 9060000, 9000000, 6, '네트워크서비스모니터링', '/', '/')";
//        	String comtnmenuinfo159    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('파일시스템모니터링', 'selectFileSysMntrngList', 9070000, 9000000, 7, '파일시스템모니터링', '/', '/')";
//        	String comtnmenuinfo160    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('프록시서비스', 'selectProxySvcList', 9080000, 9000000, 8, '프록시서비스', '/', '/')";
//        	String comtnmenuinfo161    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('파일동기화(대상서버)', 'selectSynchrnServerList', 9090000, 9000000, 9, '파일동기화(대상서버)', '/', '/')";
//        	String comtnmenuinfo162    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('로그인세션정보체크', 'loginSessionView', 9100000, 9000000, 10, '로그인세션정보체크', '/', '/')";
//        	String comtnmenuinfo163    = "INSERT INTO comtnmenuinfo (MENU_NM, PROGRM_FILE_NM, MENU_NO, UPPER_MENU_NO, MENU_ORDR, MENU_DC, RELATE_IMAGE_PATH, RELATE_IMAGE_NM) VALUES('서버자원모니터링-대상목록', 'selectMntrngServerList', 9110000, 9000000, 11, '서버자원모니터링-대상목록', '/', '/')";
//        	jdbcTemplate.execute(comtnmenuinfo1  );
//        	jdbcTemplate.execute(comtnmenuinfo2  );
//        	jdbcTemplate.execute(comtnmenuinfo3  );
//        	jdbcTemplate.execute(comtnmenuinfo4  );
//        	jdbcTemplate.execute(comtnmenuinfo5  );
//        	jdbcTemplate.execute(comtnmenuinfo6  );
//        	jdbcTemplate.execute(comtnmenuinfo7  );
//        	jdbcTemplate.execute(comtnmenuinfo8  );
//        	jdbcTemplate.execute(comtnmenuinfo9  );
//        	jdbcTemplate.execute(comtnmenuinfo10 );
//        	jdbcTemplate.execute(comtnmenuinfo11 );
//        	jdbcTemplate.execute(comtnmenuinfo12 );
//        	jdbcTemplate.execute(comtnmenuinfo13 );
//        	jdbcTemplate.execute(comtnmenuinfo14 );
//        	jdbcTemplate.execute(comtnmenuinfo15 );
//        	jdbcTemplate.execute(comtnmenuinfo16 );
//        	jdbcTemplate.execute(comtnmenuinfo17 );
//        	jdbcTemplate.execute(comtnmenuinfo18 );
//        	jdbcTemplate.execute(comtnmenuinfo19 );
//        	jdbcTemplate.execute(comtnmenuinfo20 );
//        	jdbcTemplate.execute(comtnmenuinfo21 );
//        	jdbcTemplate.execute(comtnmenuinfo22 );
//        	jdbcTemplate.execute(comtnmenuinfo23 );
//        	jdbcTemplate.execute(comtnmenuinfo24 );
//        	jdbcTemplate.execute(comtnmenuinfo25 );
//        	jdbcTemplate.execute(comtnmenuinfo26 );
//        	jdbcTemplate.execute(comtnmenuinfo27 );
//        	jdbcTemplate.execute(comtnmenuinfo28 );
//        	jdbcTemplate.execute(comtnmenuinfo29 );
//        	jdbcTemplate.execute(comtnmenuinfo30 );
//        	jdbcTemplate.execute(comtnmenuinfo31 );
//        	jdbcTemplate.execute(comtnmenuinfo32 );
//        	jdbcTemplate.execute(comtnmenuinfo33 );
//        	jdbcTemplate.execute(comtnmenuinfo34 );
//        	jdbcTemplate.execute(comtnmenuinfo35 );
//        	jdbcTemplate.execute(comtnmenuinfo36 );
//        	jdbcTemplate.execute(comtnmenuinfo37 );
//        	jdbcTemplate.execute(comtnmenuinfo38 );
//        	jdbcTemplate.execute(comtnmenuinfo39 );
//        	jdbcTemplate.execute(comtnmenuinfo40 );
//        	jdbcTemplate.execute(comtnmenuinfo41 );
//        	jdbcTemplate.execute(comtnmenuinfo42 );
//        	jdbcTemplate.execute(comtnmenuinfo43 );
//        	jdbcTemplate.execute(comtnmenuinfo44 );
//        	jdbcTemplate.execute(comtnmenuinfo45 );
//        	jdbcTemplate.execute(comtnmenuinfo46 );
//        	jdbcTemplate.execute(comtnmenuinfo47 );
//        	jdbcTemplate.execute(comtnmenuinfo48 );
//        	jdbcTemplate.execute(comtnmenuinfo49 );
//        	jdbcTemplate.execute(comtnmenuinfo50 );
//        	jdbcTemplate.execute(comtnmenuinfo51 );
//        	jdbcTemplate.execute(comtnmenuinfo52 );
//        	jdbcTemplate.execute(comtnmenuinfo53 );
//        	jdbcTemplate.execute(comtnmenuinfo54 );
//        	jdbcTemplate.execute(comtnmenuinfo55 );
//        	jdbcTemplate.execute(comtnmenuinfo56 );
//        	jdbcTemplate.execute(comtnmenuinfo57 );
//        	jdbcTemplate.execute(comtnmenuinfo58 );
//        	jdbcTemplate.execute(comtnmenuinfo59 );
//        	jdbcTemplate.execute(comtnmenuinfo60 );
//        	jdbcTemplate.execute(comtnmenuinfo61 );
//        	jdbcTemplate.execute(comtnmenuinfo62 );
//        	jdbcTemplate.execute(comtnmenuinfo63 );
//        	jdbcTemplate.execute(comtnmenuinfo64 );
//        	jdbcTemplate.execute(comtnmenuinfo65 );
//        	jdbcTemplate.execute(comtnmenuinfo66 );
//        	jdbcTemplate.execute(comtnmenuinfo67 );
//        	jdbcTemplate.execute(comtnmenuinfo68 );
//        	jdbcTemplate.execute(comtnmenuinfo69 );
//        	jdbcTemplate.execute(comtnmenuinfo70 );
//        	jdbcTemplate.execute(comtnmenuinfo71 );
//        	jdbcTemplate.execute(comtnmenuinfo72 );
//        	jdbcTemplate.execute(comtnmenuinfo73 );
//        	jdbcTemplate.execute(comtnmenuinfo74 );
//        	jdbcTemplate.execute(comtnmenuinfo75 );
//        	jdbcTemplate.execute(comtnmenuinfo76 );
//        	jdbcTemplate.execute(comtnmenuinfo77 );
//        	jdbcTemplate.execute(comtnmenuinfo78 );
//        	jdbcTemplate.execute(comtnmenuinfo79 );
//        	jdbcTemplate.execute(comtnmenuinfo80 );
//        	jdbcTemplate.execute(comtnmenuinfo81 );
//        	jdbcTemplate.execute(comtnmenuinfo82 );
//        	jdbcTemplate.execute(comtnmenuinfo83 );
//        	jdbcTemplate.execute(comtnmenuinfo84 );
//        	jdbcTemplate.execute(comtnmenuinfo85 );
//        	jdbcTemplate.execute(comtnmenuinfo86 );
//        	jdbcTemplate.execute(comtnmenuinfo87 );
//        	jdbcTemplate.execute(comtnmenuinfo88 );
//        	jdbcTemplate.execute(comtnmenuinfo89 );
//        	jdbcTemplate.execute(comtnmenuinfo90 );
//        	jdbcTemplate.execute(comtnmenuinfo91 );
//        	jdbcTemplate.execute(comtnmenuinfo92 );
//        	jdbcTemplate.execute(comtnmenuinfo93 );
//        	jdbcTemplate.execute(comtnmenuinfo94 );
//        	jdbcTemplate.execute(comtnmenuinfo95 );
//        	jdbcTemplate.execute(comtnmenuinfo96 );
//        	jdbcTemplate.execute(comtnmenuinfo97 );
//        	jdbcTemplate.execute(comtnmenuinfo98 );
//        	jdbcTemplate.execute(comtnmenuinfo99 );
//        	jdbcTemplate.execute(comtnmenuinfo100);
//        	jdbcTemplate.execute(comtnmenuinfo101);
//        	jdbcTemplate.execute(comtnmenuinfo102);
//        	jdbcTemplate.execute(comtnmenuinfo103);
//        	jdbcTemplate.execute(comtnmenuinfo104);
//        	jdbcTemplate.execute(comtnmenuinfo105);
//        	jdbcTemplate.execute(comtnmenuinfo106);
//        	jdbcTemplate.execute(comtnmenuinfo107);
//        	jdbcTemplate.execute(comtnmenuinfo108);
//        	jdbcTemplate.execute(comtnmenuinfo109);
//        	jdbcTemplate.execute(comtnmenuinfo110);
//        	jdbcTemplate.execute(comtnmenuinfo111);
//        	jdbcTemplate.execute(comtnmenuinfo112);
//        	jdbcTemplate.execute(comtnmenuinfo113);
//        	jdbcTemplate.execute(comtnmenuinfo114);
//        	jdbcTemplate.execute(comtnmenuinfo115);
//        	jdbcTemplate.execute(comtnmenuinfo116);
//        	jdbcTemplate.execute(comtnmenuinfo117);
//        	jdbcTemplate.execute(comtnmenuinfo118);
//        	jdbcTemplate.execute(comtnmenuinfo119);
//        	jdbcTemplate.execute(comtnmenuinfo120);
//        	jdbcTemplate.execute(comtnmenuinfo121);
//        	jdbcTemplate.execute(comtnmenuinfo122);
//        	jdbcTemplate.execute(comtnmenuinfo123);
//        	jdbcTemplate.execute(comtnmenuinfo124);
//        	jdbcTemplate.execute(comtnmenuinfo125);
//        	jdbcTemplate.execute(comtnmenuinfo126);
//        	jdbcTemplate.execute(comtnmenuinfo127);
//        	jdbcTemplate.execute(comtnmenuinfo128);
//        	jdbcTemplate.execute(comtnmenuinfo129);
//        	jdbcTemplate.execute(comtnmenuinfo130);
//        	jdbcTemplate.execute(comtnmenuinfo131);
//        	jdbcTemplate.execute(comtnmenuinfo132);
//        	jdbcTemplate.execute(comtnmenuinfo133);
//        	jdbcTemplate.execute(comtnmenuinfo134);
//        	jdbcTemplate.execute(comtnmenuinfo135);
//        	jdbcTemplate.execute(comtnmenuinfo136);
//        	jdbcTemplate.execute(comtnmenuinfo137);
//        	jdbcTemplate.execute(comtnmenuinfo138);
//        	jdbcTemplate.execute(comtnmenuinfo139);
//        	jdbcTemplate.execute(comtnmenuinfo140);
//        	jdbcTemplate.execute(comtnmenuinfo141);
//        	jdbcTemplate.execute(comtnmenuinfo142);
//        	jdbcTemplate.execute(comtnmenuinfo143);
//        	jdbcTemplate.execute(comtnmenuinfo144);
//        	jdbcTemplate.execute(comtnmenuinfo145);
//        	jdbcTemplate.execute(comtnmenuinfo146);
//        	jdbcTemplate.execute(comtnmenuinfo147);
//        	jdbcTemplate.execute(comtnmenuinfo148);
//        	jdbcTemplate.execute(comtnmenuinfo149);
//        	jdbcTemplate.execute(comtnmenuinfo150);
//        	jdbcTemplate.execute(comtnmenuinfo151);
//        	jdbcTemplate.execute(comtnmenuinfo152);
//        	jdbcTemplate.execute(comtnmenuinfo153);
//        	jdbcTemplate.execute(comtnmenuinfo154);
//        	jdbcTemplate.execute(comtnmenuinfo155);
//        	jdbcTemplate.execute(comtnmenuinfo156);
//        	jdbcTemplate.execute(comtnmenuinfo157);
//        	jdbcTemplate.execute(comtnmenuinfo158);
//        	jdbcTemplate.execute(comtnmenuinfo159);
//        	jdbcTemplate.execute(comtnmenuinfo160);
//        	jdbcTemplate.execute(comtnmenuinfo161);
//        	jdbcTemplate.execute(comtnmenuinfo162);
//        	jdbcTemplate.execute(comtnmenuinfo163);
        }
    }
}
