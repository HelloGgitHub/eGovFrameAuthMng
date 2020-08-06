<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>메뉴생성</title><!-- 메뉴생성 -->
<%@ include file="/WEB-INF/jsp/cmm/head.jsp" %>
<link href="/css/egovframework/com/com.css" rel="stylesheet" type="text/css">
<link href="/css/egovframework/com/button.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	var imgpath = "/images/egovframework/com/cmm/utl/";
</script>
<script language="javascript" type="text/javaScript" src="/js/egovframework/com/sym/mnu/mcm/EgovMenuCreat.js"></script>
<script language="javascript" type="text/javaScript">

var authgrpcode	= "<%=request.getParameter("code") %>";
var authgrpname	= "<%=request.getParameter("name") %>";


$(document).ready(function(){
	$("#authorCode").val(authgrpcode);
	$("#authorNm").val(authgrpname);	
});


/* ********************************************************
 * 조회 함수
 ******************************************************** */
function selectMenuCreatTmp() {
    document.menuCreatManageForm.action = "/egovframework-all-in-one/sym/mnu/mcm/EgovMenuCreatSelect.do";
    document.menuCreatManageForm.submit();
}

/* ********************************************************
 * 멀티입력 처리 함수
 ******************************************************** */
function fInsertMenuCreat() {
    var checkField = document.menuCreatManageForm.checkField;
    var checkMenuNos = "";
    var checkedCount = 0;
    if(checkField) {
    	if(checkField.length > 1) {
            for(var i=0; i < checkField.length; i++) {
                if(checkField[i].checked) {
                    checkMenuNos += ((checkedCount==0? "" : ",") + checkField[i].value);
                    checkedCount++;
                    console.log("checkMenuNos = "+checkMenuNos);
                    console.log("checkedCount = "+checkedCount);
                }
            }
        } else {
            if(checkField.checked) {
                checkMenuNos = checkField.value;
            }
        }
    }
    if(checkedCount == 0){
        alert("선택된 메뉴가 없습니다.");
        return false;
    }


    if(confirm("등록하시겠습니까?")){
		var paramData = new Object();
		paramData.authGrpCd		=	$("#authorCode").val();
		paramData.menuMakeNo	=	checkMenuNos;
		paramData.menuMakeCnt	=	checkedCount;

		var rtnData = new Object();
		rtnData = fn_calApi("POST", "/menu/authSetMenu", paramData, false);
		alert(rtnData.RESULTMSG);
    }

}
/* ********************************************************
 * 메뉴사이트맵 생성 화면 호출
 ******************************************************** */
function fMenuCreatSiteMap() {
	var cd = $("#authorCode").val();
	window.open("/MakeMenuPop?code="+cd, 'Pop_SiteMap', 'scrollbars=yes, width=550, height=700');
}

</script>

<style type="text/css">
.tree {margin-bottom:30px; padding:10px; border-top:2px solid #1a90d8; border-bottom:2px solid #1a90d8; background:#f7f7f7; }
.tree input[type=checkbox] {margin-right:2px; vertical-align:-2px; }
.tree img {vertical-align:-4px; }
</style>

</head>
<body>
<noscript class="noScriptTitle">자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>
<form name="menuCreatManageForm" />
<input name="checkedMenuNoForInsert" type="hidden" >
<input name="checkedAuthorForInsert"  type="hidden" >

<div class="board">
	<h1>메뉴생성</h1><!-- 메뉴생성 -->

	<div class="search_box" title="이 레이아웃은 하단 정보를 대한 검색 정보로 구성되어 있습니다.">
		<ul>
			<li>
				<label for="">권한코드 : </label><!-- 권한코드 -->
				<input class="s_input2 vat" name="authorCode" id="authorCode" type="hidden" value="" maxlength="30" title="권한코드" readonly="readonly" style="width:250px" /><!-- 권한코드 -->
				<input class="s_input2 vat" name="authorNm" id="authorNm" type="text" value="" maxlength="30" title="권한명" readonly="readonly" style="width:250px" /><!-- 권한코드 -->
				<span class="btn_b"><a href="#LINK" onclick="fInsertMenuCreat(); return false;" title="메뉴생성">메뉴생성</a></span><!-- 메뉴생성 -->
				<input class="s_btn" type="button" value="사이트맵생성" title="사이트맵생성" onclick="fMenuCreatSiteMap(); return false;" />
			</li>
		</ul>
	</div>
	
	<div class="tree">
		<script language="javascript" type="text/javaScript">
		    var chk_Object = true;
		    var chk_browse = "";
			if (eval(document.menuCreatManageForm.authorCode)=="[object]") chk_browse = "IE";
			if (eval(document.menuCreatManageForm.authorCode)=="[object NodeList]") chk_browse = "Fox";
			if (eval(document.menuCreatManageForm.authorCode)=="[object Collection]") chk_browse = "safai";

			var Tree = new Array;
			if(chk_browse=="IE"&&eval(document.menuCreatManageForm.tmp_menuNmVal)!="[object]"){
			   alert("메뉴 목록 데이타가 존재하지 않습니다."); //메뉴 목록 데이타가 존재하지 않습니다.
			   chk_Object = false;
			}
			if(chk_browse=="Fox"&&eval(document.menuCreatManageForm.tmp_menuNmVal)!="[object NodeList]"){
			   alert("메뉴 목록 데이타가 존재하지 않습니다."); //메뉴 목록 데이타가 존재하지 않습니다.
			   chk_Object = false;
			}
			if(chk_browse=="safai"&&eval(document.menuCreatManageForm.tmp_menuNmVal)!="[object Collection]"){
			   alert("메뉴 목록 데이타가 존재하지 않습니다."); //메뉴 목록 데이타가 존재하지 않습니다.
			   chk_Object = false;
			}
			
			if( chk_Object ){
				var rtnData = new Object();
				rtnData = fn_calApi("GET", "/menu/list/"+authgrpcode, null, false);
				var arr = rtnData.list;

				var ihtml = '';
				for(var i =0; arr.length > i; i++){
					Tree[i] = arr[i].menu_no+'|'+arr[i].upper_menu_no+'|'+arr[i].menu_nm+'|'+arr[i].progrm_file_nm+'|'+arr[i].yn+'|';
				}
			    createTree(Tree);
            }else{
                alert("메뉴가 존재하지 않습니다."); //메뉴가 존재하지 않습니다. 메뉴 등록 후 사용하세요.
            }
            
		</script>
	</div>
	
</div>

<!-- 개발로직 최종 테스트 후 아래 소스를 삭제해주세요 -->
<div id="border" style="width:730px">
<table border="0">
	<tr>
	    <td width="700">
			<!-- ********** 여기서 부터 본문 내용 *************** -->
			<div id="main" style="display:width:700px;"></div>
			<!-- ********** 여기까지 내용 *************** -->
		</td>
	</tr>
</table>
</div>

<input type="hidden" name="req_menuNo">
</form>

</body>
</html>

