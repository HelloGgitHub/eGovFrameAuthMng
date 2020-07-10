<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>일반회원관리 목록</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="/css/egovframework/com/com.css">

<script src="/js/egovframework/com/cmm/jquery-1.4.2.min.js"></script>
<script type="text/javaScript" language="javascript" defer="defer">

$(document).ready(function(){
	makeGrid();
    $.ajax({
        type : "GET", //전송방식을 지정한다 (POST,GET)
        url : "http://localhost:9085/user/list",//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
        dataType : "text",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
        error : function(){    //error: whenError
            alert("통신실패!!!!");
        },
        success : function(Parse_data){    //success: whenSuccess,
            $("#Parse_Area").html(Parse_data); //div에 받아온 값을 넣는다.
            
            console.log(Parse_data);
//             alert("통신 데이터 값 : " + Parse_data);
        }
    });
});


function makeGrid(){

 	var ihtml = 'DDddddddddddd';
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
 	ihtml = ihtml + '<tr>';
 	ihtml = ihtml + '<td>1</td>';
 	ihtml = ihtml + '<td>';
 	ihtml = ihtml + '<input name="checkField" title="checkField 1" type="checkbox"/>';
 	ihtml = ihtml + '<input name="checkId" type="hidden" value="USR01:USRCNFRM_00000000023"/>';
 	ihtml = ihtml + '</td>';
 	ihtml = ihtml + '<td><a href="/egovframework-all-in-one/uss/umt/EgovMberSelectUpdtView.do?selectedId=USRCNFRM_00000000023"  onclick="javascript:fnSelectUser(\'USR01:USRCNFRM_00000000023\'); return false;">crossent</a></td>';
 	ihtml = ihtml + '<td>크로센트</td>';
 	ihtml = ihtml + '<td>crossent@crossent.co.kr</td>';
 	ihtml = ihtml + '<td>02)115-1155</td>';
 	ihtml = ihtml + '<td>2020-03-05</td>';
 	ihtml = ihtml + '<td>';
 	ihtml = ihtml + '회원 가입 승인 상태';
 	ihtml = ihtml + '</td>';
 	ihtml = ihtml + '</tr>';
	
	var randValNode = document.getElementById("grd");
	randValNode.innerHTML = "<b><font color='red'>"+Math.random()+"</font></b>" + ihtml;

}


</script>
</head>

<body>
<!-- javascript warning tag  -->
<noscript class="noScriptTitle">자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>

<form name="listForm" action="http://localhost:8081/MemberList" method="post"> 
<div class="board">
	<h1>일반회원관리 목록</h1>
	
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
			<li><!-- 조건 -->
                <select name="searchCondition" id="searchCondition" title="조회조건 선택"><!--  -->
                    <option value="0"  >ID</option><!-- ID  -->
                    <option value="1" selected="selected" >이름</option><!-- Name -->
                </select>
			</li>
			<!-- 검색키워드 및 조회버튼 -->
			<li>
				<input class="s_input" name="searchKeyword" type="text"  size="35" title="검색어 입력" value=''  maxlength="255" >
				<input type="submit" class="s_btn" value="조회" title="조회 버튼" />
				<input type="button" class="s_btn" onClick="fnDeleteUser(); return false;" value="삭제" title="삭제 버튼" />
				<span class="btn_b"><a href="/egovframework-all-in-one/uss/umt/EgovMberInsertView.do" onClick="fnAddUserView(); return false;"  title="등록 버튼">등록</a></span>
			</li>
		</ul>
	</div>
	
<div id="grd"></div>

<table class="board_list" summary="일반회원관리의 내역에 대한 목록을 출력합니다.">
	<caption>일반회원관리 목록</caption>
	<colgroup>
		<col style="width: 5%;">
		<col style="width: 3%;">
		
		<col style="width: 15%;">
		<col style="width: 15%;">
		<col style="width: 20%;">
		<col style="width: 13%;">
		<col style="width: 10%;">
		<col style="width: ;">
	</colgroup>
	<thead>
	<tr>
		<th>번호</th><!-- 번호 -->
		<th><input type="checkbox" name="checkAll" class="check2" onclick="javascript:fncCheckAll()" title="전체선택체크박스"></th><!-- 전체선택 -->
		
		<th class="board_th_link">아이디</th><!--아이디 -->
		<th>사용자이름</th><!-- 사용자이름 -->
		<th>사용자이메일</th><!-- 사용자이메일 -->
		<th>전화번호</th><!-- 전화번호 -->
		<th>등록일</th><!-- 등록일 -->
		<th>가입상태</th><!-- 가입상태 -->

	</tr>
	</thead>
	<tbody class="ov">
	
	
	<tr>
	    <td>1</td>
	    <td>
	        <input name="checkField" title="checkField 1" type="checkbox"/>
	        <input name="checkId" type="hidden" value="USR01:USRCNFRM_00000000023"/>
	    </td>
	    <td><a href="/egovframework-all-in-one/uss/umt/EgovMberSelectUpdtView.do?selectedId=USRCNFRM_00000000023"  onclick="javascript:fnSelectUser('USR01:USRCNFRM_00000000023'); return false;">crossent</a></td>
	    <td>크로센트</td>
	    <td>crossent@crossent.co.kr</td>
	    <td>02)115-1155</td>
	    <td>2020-03-05</td>
	    <td>
	        
	            
	        
	            회원 가입 승인 상태
	        
	            
	        
	    </td>
	</tr>
	
	<tr>
	    <td>2</td>
	    <td>
	        <input name="checkField" title="checkField 2" type="checkbox"/>
	        <input name="checkId" type="hidden" value="USR01:USRCNFRM_00000000013"/>
	    </td>
	    <td><a href="/egovframework-all-in-one/uss/umt/EgovMberSelectUpdtView.do?selectedId=USRCNFRM_00000000013"  onclick="javascript:fnSelectUser('USR01:USRCNFRM_00000000013'); return false;">egov2</a></td>
	    <td>egov2</td>
	    <td>egov2</td>
	    <td>1111)111-111</td>
	    <td>2020-03-03</td>
	    <td>
	        
	            회원 가입 신청 상태
	        
	            
	        
	            
	        
	    </td>
	</tr>
	
	<tr>
	    <td>3</td>
	    <td>
	        <input name="checkField" title="checkField 3" type="checkbox"/>
	        <input name="checkId" type="hidden" value="USR01:USRCNFRM_00000000004"/>
	    </td>
	    <td><a href="/egovframework-all-in-one/uss/umt/EgovMberSelectUpdtView.do?selectedId=USRCNFRM_00000000004"  onclick="javascript:fnSelectUser('USR01:USRCNFRM_00000000004'); return false;">egov</a></td>
	    <td>aaaa</td>
	    <td>11111111111</td>
	    <td>1111)1111-1111</td>
	    <td>2020-02-26</td>
	    <td>
	        
	            
	        
	            회원 가입 승인 상태
	        
	            
	        
	    </td>
	</tr>
	
	<tr>
	    <td>4</td>
	    <td>
	        <input name="checkField" title="checkField 4" type="checkbox"/>
	        <input name="checkId" type="hidden" value="USR01:USRCNFRM_00000000003"/>
	    </td>
	    <td><a href="/egovframework-all-in-one/uss/umt/EgovMberSelectUpdtView.do?selectedId=USRCNFRM_00000000003"  onclick="javascript:fnSelectUser('USR01:USRCNFRM_00000000003'); return false;">egovtest</a></td>
	    <td>aaaa</td>
	    <td>11111111111</td>
	    <td>1111)1111-1111</td>
	    <td>2020-02-26</td>
	    <td>
	        
	            회원 가입 신청 상태
	        
	            
	        
	            
	        
	    </td>
	</tr>
	
	<tr>
	    <td>5</td>
	    <td>
	        <input name="checkField" title="checkField 5" type="checkbox"/>
	        <input name="checkId" type="hidden" value="USR01:USRCNFRM_00000000001"/>
	    </td>
	    <td><a href="/egovframework-all-in-one/uss/umt/EgovMberSelectUpdtView.do?selectedId=USRCNFRM_00000000001"  onclick="javascript:fnSelectUser('USR01:USRCNFRM_00000000001'); return false;">USER</a></td>
	    <td>일반회원</td>
	    <td>egovframesupport@gmail.com</td>
	    <td>02)1566-2059</td>
	    <td>2020-02-25</td>
	    <td>
	        
	            
	        
	            회원 가입 승인 상태
	        
	            
	        
	    </td>
	</tr>
	
	</tbody>
	</table>
	
	<!-- paging navigation -->
	<div class="pagination">
		<ul><li class="current"><a onClick="return false;">1</a></li>
</ul>
	</div>

<input name="selectedId" type="hidden" />
<input name="checkedIdForDel" type="hidden" />
<input name="pageIndex" type="hidden" value="1"/>
</div>
</form>

</body>
</html>