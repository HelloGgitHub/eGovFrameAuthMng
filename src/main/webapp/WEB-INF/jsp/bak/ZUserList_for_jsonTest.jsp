<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자 목록 조회</title>

<script src="/js/egovframework/com/cmm/jquery-1.4.2.min.js"></script>
<script type="text/javascript" language="javascript">

var responseData = "";

$(document).ready(function(){
	
});

function callMemberList () {
	
    $.ajax({
        type : "GET", 												//전송방식을 지정한다 (POST,GET)
        url : "http://localhost:9085/user/list",				//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
        contentType: 'application/json; charset=utf-8',
        dataType : "json",										//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
        error : function(){    									//error: whenError
            alert("통신실패!!!!");
        },
        success : function(Parse_data){    			//success: whenSuccess,   function whenSuccess(resdata)
            $("#ReturnData").append(Parse_data); 		//div에 받아온 값을 넣는다.
            console.log(Parse_data);
        }
    });
}

function callMemberDetailInfo () {
    $.ajax({
        type : "POST", 												//전송방식을 지정한다 (POST,GET)
        url : "http://localhost:9085/user/detailInfo",			//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
        contentType: 'application/json; charset=utf-8',
        dataType : "json",											//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
        data : {"memberId":$("#memberId").val() },
        error : function(){    										//error: whenError
            alert("통신실패!!!!");
        },
        success : function(Parse_data){    					//success: whenSuccess,   function whenSuccess(resdata)
            $("#MemberDetailInfoData").html(Parse_data); 	//div에 받아온 값을 넣는다.
            console.log(Parse_data);
        }
    });
}
</script>
 
</head>

<body>
	<table>MEMBERLIST PAGE(MemberList.jsp)</table>
	<br>
	<table>
		<tr>
			<button id = "MemberList" 	name="MemberList" onclick="callMemberList()">MemberList</button>
		</tr>
		<tr>
	    	<div id="ReturnData" />
	    </tr>
	    <br><br>
	    <tr>
	    	<button id = "MemberDetailInfo" name = "MemberDetailInfo" onclick="callMemberDetailInfo()">MemberDetailInfo</button>
	    	&nbsp;사용자ID&nbsp;:&nbsp;<input type="text" id="memberId" name="memberId" onKeypress="javascript:if(event.keyCode==13) {callMemberDetailInfo()}" style="width:100px" />
		</tr>
		<tr>
			<div id="MemberDetailInfoData" />
		</tr>
	</table>
</body>
</html>