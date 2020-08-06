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
	
	function fn_leftMenu(cd){
		var url="";
		if(cd == 1){
			url="Login";
		} else if(cd == 2){
			if(parent.top.document.getElementById("lngCk") == ""){
			}
			url="AuthList";
		} else if(cd == 3){
			url="AuthInfo?callType=c&authId=";
		} else if(cd == 4){
			url="AuthGrpList";
		} else if(cd == 5){
			url="AuthGrpDetailSetAth?callType=c&authGrpId=";
		} else if(cd == 6){
			url="AuthGrpDetailSetUsr?callType=c&authGrpId=";
		} else if(cd == 7){
			url="AuthGroupInfo?callType=c&authGrpId=";
		} else if(cd == 8){
			url="AuthInfoSetUsr?callType=c&authId=";
		} else if(cd == 9){
			url="MenuInfo";
		} else if(cd == 10){
			url="AuthListSetMenu";
		} else if(cd == 11){
			url="AuthGroupSetMenu";
		} else if(cd == 12){
			url="MakeMenu";
		}
		
		parent.body.location.href=url;
	}


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
// 		window.open(url,'dokdo','width=800,height=600,menubar=no,toolbar=no,location=no,resizable=no,status=no,scrollbars=no,top=300,left=700');
		parent.body.location.href=url;
	}

	function loginMenu(){
// 		alert("left menu alert!!!" + parent.parent.topFrame.document.all.lgnUserId.value);
		
		location.reload();
	}
</script>

<body>
	<input type="hidden" id="" name="lngCk" value="9"/>
	<noscript class="noScriptTitle">메뉴</noscript>
	<form name="menuCreatManageSiteMapForm" action ="/egovframework-all-in-one/sym/mnu/mcm/EgovMenuCreatSiteMapSelect.do" method="post">
	<input name="valueHtml"      type="hidden" />
	<input name="creatPersonId"  type="hidden" value ="USER" />
	<input name="bndeFileNm"     type="hidden" />
	<input name="bndeFilePath"   type="hidden" />
	<input name="mapCreatId"     type="hidden" />
	<input name="tmp_rootPath"   type="hidden" />

	<div class="board" style="width:530px">
		<div class="tree" style="width:480px;" id="treeSiteMap">
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

				for(var i =0; arr.length > i; i++){
	 				if(lgnUserId != ""){  //로그인 상태 일때
		 				if(arr[i].yn == "1"){
							Tree[i] = arr[i].menu_no+'|'+arr[i].upper_menu_no+'|'+arr[i].menu_nm+'|'+arr[i].menu_ordr+'|'+arr[i].progrm_file_nm+'|';
	 					}
	 				}else{ //초기화면
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