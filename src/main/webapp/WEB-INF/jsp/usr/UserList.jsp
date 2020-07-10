<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>일반회원관리 목록</title>
<%@ include file="/WEB-INF/jsp/cmm/head.jsp" %>


<script type="text/javaScript" language="javascript" defer="defer">

var grdVal;

$(document).ready(function(){
	fn_Select();
});


function fn_Select(){
	
	$("#grd").empty();
	//API호출
	var rtnData = new Object();
	rtnData = fn_calApi("GET", "/user/list", null, false);
	var arr = rtnData.list;
	
 	var ihtml = '';
 	ihtml = ihtml + '<table class="board_list" summary="일반회원관리의 내역에 대한 목록을 출력합니다.">';
 	ihtml = ihtml + '<colgroup><col style="width: 5%;"><col style="width: 3%;"><col style="width: 15%;"><col style="width: 15%;"><col style="width: 20%;"><col style="width: 13%;"><col style="width: 10%;"><col style="width: ;"></colgroup>';
 	ihtml = ihtml + '<thead>';
 	ihtml = ihtml + '<tr>';
 	ihtml = ihtml + '<th>번호</th>';
 	ihtml = ihtml + '<th><input type="checkbox" name="checkAll" class="check2" onclick="javascript:fncCheckAll()" title="전체선택체크박스"></th>';
 	ihtml = ihtml + '<th class="board_th_link">아이디</th>';
 	ihtml = ihtml + '<th>사용자이름</th>';
 	ihtml = ihtml + '<th>사용자이메일</th>';
 	ihtml = ihtml + '<th>전화번호</th>';
 	ihtml = ihtml + '<th>등록일</th>';
 	ihtml = ihtml + '<th>가입상태</th>';
 	ihtml = ihtml + '</tr>';
 	ihtml = ihtml + '</thead>';
 	ihtml = ihtml + '<tbody class="ov">';
	
	for(var i =0; arr.length > i; i++){
		console.log(i+"===" + arr[i].userId + "***" + $("#sbscrbSttus").val() );
		if( $("#sbscrbSttus").val() == "0" || $("#sbscrbSttus").val() == arr[i].sttus){	
    	 	ihtml = ihtml + '<tr>';
    	 	ihtml = ihtml + '<td>' + (i+1) + '</td>';
    	 	ihtml = ihtml + '<td>';
    	 	ihtml = ihtml + '<input name="checkField" title="checkField" type="checkbox"/>';
    	 	ihtml = ihtml + '<input name="id" type="hidden" value="'+arr[i].userId+'"/>';
    	 	ihtml = ihtml + '</td>';
//     	 	ihtml = ihtml + '<td><button onclick="fn_SelectUser(\''+arr[i].userId+'\')">'+arr[i].userId+'</button></td>';
    	 	ihtml = ihtml + '<td><a onclick="fn_SelectUser(\''+arr[i].userId+'\')">'+arr[i].userId+'</a></td>';
    	 	ihtml = ihtml + '<td id="name">'+arr[i].userNm+'</td>';
    	 	ihtml = ihtml + '<td id="adres">'+arr[i].emailAdres+'</td>';
    	 	ihtml = ihtml + '<td id="telNo">'+arr[i].areaNo+')'+arr[i].middleTelno+'-'+arr[i].endTelno+'</td>';
    	 	ihtml = ihtml + '<td>'+arr[i].changedt+'</td>';

    	 	var sttus = "-";
    	 	if(arr[i].sttus == "A"){
    	 		sttus = "가입신청";
        	}else if(arr[i].sttus == "D"){
        		sttus = "삭제";
        	}else if(arr[i].sttus == "P"){
        		sttus = "승인";
        	}
    	 	ihtml = ihtml + '<td>'+sttus+'</td>';
    	 	ihtml = ihtml + '</tr>';
		}
    }

 	ihtml = ihtml + '</tbody>';
 	ihtml = ihtml + '</table>';
 	
	var grd = document.getElementById("grd");
	grd.innerHTML = ihtml;
}


function fn_SelectUser(userId){
	location.href=baseUrl + "/UserInfo?callType=r&userId="+userId;
}


function fn_DeleteUser(){
	var ckId = new Array();
	ckId = checkFieldck();
	
	for(var i=0; ckId.length > i; i++){
		var userId = ckId[i];
		console.log(ckId.length + "===" +ckId[i] );
		
		var rtnData = new Object();
		var paramData = new Object();
		paramData.userId = userId;

		//API호출
		rtnData = fn_calApi("DELETE", "/user/deleteUsr", paramData, false);
// 		alert(rtnData.RESULTCD);
	}
	fn_Select();



	return;
	
// 	for(var i=0; ckId.length > i; i++){
// 		var userId = ckId[i];
// 		console.log(ckId.length + "===" +ckId[i] );
// 	    $.ajax({
// 	        type : "DELETE", //전송방식을 지정한다 (POST,GET)
// 	        url : "http://localhost:9085/user/deleteUsr?userId="+userId,//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
// 	        dataType : "text",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
// 	        error : function(){    //error: whenError
// 	            alert("통신실패!!!!");
// 	        },
// 	        success : function(data){    //success: whenSuccess,
// 	        	console.log("delete Data::"+data);
// 	        	fn_Select();
// 	        }
// 	    });
// 	}
}

function checkFieldck(){
	var rowData = new Array();
	var checkbox = $("input[name=checkField]:checked");
	
	checkbox.each(function(i) {
		
		var tr = checkbox.parent().parent().eq(i);
		var td = tr.children();
		var id = td.eq(2).text();
		console.log(">>>>" + id);
		rowData.push(id);
	});
	console.log("rowData : " + rowData);
	
	return rowData;
}

function fn_ArovUser(){
	location.href=baseUrl+"/UserInfo?callType=c&userId=";
}

</script>
</head>

<body>
<!-- javascript warning tag  -->
<noscript class="noScriptTitle">자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>
<div class="board">
	<h1>회원관리 목록</h1>
	<!-- 검색영역 -->
	<div class="search_box" title="이 레이아웃은 하단 정보를 대한 검색 정보로 구성되어 있습니다.">
		<ul>
			<li><!-- 상태-->
                <select name="sbscrbSttus" id="sbscrbSttus" title="가입상태조건 선택">
                    <option value="0" selected="selected" >상태(전체)</option><!-- 상태(전체) -->
                    <option value="A"  >가입신청</option><!-- 가입신청 -->
                    <option value="D"  >삭제</option><!-- 삭제 -->
                    <option value="P"  >승인</option><!-- 승인 -->
                </select>
			</li>
<!-- 			<li>조건 -->
<!--                 <select name="searchCondition" id="searchCondition" title="조회조건 선택"> -->
<!--                     <option value="0"  >ID</option>ID  -->
<!--                     <option value="1" selected="selected" >이름</option>Name -->
<!--                 </select> -->
<!-- 			</li> -->
			<!-- 검색키워드 및 조회버튼 -->
			<li>
<!-- 				<input class="s_input" name="searchKeyword" type="text"  size="35" title="검색어 입력" value=''  maxlength="255" > -->
				<input type="button" class="s_btn" onClick="fn_Select();" value="조회" title="조회 버튼" />
				<input type="button" class="s_btn" onClick="fn_DeleteUser();" value="삭제" title="삭제 버튼" />
				<input type="button" class="s_btn" onClick="fn_ArovUser();" value="등록" title="등록 버튼" />
<!-- 				<span class="btn_b"><a href="/egovframework-all-in-one/uss/umt/EgovMberInsertView.do" onClick="fnAddUserView(); return false;"  title="등록 버튼">등록</a></span> -->
			</li>
		</ul>
	</div>

	<div id="grd"></div>
	<!-- paging navigation -->
<!-- 	<div class="pagination"> -->
<!-- 		<ul> -->
<!-- 			<li class="current"><a onClick="return false;">1</a></li> -->
<!-- 		</ul> -->
<!-- 	</div> -->
</div>
<input name="selectedId" type="hidden" />
<input name="checkedIdForDel" type="hidden" />
<input name="pageIndex" type="hidden" value="1"/>

</body>
</html>