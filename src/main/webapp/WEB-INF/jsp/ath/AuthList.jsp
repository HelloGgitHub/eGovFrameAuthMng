<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>권한 목록</title>
<%@ include file="/WEB-INF/jsp/cmm/head.jsp" %>


<script type="text/javaScript" language="javascript" defer="defer">

var grdVal;

$(document).ready(function(){
	fn_Select();
});


/********
 * 권한 목록 조회
 ********/
function fn_Select(){
	
	$("#grd").empty();
	//API호출
	var rtnData = new Object();
	rtnData = fn_calApi("GET", "/auth/list", null, false);
	var arr = rtnData.list;
	
 	var ihtml = '';
 	ihtml = ihtml + '<table class="board_list" summary="권한목록을 출력합니다.">';
 	ihtml = ihtml + '<colgroup><col style="width: 5%;"><col style="width: 3%;"><col style="width: ;"><col style="width: 17%;"><col style="width: 17%;"><col style="width: 20%;"></colgroup>';
 	ihtml = ihtml + '<thead>';
 	ihtml = ihtml + '<tr>';
 	ihtml = ihtml + '<th>번호</th>';
 	ihtml = ihtml + '<th><input type="checkbox" name="checkAll" class="check2" onclick="javascript:fncCheckAll()" title="전체선택체크박스"></th>';
 	ihtml = ihtml + '<th class="board_th_link">권한명</th>';
 	ihtml = ihtml + '<th>보유인원 건수</th>';
 	ihtml = ihtml + '<th>권한그룹 등록건수</th>';
 	ihtml = ihtml + '<th>등록일</th>';
 	ihtml = ihtml + '</tr>';
 	ihtml = ihtml + '</thead>';
 	ihtml = ihtml + '<tbody class="ov">';
	
	for(var i =0; arr.length > i; i++){
   	 	ihtml = ihtml + '<tr>';
   	 	ihtml = ihtml + '<td>' + (i+1) + '</td>';
   	 	ihtml = ihtml + '<td>';
   	 	ihtml = ihtml + '<input id="checkField" name="checkField" title="checkField" type="checkbox"/>';
   	 	ihtml = ihtml + '<input id="id_'+(i+1)+'" name="id_'+(i+1)+'" type="hidden" value="'+arr[i].author_code+'">';
   	 	ihtml = ihtml + '</td>';
   	 	ihtml = ihtml + '<td><a onclick="fn_SelectAuth(\''+arr[i].author_code+'\')">'+arr[i].author_nm+'</a></td>';
   	 	ihtml = ihtml + '<td id="userCnt_'+(i+1)+'" name="userCnt_'+(i+1)+'"><a onclick="fn_SelectUserCnt(\''+arr[i].author_code+'\')">'+arr[i].usrcnt+'</a></td>';
	 	ihtml = ihtml + '<td id="grpCnt_'+(i+1)+'" name="grpCnt_'+(i+1)+'"><a onclick="fn_SelectGrpCnt(\''+arr[i].author_code+'\')">'+arr[i].grpcnt+'</a></td>';
// 	 	ihtml = ihtml + '<td id="name_'+(i+1)+'" name="name_'+(i+1)+'">'+arr[i].usrcnt+'</td>';
   	 	ihtml = ihtml + '<td id="creatDt_'+(i+1)+'" name="creatDt_'+(i+1)+'">'+arr[i].author_creat_dt+'</td>';
   	 	ihtml = ihtml + '</tr>';
    }
 	ihtml = ihtml + '</tbody>';
 	ihtml = ihtml + '</table>';
 	
	var grd = document.getElementById("grd");
	grd.innerHTML = ihtml;
}


function fn_SelectAuth(authId){
	//관리자일 경우 업데이트				//본인확인방법 로직 추가/////////////////////////////////////////////////////////////////
	//그렇지 않은 경우 로드만
	var pageType= "r";
	if(authId == ""){         ////////////////
		pageType= "u";
	}
	location.href=baseUrl + "/AuthInfo?callType="+pageType+"&authId="+authId;
}

function fn_SelectUserCnt(authId){
	//관리자일 경우 업데이트				//본인확인방법 로직 추가/////////////////////////////////////////////////////////////////
	//그렇지 않은 경우 로드만
	var pageType= "r";
	if(authId == ""){         ////////////////
		pageType= "u";
	}
	location.href=baseUrl + "/UserGroupSet?callType="+pageType+"&authId="+authId;
}


function fn_Delete(){  //ok
	var ckId = new Array();
	ckId = checkFieldck();
	
	for(var i=0; ckId.length > i; i++){
		var ckNum = ckId[i];
		console.log(ckId.length + "===" +ckId[i] );
		
		var rtnData = new Object();
		var paramData = new Object();
		paramData.authCd = $("#id_"+ckNum).val();

		//API호출
		rtnData = fn_calApi("DELETE", "/auth/delete", paramData, false);
		alert(rtnData.RESULTMSG);
	}
	fn_Select();
}


function checkFieldck(){
	var rowData = new Array();
	var checkbox = $("input[name=checkField]:checked");
	
	checkbox.each(function(i) {
		var tr = checkbox.parent().parent().eq(i);
		var td = tr.children();
		var id = td.eq(0).text();
		rowData.push(id);
	});
	console.log("rowData : " + rowData);
	
	return rowData;
}


function fn_Insert(){
	location.href=baseUrl+"/AuthInfo?callType=c&authId=";
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////체크박스 전체 선택!!! 더 개발해야함.
function fncCheckAll(){
	var rowData = new Array();
	var checkbox = $("input[name=checkField]:checked");
	console.log(">>>"+checkbox.parent().parent().eq(1).value);
// 	checkbox.parent().parent().eq(i)
}

</script>
</head>

<body>
<!-- javascript warning tag  -->
<noscript class="noScriptTitle">자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>
<div class="board">
	<h1>권한 목록</h1>
	<!-- 검색영역 -->
	<div class="search_box" title="이 레이아웃은 하단 정보를 대한 검색 정보로 구성되어 있습니다.">
		<ul>
			<li>
				<input type="button" class="s_btn" onClick="fn_Select();" 	value="조회" title="조회 버튼" />
				<input type="button" class="s_btn" onClick="fn_Delete();" 	value="삭제" title="삭제 버튼" />
				<input type="button" class="s_btn" onClick="fn_Insert();" 	value="등록" title="등록 버튼" />
			</li>
		</ul>
	</div>
	<div id="grd"></div>
</div>
</body>
</html>