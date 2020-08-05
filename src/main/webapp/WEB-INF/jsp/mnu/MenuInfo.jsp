<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>메뉴정보등록</title>
<%@ include file="/WEB-INF/jsp/cmm/head.jsp" %>
<link href="/css/egovframework/com/com.css" rel="stylesheet" type="text/css">
<link href="/css/egovframework/com/button.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	var imgpath = "/images/egovframework/com/cmm/utl/";
</script>
<link type="text/css" rel="stylesheet" href="/css/egovframework/com/cmm/jqueryui.css">

<script language="javascript1.2" type="text/javaScript" src="/js/egovframework/com/sym/mnu/mpm/EgovMenuList.js"></script>

<script type="text/javascript">
    $(document).ready(function () {

//     	makeTree();
//     	fn_SelectMakeMenuList();
        
    	// 파일검색 화면 호출 함수
        $('#popupProgrmFileNm').click(function (e) {
        	e.preventDefault();
            //var page = $(this).attr("href");
            var pagetitle = $(this).attr("title");
            var page = "/egovframework-all-in-one/sym/prm/EgovProgramListSearchNew.do";
            var $dialog = $('<div></div>')
            .html('<iframe style="border: 0px; " src="' + page + '" width="100%" height="100%"></iframe>')
            .dialog({
            	autoOpen: false,
                modal: true,
                width: 550,
                height: 650,
                title: pagetitle
        	});
        	$dialog.dialog('open');
    	});
    	
        // 메뉴이동 화면 호출 함수
        $('#popupUpperMenuId').click(function (e) {
        	e.preventDefault();
            //var page = $(this).attr("href");
            var pagetitle = $(this).attr("title");
            var page = "/egovframework-all-in-one/sym/mnu/mpm/EgovMenuListSelectMvmnNew.do";
            var $dialog = $('<div style="overflow:hidden;padding: 0px 0px 0px 0px;"></div>')
            .html('<iframe style="border: 0px; " src="' + page + '" width="100%" height="100%"></iframe>')
            .dialog({
            	autoOpen: false,
                modal: true,
                width: 600,
                height: 550,
                title: pagetitle
        	});
        	$dialog.dialog('open');
    	});

    	
	});


    function fn_SelectMakeMenuList(){
    	$("#menuData").empty();
    	//API호출
    	var rtnData = new Object();
    	rtnData = fn_calApi("GET", "/menu/makelist", null, false);
    	var arr = rtnData.list;

    	var ihtml = '';
    	for(var i =0; arr.length > i; i++){	
    		ihtml = ihtml + '<input type="hidden" name="tmp_menuNmVal" value="'+arr[i].menu+'">';
    	}
    	
    	var grd = document.getElementById("menuData");
    	grd.innerHTML = ihtml;
    }


	
	function makeTree(){
		
	    var chk_Object = true;
	    var chk_browse = "";
		if (eval(document.menuManageVO.req_RetrunPath)=="[object]") chk_browse = "IE";
		if (eval(document.menuManageVO.req_RetrunPath)=="[object NodeList]") chk_browse = "Fox";
		if (eval(document.menuManageVO.req_RetrunPath)=="[object Collection]") chk_browse = "safai";
		
		if(chk_browse=="IE"&&eval(document.menuManageVO.tmp_menuNmVal)!="[object]"){
			alert("메뉴 목록 데이타가 존재하지 않습니다."); //메뉴 목록 데이타가 존재하지 않습니다.
			chk_Object = false;
		}
		if(chk_browse=="Fox"&&eval(document.menuManageVO.tmp_menuNmVal)!="[object NodeList]"){
			alert("메뉴 목록 데이타가 존재하지 않습니다."); //메뉴 목록 데이타가 존재하지 않습니다.
			chk_Object = false;
		}
		if(chk_browse=="safai"&&eval(document.menuManageVO.tmp_menuNmVal)!="[object Collection]"){
			alert("메뉴 목록 데이타가 존재하지 않습니다."); //메뉴 목록 데이타가 존재하지 않습니다.
			chk_Object = false;
		}
	
		var Tree = new Array;
		if( chk_Object ){
			//API호출
			var rtnData = new Object();
			rtnData = fn_calApi("GET", "/menu/makelist", null, false);
			var arr = rtnData.list;
	
			var ihtml = '';
			for(var i =0; arr.length > i; i++){	
				console.log(arr[i].menu);
				Tree[i] = arr[i].menu;
			}
			var mk = createTree(Tree);
			alert(mk);
// 			var tree = document.getElementById("mkTree");
// 	    	tree.insertAdjacentHTML = mk;
// 	    	tree.insertAdjacentHTML('beforeend', mk);
	    	
			
		}else{
			alert("메뉴가 존재하지 않습니다. 메뉴 등록 후 사용하세요."); //메뉴가 존재하지 않습니다. 메뉴 등록 후 사용하세요.
		}
	}

    
    /* ********************************************************
     * 메뉴등록 처리 함수
     ******************************************************** */
    function insertMenuList() {
    	if(!fn_validatorMenuList()){return;}
        if(confirm("등록하시겠습니까?")){
			if(fn_validatorMenuList()==false) return; //필수값 체크
		
			var paramData = new Object();
			paramData.menuNo				=	$("#menuNo").val();
			paramData.menuNm				=	$("#menuNm").val();
			paramData.menuOrdr				=	$("#menuOrdr").val();
			paramData.upperMenuNo		=	$("#upperMenuId").val();
			paramData.progrmFileNm		=	$("#progrmFileNm").val();
			paramData.relateImageNm		=	$("#relateImageNm").val();
			paramData.relateImagePath	=	$("#relateImagePath").val();
			paramData.menuDc				=	$("#menuDc").val();
	
			var rtnData = new Object();
			rtnData = fn_calApi("POST", "/menu/addnew", paramData, false);
			alert(rtnData.RESULTMSG);
			location.reload();
        }
    }

    /* ********************************************************
     * 메뉴수정 처리 함수
     ******************************************************** */
    function updateMenuList() {
        if(!fn_validatorMenuList()){return;}
        
		if(confirm("저장 하시겠습니까?")){
			if(fn_validatorMenuList()==false) return; //필수값 체크
			
			var paramData = new Object();
			paramData.menuNo				=	$("#menuNo").val();
			paramData.menuNm				=	$("#menuNm").val();
			paramData.menuOrdr				=	$("#menuOrdr").val();
			paramData.upperMenuNo		=	$("#upperMenuId").val();
			paramData.progrmFileNm		=	$("#progrmFileNm").val();
			paramData.relateImageNm		=	$("#relateImageNm").val();
			paramData.relateImagePath	=	$("#relateImagePath").val();
			paramData.menuDc				=	$("#menuDc").val();
		
			var rtnData = new Object();
			rtnData = fn_calApi("PUT", "/menu/modifyInfo", paramData, false);
			alert(rtnData.RESULTMSG);
			location.reload();
		}
    }

    /* ********************************************************
     * 메뉴삭제 처리 함수
     ******************************************************** */
    function deleteMenuList() {
        if(!fn_validatorMenuList()){return;}
        
		var rtnData = new Object();
		var paramData = new Object();
		paramData.menuNo				=	$("#menuNo").val();
		//API호출
		rtnData = fn_calApi("DELETE", "/menu/delete", paramData, false);
		alert(rtnData.RESULTMSG);
		location.reload();
    }

    /* ********************************************************
     * 메뉴리스트 조회 함수
     ******************************************************** */
    function selectMenuList() {
        document.menuManageVO.action = "/egovframework-all-in-one/sym/mnu/mpm/EgovMenuListSelect.do";
        document.menuManageVO.submit();
    }

    /* ********************************************************
     * 초기화 함수
     ******************************************************** */
    function initlMenuList() {
    	document.menuManageVO.menuNo.value="";
    	document.menuManageVO.menuOrdr.value="";
    	document.menuManageVO.menuNm.value="";
    	document.menuManageVO.upperMenuId.value="";
    	document.menuManageVO.menuDc.value="";
    	document.menuManageVO.relateImagePath.value="";
    	document.menuManageVO.relateImageNm.value="";
    	document.menuManageVO.progrmFileNm.value="";
    	document.menuManageVO.menuNo.readOnly=false;
    	document.menuManageVO.tmp_CheckVal.value = "";
    }

    /* ********************************************************
     * 조회 함수
     ******************************************************** */
    function selectMenuListTmp() {
    	document.menuManageVO.req_RetrunPath.value = "/sym/mnu/mpm/EgovMenuList";
        document.menuManageVO.action = "/egovframework-all-in-one/sym/mnu/mpm/EgovMenuListSelectTmp.do";
        document.menuManageVO.submit();
    }

    /* ********************************************************
     * 상세내역조회 함수
     ******************************************************** */
     function choiceNodes(nodeNum) {
    		var nodeValues = treeNodes[nodeNum].split("|");
    		document.menuManageVO.menuNo.value = nodeValues[4];
    		document.menuManageVO.menuOrdr.value = nodeValues[5];
    		document.menuManageVO.menuNm.value = nodeValues[6];
    		document.menuManageVO.upperMenuId.value = nodeValues[7];
    		document.menuManageVO.menuDc.value = nodeValues[8];
    		document.menuManageVO.relateImagePath.value = nodeValues[9];
    		document.menuManageVO.relateImageNm.value = nodeValues[10];
    		document.menuManageVO.progrmFileNm.value = nodeValues[11];
    		document.menuManageVO.menuNo.readOnly=true;
    		document.menuManageVO.tmp_CheckVal.value = "U";
    }

    /* ********************************************************
     * 입력값 validator 함수
     ******************************************************** */
    function fn_validatorMenuList() {

    	if($("#menuNo").val() == ""){alert("메뉴번호는 필수 항목입니다."); return false;} //메뉴번호는 Not Null 항목입니다.
    	if(!checkNumber($("#menuNo").val())){alert("메뉴번호는 숫자만 입력 가능합니다."); return false;} //메뉴번호는 숫자만 입력 가능합니다.

    	if($("#menuOrdr").val() == ""){alert("메뉴순서는 필수 항목입니다."); return false;} //메뉴순서는 Not Null 항목입니다.
    	if(!checkNumber($("#menuOrdr").val())){alert("메뉴순서는 숫자만 입력 가능합니다."); return false;} //메뉴순서는 숫자만 입력 가능합니다.

    	if($("#upperMenuId").val() == ""){alert("상위메뉴번호는 필수 항목입니다."); return false;} //상위메뉴번호는 Not Null 항목입니다.
    	if(!checkNumber($("#upperMenuId").val())){alert("상위메뉴번호는 숫자만 입력 가능합니다."); return false;} //상위메뉴번호는 숫자만 입력 가능합니다.

    	if($("#progrmFileNm").val() == ""){alert("프로그램파일명은 필수 항목입니다."); return false;} //프로그램파일명은 Not Null 항목입니다.
    	if($("#menuNm").val() == ""){alert("메뉴명은 필수 항목입니다."); return false;} //메뉴명은 Not Null 항목입니다.

        return true;
    }

    /* ********************************************************
     * 필드값 Number 체크 함수
     ******************************************************** */
    function checkNumber(str) {
        var flag=true;
        if (str.length > 0) {
            for (i = 0; i < str.length; i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    flag=false;
                }
            }
        }
        return flag;
    }

</script>

</head>
<body>
<noscript class="noScriptTitle">자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>
<div id="border" style="width:730px">
<table border="0">
  <tr>
    <td width="700">
<!-- ********** 여기서 부터 본문 내용 *************** -->


<form name="menuManageVO" action ="/egovframework-all-in-one/sym/mnu/mpm/EgovMenuListInsert.do" method="post">
<input type="hidden" name="req_RetrunPath" value="/sym/mnu/mpm/EgovMenuList">

<div class="board">
	<h1 style="background-position:left 3px">메뉴 목록</h1><!-- 메뉴 목록 -->

	<div class="search_box" title="이 레이아웃은 하단 정보를 대한 검색 정보로 구성되어 있습니다."><!-- 이 레이아웃은 하단 정보를 대한 검색 정보로 구성되어 있습니다. -->
		<ul>
			<li>
				<input class="s_btn" type="button" value='초기화' 	title='초기화' onclick="initlMenuList();"  />
				<input class="s_btn" type="button" value='저장' 	title='저장' 	onclick="insertMenuList();" />
				<input class="s_btn" type="button" value='수정' 	title='수정' 	onclick="updateMenuList();" />
				<input class="s_btn" type="button" value='삭제' 	title='삭제' 	onclick="deleteMenuList();" />
<!-- 				<span class="btn_b"><a href="#LINK" onclick="updateMenuList(); return false;" title='수정'>수정</a></span> -->
<!-- 				<span class="btn_b"><a href="#LINK" onclick="deleteMenuList(); return false;" title='삭제'>삭제</a></span> -->
			</li>
		</ul>
	</div>
</div>



<div id="main" style="display:">




<table>
	<colgroup>
		<col style="width:240px" />
		<col style="" />
	</colgroup>
  <tr>
   <td style="vertical-align:top">
<!-- 	<div id="menuData" name="menuData"/> -->
	
	<div id="mkTree" name="mkTree" class="tree" style="overflow:auto; width:218px; height:383px; padding:5px; border:1px solid #ddd">
	<script type="text/javascript">
		var chk_Object = true;
	    var chk_browse = "";
		if (eval(document.menuManageVO.req_RetrunPath)=="[object]") chk_browse = "IE";
		if (eval(document.menuManageVO.req_RetrunPath)=="[object NodeList]") chk_browse = "Fox";
		if (eval(document.menuManageVO.req_RetrunPath)=="[object Collection]") chk_browse = "safai";
		
		if(chk_browse=="IE"&&eval(document.menuManageVO.tmp_menuNmVal)!="[object]"){
			alert("메뉴 목록 데이타가 존재하지 않습니다."); //메뉴 목록 데이타가 존재하지 않습니다.
			chk_Object = false;
		}
		if(chk_browse=="Fox"&&eval(document.menuManageVO.tmp_menuNmVal)!="[object NodeList]"){
			alert("메뉴 목록 데이타가 존재하지 않습니다."); //메뉴 목록 데이타가 존재하지 않습니다.
			chk_Object = false;
		}
		if(chk_browse=="safai"&&eval(document.menuManageVO.tmp_menuNmVal)!="[object Collection]"){
			alert("메뉴 목록 데이타가 존재하지 않습니다."); //메뉴 목록 데이타가 존재하지 않습니다.
			chk_Object = false;
		}
	
		var Tree = new Array;
		if( chk_Object ){
			//API호출
			var rtnData = new Object();
			rtnData = fn_calApi("GET", "/menu/makelist", null, false);
			var arr = rtnData.list;
	
			var ihtml = '';
			for(var i =0; arr.length > i; i++){	
				console.log(arr[i].menu);
				Tree[i] = arr[i].menu;
			}
			var mk = createTree(Tree);
// 			alert(mk);
// 			var tree = document.getElementById("mkTree");
// 	    	tree.insertAdjacentHTML = mk;
// 	    	tree.insertAdjacentHTML('beforeend', mk);

		}else{
			alert("메뉴가 존재하지 않습니다. 메뉴 등록 후 사용하세요."); //메뉴가 존재하지 않습니다. 메뉴 등록 후 사용하세요.
		}
		</script>
	</div>
   </td>
   
   <td style="vertical-align:top">

		<table class="wTable" >
			<colgroup>
				<col style="width:30%" />
				<col style="" />
			</colgroup>
		  <tr>
		    <th>메뉴No <span class="pilsu">*</span></th><!-- 메뉴No -->
		    <td class="left">
		      <input name="menuNo" id="menuNo" type="text" value=""  maxlength="10" title="메뉴No" style="width:68px"/>
		    </td>
		  </tr>
		  <tr>
		    <th>메뉴순서 <span class="pilsu">*</span></th><!-- 메뉴순서 -->
		    <td class="left">
		      <input name="menuOrdr" id="menuOrdr" type="text" value=""  maxlength="10" title="메뉴순서" style="width:68px"/>
		    </td>
		  </tr>
		  <tr>
		    <th>메뉴명 <span class="pilsu">*</span></th><!-- 메뉴명 -->
		    <td class="left">
		      <input name="menuNm" id="menuNm" type="text" size="30" value=""  maxlength="30" title="메뉴명">
		    </td>
		  </tr>
		  <tr>
		    <th>상위메뉴No <span class="pilsu">*</span></th><!-- 상위메뉴No -->
		    <td class="left">
		    <input name="upperMenuId" id="upperMenuId" type="text" value=""  maxlength="10" title="상위메뉴No" style="width:190px"/>
<!--  	        <a id="popupUpperMenuId" href="/sym/mnu/mpm/EgovMenuListSelectMvmn.do" target="_blank" title="상위메뉴No" style="selector-dummy:expression(this.hideFocus=false);"> -->
<!-- 				<img src="/images/egovframework/com/cmm/icon/search2.gif" alt='' width="15" height="15" />(메뉴선택 검색) -->
<!-- 			</a>메뉴선택 검색 -->
		    </td>
		  </tr>
		  <tr>
		    <th>파일명 <span class="pilsu">*</span></th><!-- 파일명 -->
		    <td class="left">
	        <input name="progrmFileNm" id="progrmFileNm" type="text" size="30" value=""  maxlength="60" title="파일명" style="width:190px"/>
<!-- 	        <a id="popupProgrmFileNm" href="/sym/prm/EgovProgramListSearch.do" target="_blank" title="파일명" style="selector-dummy:expression(this.hideFocus=false);"> -->
<!-- 	        	<img src="/images/egovframework/com/cmm/icon/search2.gif" alt='' width="15" height="15" />(프로그램파일명 검색) -->
<!-- 	        </a> -->
		    </td>
		  </tr>
		  <tr>
		    <th>관련이미지명 <span class="pilsu">*</span></th><!-- 관련이미지명 -->
		    <td width="70%" nowrap>
		      <input name="relateImageNm" id="relateImageNm" type="text" size="30" value=""  maxlength="30" title="관련이미지명">
		    </td>
		  </tr>
		  <tr>
		    <th>관련이미지경로 <span class="pilsu">*</span></th><!-- 관련이미지경로 -->
		    <td>
		      <input name="relateImagePath" id="relateImagePath" type="text" size="30" value=""  maxlength="60" title="관련이미지경로">
		    </td>
		  </tr>
		  <tr>
		    <th>메뉴설명</th><!-- 메뉴설명 -->
		    <td width="70%">
		      &nbsp; <textarea name="menuDc" id="menuDc" class="textarea"  cols="45" rows="8"  style="width:350px;" title="메뉴설명"></textarea>
		    </td>
		  </tr>
		</table>

   </td>
 </tr>
</table>

    <input type="hidden" name="tmp_SearchElementName" value="">
    <input type="hidden" name="tmp_SearchElementVal" value="">
    <input type="hidden" name="tmp_CheckVal" value="">
</div>

</form>

<!-- ********** 여기까지 내용 *************** -->
</td>
</tr>
</table>
</DIV>
</body>
</html>

