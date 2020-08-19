<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<%@ include file="/WEB-INF/jsp/cmm/head.jsp" %>
<script src="/js/egovframework/com/cmm/jquery-1.4.2.min.js"></script>
<link href="/css/egovframework/com/com.css" rel="stylesheet" type="text/css">
<link href="/css/egovframework/com/button.css" rel="stylesheet" type="text/css">
</head>

<script language="javascript" type="text/javaScript" src="/js/egovframework/com/sym/mnu/mcm/EgovMenuCreatSiteMap.js"></script>
<script type="text/javascript">
	var imgpath = "/images/egovframework/com/cmm/utl/";
	var getContextPath = "/";
	var authgrpcode	= "<%=request.getParameter("code") %>";
	
	/* ********************************************************
	* 메뉴 호출 함수
	******************************************************** */
	function fCallUrl(url) {
		parent.body.location.href=url;
	}

	function loginMenu(){
		location.reload();
	}
	
	function fn_leftMenu(cd){
		var url="";
		if(cd == 88){
			url="/swagger-ui.html#/";
		} else if(cd == 99){
			url="/db-console";
		}
		parent.body.location.href=url;
	}
</script>

<body>
<input type="hidden" id="" name="lngCk" value="9"/>
<noscript class="noScriptTitle">메뉴</noscript>
<form name="menuCreatManageSiteMapForm">
	<input name="valueHtml"		type="hidden" />
	<input name="creatPersonId"	type="hidden" value ="" />
	<input name="bndeFileNm"		type="hidden" />
	<input name="bndeFilePath"	type="hidden" />
	<input name="mapCreatId"	type="hidden" />
	<input name="tmp_rootPath"	type="hidden" />

	<div class="board" style="width:100%">
		<div class="tree" style="width:100%;" id="treeSiteMap">
			<script language="javascript" type="text/javaScript">
				var Tree = new Array;
				var baseObj = document.getElementById("treeSiteMap");

				if(parent.parent.topFrame.document.all.authorGrpCode.value != ""){
					authgrpcode = parent.parent.topFrame.document.all.authorGrpCode.value;
				}
				
				var rtnData = new Object();
				rtnData = fn_calApi("GET", "/menu/list/"+authgrpcode, null, false);
				var arr = rtnData.list;
				
				var ihtml = '';
				var lgnUserId = parent.parent.topFrame.document.all.lgnUserId.value;
				var j = 0;
				
				for(var i =0; arr.length > i; i++){
	 				if(lgnUserId != ""){  //로그인 상태 일때
		 				if(arr[i].yn == "1"){
							Tree[j] = arr[i].menu_no+'|'+arr[i].upper_menu_no+'|'+arr[i].menu_nm+'|'+arr[i].menu_ordr+'|'+arr[i].progrm_file_nm+'|';
							j++;
	 					}
	 				}else{ //초기화면
	 					Tree[i] = arr[i].menu_no+'|'+arr[i].upper_menu_no+'|'+arr[i].menu_nm+'|'+arr[i].menu_ordr+'|'+arr[i].progrm_file_nm+'|';
	 	 			}
				}
				createTree(baseObj, Tree);
			</script>
		</div>
	</div>
	<br><br>
	<br><span class="btn_b" style="font-size: 15px;font-style: inherit;font-weight: bold;">- API명세 및 DB콘솔</span>
	<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="btn_b"><a href="" onClick="fn_leftMenu(88);" title="권한관리 API명세" style="font-size: 15px;font-style: inherit;font-weight: bold;">API 명세</a></span>
	<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="btn_b"><a href="" onClick="fn_leftMenu(99);" title="권한관리 DB콘솔" style="font-size: 15px;font-style: inherit;font-weight: bold;">DB 콘솔</a></span>
	
</form>	
</body>
</html>