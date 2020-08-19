<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<%@ include file="/WEB-INF/jsp/cmm/head.jsp" %>

<link type="text/css" rel="stylesheet" href="/css/egovframework/com/com.css">
<link type="text/css" rel="stylesheet" href="/css/egovframework/com/uat/uia/login.css">


<script type="text/javaScript" language="javascript" defer="defer">
	/*********************************************************
	 * 초기화
	 ******************************************************** */
	$(document).ready(function(){
		parent.parent.topFrame.document.all.infoImg.style.display = "none";
		parent.parent.topFrame.document.all.lgnUserId.value= "";
		parent.parent.topFrame.document.all.lgnMnt.value= "";
		parent.parent.topFrame.document.all.authorGrpCode.value= "";
	});
		
	/*********************************************************
	 * 로그인
	 *********************************************************/
	function fn_login(){
		var rtnData = new Object();
		var userData = new Object();
		
		userData.usrId				=	$("#userId").val();
		userData.password		=	$("#password").val();

		//API호출
		rtnData = fn_calApi("POST", "/auth/idpw", userData, false);
		
		if(rtnData.RESULTCD == 0){
// 				parent.parent.topFrame.document.all.infoImg.style.display = "block";
			parent.parent.topFrame.document.all.lgnUserId.value= rtnData.list.userId;
			parent.parent.topFrame.document.all.lgnMnt.value= rtnData.list.userNm+" 님 환영합니다.";
			parent.parent.topFrame.document.all.authorGrpCode.value= rtnData.list.authorGrpCode;
			
			alert(rtnData.list.userNm+" 님 환영합니다.");
			window.parent.frames["left"].loginMenu();
			fn_movelogin();
		}else{
			alert(rtnData.RESULTMSG);
			return;
		}
	}

	function fn_movelogin(){
		location.href="/AuthList";
	}

</script>
</head>
<body style="inline-size: max-content;">

<!-- javascript warning tag  -->
<noscript class="noScriptTitle">자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>

<!-- 일반로그인 -->
<div class="login_form">
<!-- 	<form name="loginForm" id="loginForm" action="/egovframework-all-in-one/uat/uia/actionLogin.do" method="post"> -->
	<input type="hidden" id="message" name="message" value="">
	
	<fieldset>
		<div class="login_input">
			<ul>
				<!-- 아이디 -->
				<li>
					<label for="id">아이디</label>
					<input type="text" name="userId" id="userId" maxlength="10" title="아이디 " placeholder="아이디 ">
				</li>
				
				<!-- 비밀번호 -->
				<li>
					<label for="password">비밀번호</label>
					<input type="password" name="password" id="password" maxlength="12" title="비밀번호 " placeholder="비밀번호 ">
				</li>

				<li>
					<input type="button" class="btn_login" value="로그인" onclick="fn_login()"> <!-- 로그인  -->
				</li>
			</ul>
		</div>
	</fieldset>
</div>

</body>
</html>