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
		alert("해당 화면은 '권한그룹 목록 조회'화면을 통해 호출 되어야 정상 동작 합니다.");
		//입력정보
		$("#inAuthGrpId").attr("readonly",true);
		$("#inAuthGrpNm").attr("readonly",true);
		$("#inAuthGrpDc").attr("readonly",true);

		$("#btn_RowAdd").css("display","none");
		$("#btn_insert").css("display","none");
		$("#btn_Del").css("display","none");
		
	}else if(type == "r"){  //readOnly
		$("#inAuthGrpId").attr("readonly",true);
		$("#inAuthGrpNm").attr("readonly",true);
		$("#inAuthGrpDc").attr("readonly",true);
		fn_DetailAuthGrp();
	}
	$("#inAuthGrpId").val(authGrp);
}

//입력 필수값 체크
function required() {
	if($.trim($("#inAuthGrpId").val()).length == 0){
		alert("권한그룹 아이디은(는) 필수 입력값입니다.");$("#inAuthGrpId").focus();return false;
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
	console.log("detail param:===" + pAuthGrp );

	var rtnData = new Object();
	rtnData = fn_calApi("GET", "/authgrp/detailInfo/"+pAuthGrp, null, false);
	var arrlist = new Array();
	arrlist = rtnData.list;
	const obj2 = arrlist[0]; 
	
	$("#inAuthGrpId").val(pAuthGrp);
	$("#inAuthGrpNm").val(obj2.author_grp_nm);
	$("#inAuthGrpDc").val(obj2.author_grp_dc);
	
}

/********
 * 그룹 목록 조회
 ********/
function fn_Select(){
	
	$("#setGroup").empty();
	//API호출
	var paramData = new Object();
	var rtnData = new Object();
	paramData.grpAuthCd = $("#inAuthGrpId").val();
	
	rtnData = fn_calApi("POST", "/authgrp/gAuthList", paramData, false);
	var arr = rtnData.list;

 	var ihtml = '';
 	ihtml = ihtml + '<table class="board_list" summary="그룹목록을 출력합니다.">';
 	ihtml = ihtml + '<colgroup><col style="width: 5%;"><col style="width: 3%;"><col style="width: 30%;"><col style="width: ;"></colgroup>'; //<col style="width: 30%;">
 	ihtml = ihtml + '<thead>';
 	ihtml = ihtml + '<tr>';
 	ihtml = ihtml + '<th>번호</th>';
 	ihtml = ihtml + '<th><input type="checkbox" name="checkAll" class="check2" onclick="javascript:fncCheckAll()" title="전체선택체크박스"></th>';
 	ihtml = ihtml + '<th class="board_th_link">권한명</th>';
 	ihtml = ihtml + '<th>설명</th>';
 	ihtml = ihtml + '</tr>';
 	ihtml = ihtml + '</thead>';
 	ihtml = ihtml + '<tbody class="ov">';

	var lopCnt = 0;
	for(var i =0; arr.length > i; i++){
		lopCnt = (i+1);
   	 	ihtml = ihtml + '<tr>';
   	 	ihtml = ihtml + '<td>' + lopCnt + '</td>';
   	 	ihtml = ihtml + '<td>';
   	 	ihtml = ihtml + '<input id="checkField" name="checkField" title="checkField" type="checkbox"/>';
   	 	ihtml = ihtml + '<input id="id_'+(i+1)+'" name="id_'+(i+1)+'" type="hidden" value="'+arr[i].author_code+'">';
   	 	ihtml = ihtml + '</td>';
   	 	ihtml = ihtml + '<td id="authNm_'+(i+1)+'" name="authNm_'+(i+1)+'">'+arr[i].author_nm+'</td>';
	 	ihtml = ihtml + '<td id="authDc_'+(i+1)+'" name="authDc_'+(i+1)+'">'+arr[i].author_dc+'</td>'; 
   	 	ihtml = ihtml + '</tr>';
    }
	grdRowCnt=lopCnt;
 	ihtml = ihtml + '</tbody>';
 	ihtml = ihtml + '</table>';

	var grd = document.getElementById("grdlist");
	grd.innerHTML = ihtml;
}


/********
 * 그룹 추가
 ********/
function fn_RowAdd(){
	grdRowCnt++;	
	$("#setGroup").empty();
	var rtnData = new Object();
 	var ihtml = '';
	var dopDonBox = "";

	rtnData = fn_calApi("GET", "/auth/list", null, false);
	var arr = rtnData.list;
	for(var i =0; arr.length > i; i++){
		dopDonBox = dopDonBox + '<option value="'+arr[i].author_code+'">'+arr[i].author_nm+'</option>'; 
    }
	
	ihtml = ihtml + '<table class="board_list" style="border-top: 1px solid #d2d2d2;" summary="그룹목록을 출력합니다.">';
	ihtml = ihtml + '<tbody class="ov">';
	ihtml = ihtml + '<colgroup><col style="width: 5%;"><col style="width: 3%;"><col style="width: 30%;"><col style="width: ;"></colgroup>';
 	ihtml = ihtml + '<tr>';
 	ihtml = ihtml + '<td>' + grdRowCnt + '</td>';
 	ihtml = ihtml + '<td>';
 	ihtml = ihtml + '<input id="checkField" name="checkField" title="checkField" type="checkbox"  checked="checked" />';
 	ihtml = ihtml + '<input id="id_'+grdRowCnt+'" name="id_'+grdRowCnt+'" type="hidden" value="'+''+'">';
 	ihtml = ihtml + '</td>';
 	ihtml = ihtml + '<td>';
 	ihtml = ihtml + '<select id="authNm_'+grdRowCnt+'" name="authNm_'+grdRowCnt+'" title="권한코드" >'; //onchange="fn_selectSetAuth('+grdRowCnt+')"
 	ihtml = ihtml + '<option value="" selected="selected">--선택하세요--</option>';
 	ihtml = ihtml + dopDonBox
 	ihtml = ihtml + '</td>';
 	ihtml = ihtml + '<td id="authDc_'+grdRowCnt+'" name="authDc_'+grdRowCnt+'">'+''+'</td>';
 	ihtml = ihtml + '</tr>';
 	ihtml = ihtml + '</tbody>';
 	ihtml = ihtml + '</table>';
 	
	var grd = document.getElementById("grdlist");
	grd.insertAdjacentHTML('beforeend', ihtml);
}


/******************
 * 셀렉트 박스 선택시 값 셋팅
 ******************/
function fn_selectSetAuth(row){
	var authDc = $("#authDc_"+row).val();
	$("#authDc_"+row).html(authDc);
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
		paramData.authCd 		= $("#id_"+ckNum).val();

		//API호출
		rtnData = fn_calApi("DELETE", "/authgrp/gAuthSbt", paramData, false);
		alert(rtnData.RESULTMSG);
	}
	fn_Select();
}


/*****************
 * 권한 그룹에 권한 추가 ok
 ******************/
function fn_insert(){
	var insertCk = true;
	if(caltype == "c"){
		if(grpInfoInsert()){
			authInsert();
		}
		caltype = "r";
		fn_Select();
	}else{
		authInsert();
		caltype = "r";
		fn_Select();
	}
}

/*********************************************************
 * 그룹등록 
 ******************************************************** */
function grpInfoInsert(){

	if(confirm("등록하시겠습니까?")){	
		if(required()==false) return false; //필수값 체크
		if(maxlength()==false) return false; //최대 길이 체크
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
		alert("권한 추가 처리내용\n\n" + insSMsg);
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
	<button title="추가" 		id="btn_RowAdd" 		onclick="fn_RowAdd();">Row추가</button>
	<button title="저장" 		id="btn_insert" 		onclick="fn_insert();">저장</button>
	<button title="삭제" 		id="btn_Del" 			onclick="fn_Delete();">삭제</button>
	<br>
	
</body>
</html>