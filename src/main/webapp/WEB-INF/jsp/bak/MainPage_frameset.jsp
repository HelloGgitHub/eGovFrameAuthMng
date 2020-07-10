<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="EUC-KR">
<title>Egov Framework</title>
	<frameset rows="80,*" frameborder="1" noresize>
		<frame src="http://localhost:9085/FrameTop" name="top" scrolling="no"/>
		<frameset cols="200,*" frameborder="1" noresize>
			<frame src="http://localhost:9085/FrameLeft" name="left" />
			<frame src="http://localhost:9085/Login" name="body" />
		</frameset>
</frameset>
<script type="text/javascript">
	var loginCk = "8";
</script>
</head>
<body>
	<input type="hidden" id="lngCk" name="lngCk" value="8" />
</body>
</html>




