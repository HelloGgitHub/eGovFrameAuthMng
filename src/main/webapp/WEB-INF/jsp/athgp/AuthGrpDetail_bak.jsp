<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>권한그룹 관리</title>
<%@ include file="/WEB-INF/jsp/cmm/head.jsp" %>

<script type="text/javaScript" language="javascript" defer="defer">

    var bCancel 		= false;
    var caltype 		= "<%=request.getParameter("callType") %>";
    var authGrp 		= "<%=request.getParameter("authGrpId") %>";
	var grdRowCnt 	= 0;
	
/*********************************************************
 * 초기화
 *********************************************************/
$(document).ready(function(){
	inputCellSet(caltype);
	fn_Select();
});


function inputCellSet(type) {
	//호출타입에 따라 입력환경 설정
	if(type == "c"){ //insert
		//입력정보
// 		$("#inAuthGrpId").attr("readonly",true);
// 		$("#inAuthGrpNm").attr("readonly",true);
	}else if(type == "r"){  //readOnly
		$("#inAuthGrpId").attr("readonly",true);
		$("#inAuthGrpNm").attr("readonly",true);
		$("#inAuthGrpDc").attr("readonly",true);
		fn_DetailAuthGrp();
	}else if(type == "u"){ //modify
		$("#btn_insert").attr("disabled",true);
		$("#inAuthGrpId").attr("readonly",true);
	}
	$("#inAuthGrpId").val(authGrp);
}

//입력 필수값 체크
function required() {
	if($.trim($("#inAuthGrpId").val()).length == 0){
		alert("권한그룹 아이디은(는) 필수 입력값입니다.");$("#inAuthGrpId").focus();return;
	}
}

//입력값 길이 체크
function maxlength() { 
	if($.trim($("#inAuthGrpId").val()).length >= 20){
		alert("권한그룹 아이디은(는) 20자 이상 입력할수 없습니다.");$("#inAuthGrpId").focus();return false;
	}
}
	





/*********************************************************
 * 권한그룹 정보 조회
 ******************************************************** */
function fn_DetailAuthGrp(){
	var pAuthGrp="";
	if(authGrp == null || authGrp == ""){
		pAuthGrp = $("#inAuthGrpId").val();
	}else{
		pAuthGrp = authGrp;
	}

	var rtnData = new Object();
	rtnData = fn_calApi("GET", "/authgrp/detailInfo/"+pAuthGrp, null, false);
	var arrlist = new Array();
	arrlist = rtnData.list;
	const obj2 = arrlist[0]; 
	
	$("#inAuthGrpId").val(pAuthGrp);
	$("#inAuthGrpNm").val(obj2.author_grp_nm);
	$("#inAuthGrpDc").val(obj2.author_grp_dc);
	
}


/*****************
 * 권한그룹 권한 제거
 ******************/
function fn_Delete(){
	var ckId = new Array();
	ckId = checkFieldck();
	
	for(var i=0; ckId.length > i; i++){
		var ckNum = ckId[i];
		var rtnData = new Object();
		var paramData = new Object();
		paramData.grpAuthCd 	= $("#inAuthGrpId").val();
		paramData.authCd 		= $("#authNm_"+ckNum).val();

		//API호출
		rtnData = fn_calApi("DELETE", "/authgrp/gAuthSbt", paramData, false);
		alert(rtnData.RESULTMSG);
	}
	fn_Select();
}


/*********************************************************
 * 그룹등록 
 ******************************************************** */
function grpInfoInsert(){

	if(confirm("등록하시겠습니까?")){	
		required();
		maxlength();
	}
	
	var paramData = new Object();
	paramData.authGrpCd	=	$("#inAuthGrpId").val();
	paramData.authGrpNm	=	$("#inAuthGrpNm").val();
	paramData.authGrpDc	=	$("#inAuthGrpDc").val();
	rtnData = fn_calApi("POST", "/authgrp/addnew", paramData, false);

	if(rtnData.RESULTCD == "1"){
		alert(rtnData.RESULTMSG);
		return false;	
	}
	return true;	
}

/*****************
 * 권한 그룹에 권한 추가
 ******************/
function authInsert(){
	var insSMsg = "";
	var insSCnt = 0;
	var ckId = new Array();
	ckId = checkFieldck();
	
	for(var i=0; ckId.length > i; i++){
		var ckNum = ckId[i];
		var rtnData = new Object();
		var paramData = new Object();
		paramData.grpAuthCd 	= $("#inAuthGrpId").val();
		paramData.authCd 		= $("#authNm_"+ckNum).val();

		alert($("#authNm_"+ckNum).val());
		if($("#authNm_"+ckNum).val()=="" || $("#authNm_"+ckNum).val() == null || $("#authNm_"+ckNum).val() == "undefined"){
			insSMsg = insSMsg + "번호 " + ckNum + " : 선택된 내용이 없습니다.\n";
		}else{
			//API호출
			rtnData = fn_calApi("POST", "/authgrp/gAuthAdd", paramData, false);
			insSMsg = insSMsg + "번호 " + ckNum + " : " +rtnData.RESULTMSG + "\n";
		}
		insSCnt++;
	}
	
	if(insSCnt > 0){
		alert("권한 추가 처리내용\n" + insSMsg);
	}
}

/***************
 * 체크박스 여부 확인
 ***************/
function checkFieldck(){
	var rowData = new Array();
	var checkbox = $("input[name=checkField]:checked");
	
	checkbox.each(function(i) {
		var tr = checkbox.parent().parent().eq(i);
		var td = tr.children();
		var id = td.eq(0).text();
		rowData.push(id);
	});
	return rowData;
}

/*************
 * 뒤로가기
 *************/
function fn_movebak(){
	window.history.back();	
}

</script>
</head>

<body>
	<div class="wTableFrm">
		<h2 >권한그룹</h2>
		<table class="wTable" summary="권한그룹">
			<caption>권한그룹</caption>
			<colgroup>
				<col style="width: 22%;"><col style="width: ;">
			</colgroup>
			<tbody>
				<tr>
					<th><label for="inAuthGrpId">권한그룹 아이디</label></th>
					<td class="left">
						<input id="inAuthGrpId" name="inAuthGrpId" title="권한그룹아이디" type="text" value="" size="20" maxlength="20" style="width:100%;"/>
					</td>
				</tr>
				
				<tr>
					<th><label for="inAuthGrpNm">권한그룹 명</label></th>
					<td class="left">
						<input id="inAuthGrpNm" name="inAuthGrpNm" title="권한그룹 명" type="text" value="" size="50" maxlength="50" style="width:100%;"/>
					</td>
				</tr>
				<tr>
					<th><label for="inAuthGrpDc">권한그룹 설명</label></th>
					<td class="left">
						<textarea id="inAuthGrpDc" name="inAuthGrpDc" title="권한그룹 설명" type="" style="resize: none;"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<br/>
	
	<div class="wTableFrm">
		<h2>권한</h2>
		<div id="grdlist"></div>
	</div>
	<br>
	
	<!-- 하단 버튼 -->
	<button title="추가" 		id="btn_RowAdd" 		onclick="fn_RowAdd();">추가</button>
	<button title="저장" 		id="btn_insert" 		onclick="fn_insert();">저장</button>
	<button title="삭제" 		id="btn_Del" 			onclick="fn_Delete();">삭제</button>
	<br>
	
</body>
</html>