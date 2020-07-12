<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="/css/egovframework/com/com.css">
	<script src="/js/egovframework/com/cmm/jquery-1.4.2.min.js"></script>
</head>

<script type="text/javascript">
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
			url="AuthGrpDetailSet?callType=c&authGrpId=";



			
		} else if(cd == 6){
			url="GroupUserSet?callType=c&userId=";
		} else if(cd == 7){
			url="UserGroupSet?callType=c&groupId=";
		}
		
		parent.body.location.href=url;
	}

</script>

<body>
	<input type="hidden" id="" name="lngCk" value="9"/>
	
	<br/><span class="btn_b"><a href="" onClick="fn_leftMenu(1);" title="로그인" style="font-size: 15px;font-style: inherit;font-weight: bold;">- 로그인</a></span>
	<br/>
	<br/><span class="btn_b" style="font-size: 15px;font-style: inherit;font-weight: bold;">- 권한 관리</span>
	<br/>&nbsp;&nbsp;&nbsp;<span class="btn_b"><a href="" onClick="fn_leftMenu(2);" title="권한목록 조회" style="font-size: 15px;font-style: inherit;font-weight: bold;">권한목록 조회</a></span>
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="btn_b"><a href="" onClick="fn_leftMenu(3);" title="권한정보 조회" style="font-size: 15px;font-style: inherit;font-weight: bold;">권한정보 조회</a></span>





	<br/>
	<br/><span class="btn_b" style="font-size: 15px;font-style: inherit;font-weight: bold;">- 권한그룹 관리</span>
	<br/>&nbsp;&nbsp;&nbsp;<span class="btn_b"><a href="" onClick="fn_leftMenu(4);" title="목록 조회" style="font-size: 15px;font-style: inherit;font-weight: bold;">권한그룹목록 조회</a></span>
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="btn_b"><a href="" onClick="fn_leftMenu(5);" title="권한그룹 목록관리" style="font-size: 15px;font-style: inherit;font-weight: bold;">권한그룹 목록관리</a></span>
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="btn_b"><a href="" onClick="fn_leftMenu(7);" title="사용자 목록관리" style="font-size: 15px;font-style: inherit;font-weight: bold;">사용자 목록관리</a></span>
	
	
	
	
	<!-- 	<input type="text" id="usr" name="usr" value="left" style="text-align-last: end;media-volume-sliderthumb"/> -->
</body>
</html>