<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FrameDown</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="/css/egovframework/com/com.css">
</head>

<script type="text/javascript">
	function aa(){
		alert(document.getElementById("lgnUserId").value);
		alert(parent.topFrame.document.all.usr.value);
// 		alert(parent.top.document.all.usr.value);
// 		alert(window.parent.frames[top].document.all.usr.value);
	}
</script>
<body>
<!-- 	<button title="test" onclick="aa()">test</button> -->
	<input type="hidden" id="lgnUserId" name="lgnUserId" value="hidden" />
	<table width=100%>
		<tr height=900px>
			<td style="vertical-align:top;width:20%;border-right:ridge">
	<!-- 		<input type="button" onclick="aa()">dddddd</input> -->
				<iframe id="left" name="left" style="height:900px;width:100%" src="FrameLeft"></iframe>
			</td>
			<td style="vertical-align:top;width:80%">
				<iframe id="body" name="body" style="height:900px;width:100%;" src="Login"></iframe>
			</td>
		</tr>
	</table>
</body>
</html>