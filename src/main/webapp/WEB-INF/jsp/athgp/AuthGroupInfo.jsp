<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>사용자관리</title>
<%@ include file="/WEB-INF/jsp/cmm/head.jsp" %>

<script type="text/javaScript" language="javascript" defer="defer">

    var caltype 	= "<%=request.getParameter("callType") %>";
    var authGrpId	= "<%=request.getParameter("authGrpId") %>";


 /*********************************************************
  * 초기화
  ******************************************************** */
	$(document).ready(function(){
		inputCellSet(caltype);
	});

	/*********************
	 * 화면 기능 사용 정의
	 *********************/
		function inputCellSet(type) {
			//호출타입에 따라 입력환경 설정
			if(type == "c"){ //insert
				$("#inAuthGrpId").val("");
				$("#inCrdt").attr("disabled",true);
				$("#btn_Del").attr("disabled",true);
				$("#btn_Update").attr("disabled",true);
			}else if(type == "r"){  //readOnly
				$("#inAuthGrpId").attr("disabled",true);
				$("#inCrdt").attr("disabled",true);
				$("#btn_Insert").css("display","none");
				$("#btn_Del").attr("disabled",false);
				$("#btn_Update").attr("disabled",false);
				fn_DetailAuthGrp();
			}
		}

/*********************
 * 입력 필수값 체크
 *********************/
	function required() {
		if($.trim($("#inAuthGrpId").val()).length == 0){alert("그룹아이디은(는) 필수 입력값입니다.");$("#inAuthGrpId").focus();return false;
		}
	}

/*********************
 * 입력값 길이 체크
 *********************/
	function maxlength() {
		if($.trim($("#inAuthGrpId").val()).length >= 20){
			alert("그룹아이디은(는) 20자 이상 입력할수 없습니다.");$("#inAuthGrpId").focus();return false;
		} else if($.trim($("#inAuthGrpNm").val()).length >= 50){
			alert("그룹명은(는) 50자 이상 입력할수 없습니다.");$("#inAuthGrpNm").focus();return false;
		} else if($.trim($("#inAuthGrpDc").val()).length >= 100){
			alert("그룹설명은(는) 100자 이상 입력할수 없습니다.");$("#inAuthGrpDc").focus();return false;
		}
	}
	





/*********************************************************
 * 그룹등록 신청
 ******************************************************** */
	function fn_insert(){
	
		if(confirm("등록하시겠습니까?")){
			if(required()==false) return; //필수값 체크
			if(maxlength()==false) return; //최대 길이 체크
		}

		var groupData = new Object();
		groupData.authGrpCd	=	$("#inAuthGrpId").val();
		groupData.authGrpNm	=	$("#inAuthGrpNm").val();
		groupData.authGrpDc	=	$("#inAuthGrpDc").val();
		
		var rtnData = new Object();
		rtnData = fn_calApi("POST", "/authgrp/addnew", groupData, false);
	
		alert(rtnData.RESULTMSG);
		inputCellSet("r");
	}

/**************
 * 그룹 정보 조회
 **************/
	function fn_DetailAuthGrp(){

		var pAuthGrp="";
		if(authGrpId == null || authGrpId == ""){
			pAuthGrp = $("#inAuthGrpId").val();
		}else{
			pAuthGrp = authGrpId;
		}
		
		console.log("detail param:===" + pAuthGrp );
		var rtnData = new Object();
		var arrlist = new Array();
		rtnData = fn_calApi("GET", "/authgrp/detailInfo/"+pAuthGrp, null, false);
		arrlist = rtnData.list;
		const obj2 = arrlist[0];
		$("#inAuthGrpId").val(obj2.author_grp_code);
		$("#inAuthGrpId").attr("disabled",true);
		$("#inAuthGrpNm").val(obj2.author_grp_nm);
		$("#inAuthGrpDc").val(obj2.author_grp_dc);
		$("#inCrdt").val(obj2.author_grp_creat_dt);
		
	}

/*********************************************************
 * 그룹 수정 
 ******************************************************** */
	function fn_update(){
	
		if(confirm("저장 하시겠습니까?")){
			if(required()==false) return; //필수값 체크
			if(maxlength()==false) return; //최대 길이 체크
		}

		var paramData = new Object();
		paramData.authGrpCd	=	$("#inAuthGrpId").val();
		paramData.authGrpNm	=	$("#inAuthGrpNm").val();
		paramData.authGrpDc	=	$("#inAuthGrpDc").val();
	
		var rtnData = new Object();
		rtnData = fn_calApi("PUT", "/authgrp/modifyInfo", paramData, false);
	
		alert(rtnData.RESULTMSG);
		inputCellSet("r");
	}

/*********************************************************
 * 그룹정보 삭제
 ******************************************************** */
	function fn_delete(){
		
		var rtnData = new Object();
		var paramData = new Object();
		paramData.authGrpCd = $("#inAuthGrpId").val();
		//API호출
		rtnData = fn_calApi("DELETE", "/authgrp/delete", paramData, false);
		
		fn_moveAuthGrpList();
	}

/*************
 * 뒤로가기
 *************/
	function fn_movebak(){
		window.history.back();	
	}

/******************
 * 목록페이지로 돌아가기
 ******************/
	function fn_moveAuthGrpList(){
		location.href="/AuthGrpList";
	}

	
</script>
</head>

<body>
	<div class="wTableFrm">
	<!-- 타이틀 -->
	<h2 >그룹관리 </h2>
	<!-- 등록폼 -->
	<table class="wTable" summary="그룹관리의 그룹정보를 출력합니다.">
	<caption>그룹관리</caption>
	<colgroup>
		<col style="width: 22%;"><col style="width: ;">
	</colgroup>
	<tbody>
	
		<!-- 권한 -->
		<tr>
			<th><label for="inAuthGrpId">권한그룹아이디</label> <span class="pilsu">*</span></th>
			<td class="left">
				<input id="inAuthGrpId" name="inAuthGrpId" title="아이디 입력" type="text" value="" size="20" maxlength="20"/>
			</td>
		</tr>
		
		<!-- 권한명 -->
		<tr>
			<th><label for="inAuthGrpNm">권한그룹명</label></th>
			<td class="left">
				<input id="inAuthGrpNm" name="inAuthGrpNm" title="권한그룹이름 입력" type="text" value="" size="50" maxlength="50"/>
			</td>
		</tr>
		
		<!-- 권한 설명 -->
		<tr>
			<th><label for="inAuthGrpDc">권한그룹 설명</label></th>
			<td class="left">
<!-- 				<input id="grpdis" name="grpdis" title="비밀번호 입력" type=" value="" size="50" maxlength="20"/> -->
				<textarea id="inAuthGrpDc" name="inAuthGrpDc" title="권한그룹 설명 입력" type="" style="resize: none;"></textarea>
			</td>
		</tr>
		<!-- 권한명 -->
		<tr>
			<th><label for="inCrdt">생성일시</label></th>
			<td class="left">
				<input id="inCrdt" name="inCrdt" title="생성 일시" type="text" value="" size="50" maxlength="50"/>
			</td>
		</tr>
		
	</tbody>
	</table>
	<br>
	<!-- 하단 버튼 -->
	<button title="등록" 			id="btn_Insert" 		onclick="fn_insert();">등록</button>
	<button title="수정" 			id="btn_Update" 		onclick="fn_update();">수정</button>
	<button title="삭제" 			id="btn_Del" 			onclick="fn_delete();">삭제</button>
	<br>

</body>
</html>