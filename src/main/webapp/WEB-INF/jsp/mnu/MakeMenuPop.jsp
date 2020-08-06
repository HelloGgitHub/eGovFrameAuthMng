<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>메뉴사이트맵생성</title><!-- 메뉴사이트맵생성 -->
<%@ include file="/WEB-INF/jsp/cmm/head.jsp" %>
<link href="/css/egovframework/com/com.css" rel="stylesheet" type="text/css">
<link href="/css/egovframework/com/button.css" rel="stylesheet" type="text/css">

<script language="javascript" type="text/javaScript" src="/js/egovframework/com/sym/mnu/mcm/EgovMenuCreatSiteMap.js"></script>
<script language="javascript" type="text/javaScript">
var authgrpcode	= "<%=request.getParameter("code") %>";
var imgpath = "/images/egovframework/com/cmm/utl/";
var getContextPath = "/";

/* ********************************************************
 * 조회 함수
 ******************************************************** */
function selectMenuCreatSiteMap() {
	document.menuCreatManageSiteMapForm.scrtyEstbstrgetId.value = opener.document.menuCreatManageForm.scrtyEstbstrgetId.value;
	document.menuCreatManageSiteMapForm.action = "/egovframework-all-in-one/sym/mnu/mcm/EgovMenuCreatSiteMapSelect.do";
    document.menuCreatManageSiteMapForm.submit();
}

/* ********************************************************
 * jsp 생성 함수
 ******************************************************** */
function CreatSiteMap() {
	fHtmlCreat_Head();
	console.log("vHtmlCode = "+vHtmlCode);
	usrID = document.menuCreatManageSiteMapForm.creatPersonId.value;
	authorCode = document.menuCreatManageSiteMapForm.authorCode.value;
	document.menuCreatManageSiteMapForm.valueHtml.value    = vHtmlCode;
	document.menuCreatManageSiteMapForm.bndeFileNm.value   = authorCode+"_SiteMap.jsp";
	//document.menuCreatManageSiteMapForm.tmp_rootPath.value = vRootPath;
	//document.menuCreatManageSiteMapForm.bndeFilePath.value = vSiteMapPath;
	document.menuCreatManageSiteMapForm.mapCreatId.value   = authorCode;
	document.menuCreatManageSiteMapForm.action = "/egovframework-all-in-one/sym/mnu/mcm/EgovMenuCreatSiteMapInsert.do";
    document.menuCreatManageSiteMapForm.submit();
}

/* ********************************************************
* 메뉴 호출 함수
******************************************************** */
function fCallUrl(url) {
	window.open(url,'dokdo','width=800,height=600,menubar=no,toolbar=no,location=no,resizable=no,status=no,scrollbars=no,top=300,left=700');
}



</script>

</head>
<body>
<noscript class="noScriptTitle">메뉴사이트맵생성</noscript>
<form name="menuCreatManageSiteMapForm" action ="/egovframework-all-in-one/sym/mnu/mcm/EgovMenuCreatSiteMapSelect.do" method="post">
<div style="visibility:hidden;display:none;"><input name="iptSubmit" type="submit" value="전송" title="전송"></div><!-- 전송 -->
<input name="valueHtml"      type="hidden" />
<input name="creatPersonId"  type="hidden" value ="USER" />
<input name="bndeFileNm"     type="hidden" />
<input name="bndeFilePath"   type="hidden" />
<input name="mapCreatId"     type="hidden" />
<input name="tmp_rootPath"   type="hidden" />

<div class="board" style="width:530px">
	<h1>메뉴사이트맵생성</h1><!-- 메뉴사이트맵생성 -->

	<div class="search_box" title="이 레이아웃은 하단 정보를 대한 검색 정보로 구성되어 있습니다.">
		<ul>
			<li>
				<label for="">권한코드 : </label><!-- 권한코드 -->
				<input class="s_input2 vat" name="authorCode" type="text" value="IS_AUTHENTICATED_ANONYMOUSLY" size="40" maxlength="30" title="권한명" readonly="readonly" /><!-- 권한명 -->
			</li>
		</ul>
	</div>
	
	<div class="tree" style="width:480px;" id="treeSiteMap">
		<script language="javascript" type="text/javaScript">
			var Tree = new Array;
			var baseObj = document.getElementById("treeSiteMap");

			var rtnData = new Object();
			rtnData = fn_calApi("GET", "/menu/list/"+authgrpcode, null, false);
			var arr = rtnData.list;
			
			var ihtml = '';
			for(var i =0; arr.length > i; i++){
				if(arr[i].yn == "1"){
					Tree[i] = arr[i].menu_no+'|'+arr[i].upper_menu_no+'|'+arr[i].menu_nm+'|'+arr[i].menu_ordr+'|'+arr[i].progrm_file_nm+'|';
				}
			}
			createTree(baseObj, Tree);
            
		</script>
	</div>
</div>

</form>

</body>
</html>


