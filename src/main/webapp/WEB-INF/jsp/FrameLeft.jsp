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
			url="AuthGrpDetailSetAth?callType=c&authGrpId=";
		} else if(cd == 6){
			url="AuthGrpDetailSetUsr?callType=c&authGrpId=";
		} else if(cd == 7){
			url="AuthGroupInfo?callType=c&authGrpId=";
		}
		
		parent.body.location.href=url;
	}

</script>

<body>
	<input type="hidden" id="" name="lngCk" value="9"/>
	
	<br/><span class="btn_b"><a href="" onClick="fn_leftMenu(1);" title="로그인" style="font-size: 15px;font-style: inherit;font-weight: bold;">- 로그인</a></span>
	<br/>
	<br/><span class="btn_b" style="font-size: 15px;font-style: inherit;font-weight: bold;">- 권한 관리</span>
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="btn_b"><a href="" onClick="fn_leftMenu(2);" title="권한목록 조회" style="font-size: 15px;font-style: inherit;font-weight: bold;">권한목록 조회</a></span>
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="btn_b"><a href="" onClick="fn_leftMenu(3);" title="권한등록" style="font-size: 15px;font-style: inherit;font-weight: bold;">권한등록</a></span>

	<br/>
	<br/><span class="btn_b" style="font-size: 15px;font-style: inherit;font-weight: bold;">- 권한그룹 관리</span>
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="btn_b"><a href="" onClick="fn_leftMenu(7);" title="권한그룹 등록" style="font-size: 15px;font-style: inherit;font-weight: bold;">권한그룹 등록</a></span>
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="btn_b"><a href="" onClick="fn_leftMenu(4);" title="목록 조회" style="font-size: 15px;font-style: inherit;font-weight: bold;">권한그룹 목록 조회</a></span>
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="btn_b"><a href="" onClick="fn_leftMenu(5);" title="권한그룹 권한 등록" style="font-size: 15px;font-style: inherit;font-weight: bold;">권한그룹 권한 등록</a></span>
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="btn_b"><a href="" onClick="fn_leftMenu(6);" title="권한그룹 사용자 등록" style="font-size: 15px;font-style: inherit;font-weight: bold;">권한그룹 사용자 등록</a></span>
	
</body>
</html>