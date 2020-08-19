<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon" />
<head>
<meta charset="UTF-8">
<title>Egov Framework</title>
<!-- <frameset rows="80,*" frameborder="1" noresize> -->
<!-- 	<frame src="FrameTop" name="topFrame" scrolling="no"/> -->
<!-- 	<frame src="FrameDown" name="downFrame" /> -->
<!-- </frameset> -->

<script type="text/javascript">
	var loginCk = "";
</script>
</head>

<body style="overflow-y: hidden; margin: 0;">
	<input type="hidden" id="lngCk" name="lngCk" value="" />
	<table width=100%>
		<tr style="height: 10px">
			<td style="vertical-align:top;">
				<iframe id="topFrame" name="topFrame" style="height: 100px;width:100%;border:none;" src="FrameTop"></iframe>
			</td>
		</tr>
		<tr style="height:100vh;width:100%;">
			<td style="vertical-align:top;">
				<iframe id="downFrame" name="downFrame" style="height:100vh;width:100%;border:none;border-top: groove;" src="FrameDown"></iframe>
			</td>
		</tr>
	</table>
</body>
</html>
