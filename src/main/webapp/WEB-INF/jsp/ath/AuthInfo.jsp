<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>사용자관리</title>
<%@ include file="/WEB-INF/jsp/cmm/head.jsp" %>

<script type="text/javaScript" language="javascript" defer="defer">

	var iddbck 		= false;
    var bCancel 	= false;
    var caltype 	= "<%=request.getParameter("callType") %>";
    var authId 		= "<%=request.getParameter("authId") %>";


 /*********************************************************
  * 초기화
  ******************************************************** */
	$(document).ready(function(){
		$("#inCrdt").attr("disabled",true);
		inputCellSet(caltype);
	});

/*********************
 * 화면 기능 사용 정의
 *********************/
	function inputCellSet(type) {
		//호출타입에 따라 입력환경 설정
		if(type == "c"){ //insert
			$("#inAuthId").val("");
			$("#btn_Delete").attr("disabled",true);
			$("#btn_Update").attr("disabled",true);
			$("#btn_Modify").attr("disabled",true);
		}else if(type == "r"){  //readOnly
			$("#btn_Insert").css("display","none");
			$("#btn_Update").attr("disabled",true);
			$("#btn_Delete").attr("disabled",false);
			$("#btn_Modify").attr("disabled",false);
			
			$("#inAuthId").attr("disabled",true);
			$("#inAuthNm").attr("disabled",true);
			$("#inAuthDc").attr("disabled",true);
			$("#inCrdt").attr("disabled",true);
			
			fn_DetailAuth();
		}else if(type == "u"){ //modify
			$("#btn_Insert").attr("disabled",true);
			$("#btn_Update").attr("disabled",false);
			$("#btn_Delete").attr("disabled",false);
			$("#btn_Modify").attr("disabled",true);;
			
			$("#inAuthId").attr("readonly",true);
			$("#inAuthNm").attr("disabled",false);
			$("#inAuthDc").attr("disabled",false);
		}else if(type == "ur"){ //modify
			fn_DetailAuth();
		}
	}

/*********************
 * 입력 필수값 체크
 *********************/
	function required() {
		if($.trim($("#inAuthId").val()).length == 0){
			alert("그룹아이디은(는) 필수 입력값입니다.");$("#inAuthId").focus();return;
		}
	}

/*********************
 * 입력값 길이 체크
 *********************/
	function maxlength() {
		if($.trim($("#inAuthId").val()).length >= 20){
			alert("그룹아이디은(는) 20자 이상 입력할수 없습니다.");$("#inAuthId").focus();return false;
		} else if($.trim($("#inAuthNm").val()).length >= 50){
			alert("그룹명은(는) 50자 이상 입력할수 없습니다.");$("#inAuthNm").focus();return;
		} else if($.trim($("#inAuthDc").val()).length >= 100){
			alert("그룹설명은(는) 100자 이상 입력할수 없습니다.");$("#inAuthDc").focus();return;
		}
	}
	



/**************
 * 권한 정보 조회
 **************/
	function fn_DetailAuth(){ //ok
		var pAuthId="";
		if(authId == null || authId == ""){
			pAuthId = $("#inAuthId").val();
		}else{
			pAuthId = authId;
		}
		
		var rtnData = new Object();
		var arrlist = new Array();
		rtnData = fn_calApi("GETpath", "/auth/detailInfo/"+pAuthId, null, false);
		arrlist = rtnData.list;
		const obj2 = arrlist[0];
		$("#inAuthId").val(obj2.author_code);
		$("#inAuthId").attr("disabled",true);
		$("#inAuthNm").val(obj2.author_nm);
		$("#inAuthDc").val(obj2.author_dc);
		$("#inCrdt").val(obj2.author_creat_dt);
		
	}

/*********************************************************
 * 권한등록
 ******************************************************** */
	function fn_insert(){ //ok
	
		if(confirm("등록하시겠습니까?")){
			if(required()==false) return; //필수값 체크
			if(maxlength()==false) return; //최대 길이 체크
		}
		
		var paramData = new Object();
		paramData.authCd	=	$("#inAuthId").val();
		paramData.authNm	=	$("#inAuthNm").val();
		paramData.authDc	=	$("#inAuthDc").val();
		
		var rtnData = new Object();
		rtnData = fn_calApi("POST", "/auth/addnew", paramData, false);
	
		alert(rtnData.RESULTMSG);
		inputCellSet("r");
		
	}

/*********************************************************
 * 그룹 수정 
 ******************************************************** */
	function fn_update(){  //ok
	
		if(confirm("저장 하시겠습니까?")){
			if(required()==false) return; //필수값 체크
			if(maxlength()==false) return; //최대 길이 체크
		}
		
		var paramData = new Object();
		paramData.authCd	=	$("#inAuthId").val();
		paramData.authNm	=	$("#inAuthNm").val();
		paramData.authDc	=	$("#inAuthDc").val();
	
		var rtnData = new Object();
		rtnData = fn_calApi("PUT", "/auth/modifyInfo", paramData, false);
	
		alert(rtnData.RESULTMSG);
		inputCellSet("ur");
	}

/*********************************************************
 * 권한정보 삭제
 ******************************************************** */
	function fn_delete(){
		var rtnData = new Object();
		var paramData = new Object();
		paramData.authCd = $("#inAuthId").val();
		//API호출
		rtnData = fn_calApi("DELETE", "/auth/delete", paramData, false);
		alert(rtnData.RESULTMSG);
		
		fn_moveAuthList();
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
	function fn_moveAuthList(){
		location.href="/AuthList";
	}

	function fn_modify(){
		inputCellSet("u");
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
			<th><label for="inAuthId">권한아이디</label> <span class="pilsu">*</span></th>
			<td class="left">
				<input id="inAuthId" name="inAuthId" title="아이디 입력" type="text" value="" size="20" maxlength="20"/>
			</td>
		</tr>
		
		<!-- 권한명 -->
		<tr>
			<th><label for="inAuthNm">권한명</label></th>
			<td class="left">
				<input id="inAuthNm" name="inAuthNm" title="권한이름 입력" type="text" value="" size="50" maxlength="50"/>
			</td>
		</tr>
		
		<!-- 권한 설명 -->
		<tr>
			<th><label for="inAuthDc">권한 설명</label></th>
			<td class="left">
				<textarea id="inAuthDc" name="inAuthDc" title="권한설명 입력" type="" style="resize: none;"></textarea>
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
	<button title="수정" 			id="btn_Modify" 		onclick="fn_modify();">수정</button>
	<button title="저장" 			id="btn_Update" 		onclick="fn_update();">저장</button>
	<button title="삭제" 			id="btn_Delete" 		onclick="fn_delete();">삭제</button>
</body>
</html>