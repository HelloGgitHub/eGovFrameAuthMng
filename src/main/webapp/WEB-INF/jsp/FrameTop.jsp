<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전자정부 클라우드 플랫폼</title>
<script src="/js/egovframework/com/cmm/jquery-1.4.2.min.js"></script>
<script src="/js/egovframework/com/cmm/jquery.js"></script>
<script src="/js/egovframework/com/cmm/jquery-ui_1.12.1.js"></script>
<script type="text/javascript">
	var lngCk = "5";
	function changePw(){
// 		alert("chang PW");
		window.parent.frames["downFrame"].body.fn_testhd();
		window.parent.frames["downFrame"].body.layUserId.value=$("#lgnUserId").val();
// 		fn_testhd();
	}

</script>
</head>
<body style="text-align:center">
	<table style="min-width: -webkit-fill-available;">
		<tr>
			<td style="width:10%">
				<img src="/images/title.jpg" border='0' align='absbottom' alt='' />
			</td>
			<td style="width:70%">
				<h2>&nbsp;&nbsp;&nbsp; 전자정부 클라우드 플랫폼 </h2>
			</td>
			<td style="display: inline-flex;">
				<input type="text" id="lgnMnt" name="lgnMnt" value="" style="border: none;"/>
				<img id="infoImg" name="infoImg" src="/images/egovframework/com/cmm/utl/menu_question.gif" onclick="changePw()" style="display: none;" />
				<input type="hidden" id="lgnUserId" name="lgnUserId" value="" />
			</td>
<!-- 			<input type="text" id="lngCk" name="lngCk" value="5" /> -->
		</tr>
	</table>
</body>
</html>