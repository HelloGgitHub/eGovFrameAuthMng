<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<!-- <script src="/js/egovframework/com/cmm/jquery-1.4.2.min.js"></script> -->
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/js/cors/jquery.ajax-cross-origin.min.js"></script>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>


<body>
<select id="service" name="service">
  <option value="http://ip.jsontest.com/">IP Address</option>
  <option value="http://headers.jsontest.com/">HTTP Headers</option>
  <option value="http://date.jsontest.com/">Date & Time</option>
  <option value="http://echo.jsontest.com/key/value/one/two">Echo JSON</option>
  <option value='http://validate.jsontest.com/?json={"key":"value"};'>Validate</option>
  <option value="http://code.jsontest.com/">Arbitrary JS Code</option>
  <option value="http://cookie.jsontest.com/">Cookie</option>
  <option value="http://md5.jsontest.com/?text=[text%20to%20MD5]">MD5</option>
</select><br/>
<input type="text" id="url" style="width: 400px">
<input type="button" id="btn" value="Get JSON">
<br/><br/>
<div id="test" />

<script type="text/javascript">
$(function() {
  $("#service").on("change", function(){
    $("#url").val( $( this ).val() );
  });
  
  $("#url").val( $("#service").val() );
  
  $("#btn").click(function(){
    var url = $("#url").val()
    
    $.ajax({
      crossOrigin: true,
      url: url,
      success: function(data) {
        $("#test").html(data);
      }
    });
  });
}); 
</script>

</body>
</html>
</html>