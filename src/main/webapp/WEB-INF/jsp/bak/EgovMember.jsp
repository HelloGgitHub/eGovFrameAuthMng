<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>일반회원관리 등록</title>
<!-- <script src="/js/egovframework/com/cmm/jquery-1.4.2.min.js"></script> -->
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="/css/egovframework/com/com.css">

<script type="text/javascript"> 
     var bCancel = false; 

    function validateMberManageVO(form) {
        if (bCancel)
      return true; 
        else 
       return validateRequired(form) && validateMaxLength(form) && validatePassword1(form) && validatePassword2(form) && validatePassword3(form) && validatePassword4(form) && validateInteger(form) && validateEmail(form); 
   }

    function required () { 
     this.aa = new Array("mberId", "일반회원아이디은(는) 필수 입력값입니다.", new Function ("varName", "this.maxlength='20';  return this[varName];"));
     this.ab = new Array("mberNm", "일반회원이름은(는) 필수 입력값입니다.", new Function ("varName", "this.maxlength='50';  return this[varName];"));
     this.ac = new Array("password", "비밀번호은(는) 필수 입력값입니다.", new Function ("varName", " return this[varName];"));
     this.ad = new Array("passwordHint", "비밀번호힌트은(는) 필수 입력값입니다.", new Function ("varName", " return this[varName];"));
     this.ae = new Array("passwordCnsr", "비밀번호정답은(는) 필수 입력값입니다.", new Function ("varName", "this.maxlength='100';  return this[varName];"));
     this.af = new Array("areaNo", "집지역번호은(는) 필수 입력값입니다.", new Function ("varName", "this.maxlength='4';  return this[varName];"));
     this.ag = new Array("middleTelno", "집중간전화번호은(는) 필수 입력값입니다.", new Function ("varName", "this.maxlength='4';  return this[varName];"));
     this.ah = new Array("endTelno", "집마지막전화번호은(는) 필수 입력값입니다.", new Function ("varName", "this.maxlength='4';  return this[varName];"));
     this.ai = new Array("moblphonNo", "핸드폰번호은(는) 필수 입력값입니다.", new Function ("varName", "this.maxlength='15';  return this[varName];"));
     this.aj = new Array("mberEmailAdres", "이메일주소은(는) 필수 입력값입니다.", new Function ("varName", "this.maxlength='50';  return this[varName];"));
     this.ak = new Array("zip", "우편번호은(는) 필수 입력값입니다.", new Function ("varName", "this.maxlength='6';  return this[varName];"));
     this.al = new Array("adres", "주소은(는) 필수 입력값입니다.", new Function ("varName", "this.maxlength='100';  return this[varName];"));
     this.am = new Array("mberSttus", "일반회원상태코드은(는) 필수 입력값입니다.", new Function ("varName", " return this[varName];"));
    } 

    function maxlength () { 
     this.aa = new Array("mberId", "일반회원아이디은(는) 20자 이상 입력할수 없습니다.", new Function ("varName", "this.maxlength='20';  return this[varName];"));
     this.ab = new Array("mberNm", "일반회원이름은(는) 50자 이상 입력할수 없습니다.", new Function ("varName", "this.maxlength='50';  return this[varName];"));
     this.ac = new Array("passwordCnsr", "비밀번호정답은(는) 100자 이상 입력할수 없습니다.", new Function ("varName", "this.maxlength='100';  return this[varName];"));
     this.ad = new Array("areaNo", "집지역번호은(는) 4자 이상 입력할수 없습니다.", new Function ("varName", "this.maxlength='4';  return this[varName];"));
     this.ae = new Array("middleTelno", "집중간전화번호은(는) 4자 이상 입력할수 없습니다.", new Function ("varName", "this.maxlength='4';  return this[varName];"));
     this.af = new Array("endTelno", "집마지막전화번호은(는) 4자 이상 입력할수 없습니다.", new Function ("varName", "this.maxlength='4';  return this[varName];"));
     this.ag = new Array("mberFxnum", "팩스번호은(는) 15자 이상 입력할수 없습니다.", new Function ("varName", "this.maxlength='15';  return this[varName];"));
     this.ah = new Array("moblphonNo", "핸드폰번호은(는) 15자 이상 입력할수 없습니다.", new Function ("varName", "this.maxlength='15';  return this[varName];"));
     this.ai = new Array("mberEmailAdres", "이메일주소은(는) 50자 이상 입력할수 없습니다.", new Function ("varName", "this.maxlength='50';  return this[varName];"));
     this.aj = new Array("adres", "주소은(는) 100자 이상 입력할수 없습니다.", new Function ("varName", "this.maxlength='100';  return this[varName];"));
    } 

    function password1 () { 
     this.aa = new Array("password", "비밀번호은(는) 8~20자 내에서 입력해야 합니다.", new Function ("varName", " return this[varName];"));
    } 

    function password2 () { 
     this.aa = new Array("password", "비밀번호은(는) 한글,특수문자,띄어쓰기는 허용되지 않습니다.", new Function ("varName", " return this[varName];"));
    } 

    function password3 () { 
     this.aa = new Array("password", "비밀번호은(는) 순차적인 숫자를 4개이상 연속해서 사용할수 없습니다.", new Function ("varName", " return this[varName];"));
    } 

    function password4 () { 
     this.aa = new Array("password", "비밀번호은(는) 반복되는 문자나 숫자를 4개이상 연속해서 사용할 수 없습니다.", new Function ("varName", " return this[varName];"));
    } 

    function IntegerValidations () { 
     this.aa = new Array("areaNo", "집지역번호은(는) integer 타입이어야 합니다.", new Function ("varName", "this.maxlength='4';  return this[varName];"));
     this.ab = new Array("middleTelno", "집중간전화번호은(는) integer 타입이어야 합니다.", new Function ("varName", "this.maxlength='4';  return this[varName];"));
     this.ac = new Array("endTelno", "집마지막전화번호은(는) integer 타입이어야 합니다.", new Function ("varName", "this.maxlength='4';  return this[varName];"));
    } 

    function email () { 
     this.aa = new Array("mberEmailAdres", "이메일주소은(는) 유효하지 않은 이메일 주소입니다.", new Function ("varName", "this.maxlength='50';  return this[varName];"));
    } 

</script>
<script type="text/javascript" src="/js/egovframework/com/sym/ccm/zip/EgovZipPopup.js" ></script>
<script src="/js/egovframework/com/cmm/jquery.js"></script>
<script type="text/javaScript" language="javascript" defer="defer">
/*********************************************************
 * 초기화
 ******************************************************** */
function fn_egov_init(){

	//모달 셋팅
// 	fn_modal_setting();

}
/*********************************************************
 * 모달셋팅
 ******************************************************** */
function fn_modal_setting(){
	//버튼에 모달 연결
	$("#btnMbrId").egovModal( "egovModal" );
	
	//타이틀 설졍
	$("#egovModal").setEgovModalTitle("아이디 중복 확인"); //아이디 중복 확인
	var content = "";
	content = content + "<div class='modal-alignL' style='margin:5px 0 0 0'>"+"사용할아이디 :"+"</div>"; //사용할아이디
	content = content + "<div class='modal-alignL'>"+"<input type='text' id='checkIdModal' name='checkIdModal' value='' size='20' maxlength='20' />"+"</div>";	
	content += "<div style='clear:both;'></div>";
	content += "<div id='divModalResult' style='margin:10px 0 0 0'>결과 : 중복확인을 실행하십시오.</div>"; //결과 : 중복확인을 실행하십시오.
	//모달 body 설정
	$("#egovModal").setEgovModalBody(content);

	var footer = "";
	//footer += "<div class='modal-btn'><button class='btn_s2' id='btnModalOk' onclick='fn_id_checkOk()'>확인</button></div>";
	//footer += "<div class='modal-btn'><button class='btn_s2' id='btnModalSelect' onclick='fn_id_check()'>조회</button></div>";
	footer += "<span class='btn_style1 blue' id='btnModalOk' onclick='fn_id_checkOk()'><a href='#'>확인</a></span>&nbsp;";
	footer += "<span class='btn_style1 blue' id='btnModalSelect' onclick='fn_id_check()'><a href='#'>조회</a></span>&nbsp;";
	//모달 footer 설정
	$("#egovModal").setEgovModalfooter(footer);
	
	//엔터이벤트처리
	$("input[name=checkIdModal]").keydown(function (key) {
		if(key.keyCode == 13){
			fn_id_check();	
		}
	});
	footer = null;
	content = null;
}
/*********************************************************
 * 아이디 체크 AJAX
 ******************************************************** */
function fn_id_check(){	
	$.ajax({
		type:"POST",
		url:"/egovframework-all-in-one/uss/umt/EgovIdDplctCnfirmAjax.do",
		data:{
			"checkId": $("#checkIdModal").val()			
		},
		dataType:'json',
		timeout:(1000*30),
		success:function(returnData, status){
			if(status == "success") {
				
				if(returnData.usedCnt > 0 ){
					//사용할수 없는 아이디입니다.
					$("#divModalResult").html("<font color='red'>결과 : ["+returnData.checkId+"]는 사용할수 없는 아이디입니다.</font>");
				}else{
					//사용가능한 아이디입니다.
					$("#divModalResult").html("<font color='blue'>결과 : ["+returnData.checkId+"]는 사용가능한 아이디입니다.</font>");
				}
			}else{ alert("ERROR!");return;} 
		}
		});
}

/*********************************************************
 * 아이디 체크 확인
 ******************************************************** */
function fn_id_checkOk(){
	$.ajax({
		type:"POST",
		url:"/egovframework-all-in-one/uss/umt/EgovIdDplctCnfirmAjax.do",
		data:{
			"checkId": $("#checkIdModal").val()			
		},
		dataType:'json',
		timeout:(1000*30),
		success:function(returnData, status){
			if(status == "success") {
				if(returnData.usedCnt > 0 ){
					alert("사용이 불가능한 아이디 입니다"); //사용이 불가능한 아이디 입니다.
					return;
				}else{
					
					$("input[name=mberId]").val(returnData.checkId);
					$("#egovModal").setEgovModalClose();
				}
			}else{ alert("ERROR!");return;} 
		}
		});
}


function fnIdCheck1(){
    var retVal;
    var url = "/egovframework-all-in-one/uss/umt/EgovIdDplctCnfirmView.do";
    var varParam = new Object();
    varParam.checkId = document.mberManageVO.mberId.value;
    var openParam = "dialogWidth:303px;dialogHeight:250px;scroll:no;status:no;center:yes;resizable:yes;";
        
    return false;
    retVal = window.showModalDialog(url, varParam, openParam);
    if(retVal) {
    	document.mberManageVO.mberId.value = retVal;
    }
}

function showModalDialogCallback(retVal) {
	if(retVal) {
	    document.mberManageVO.mberId.value = retVal;
	}
}

function fnListPage(){
    document.mberManageVO.action = "/egovframework-all-in-one/uss/umt/EgovMberManage.do";
    document.mberManageVO.submit();
}

function fnInsert(form){
	
	if(confirm("등록하시겠습니까?")){	
		if(validateMberManageVO(form)){
			if(form.password.value != form.password2.value){
	            alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
	            return false;
	        }
			form.submit();
			return true;
	    }
	}
}

/*********************************************************
 * 회원등록 신청
 ******************************************************** */
function id_insert(){

	var memberData = new Object();
	
		memberData.mberId				=	$("#mberId").val();
		memberData.mberNm				=	$("#mberNm").val();
		memberData.password			=	$("#password").val();
		memberData.passwordHint		=	$("#passwordHint").val();
		memberData.passwordCnsr		=	$("#passwordCnsr").val();
		memberData.sexdstnCode		=	$("#sexdstnCode").val();
		memberData.areaNo 				=	$("#areaNo").val();
		memberData.middleTelno		= 	$("#middleTelno").val();
		memberData.endTelno			=	$("#endTelno").val();
		memberData.mberFxnum		=	$("#mberFxnum").val();
		memberData.moblphonNo		=	$("#moblphonNo").val();
		memberData.mberEmailAdres	=	$("#mberEmailAdres").val();
		memberData.zip					=	$("#zip").val();
		memberData.adres				=	$("#adres").val();
		memberData.detailAdres		=	$("#detailAdres").val();
// 		memberData.mberSttus			=	$("#mberSttus").val();
		memberData.mberSttus			=	"A";

	var jsonData = JSON.stringify(memberData);
	console.log(jsonData);
	
	$.ajax({
		type:"POST",
		url:"http://192.168.56.1:8081/member/AprovRequest",
		contentType: 'application/json; charset=utf-8',
		dataType:'json',
		data:jsonData,
		timeout:(1000*30),
		success:function(returnData, status){
			if(status == "success") {
				alert("success");
			}else{
				 alert("ERROR!");return;
			} 
		}
	});
}

/*********************************************************
 * 회원정보 변경
 ******************************************************** */
function id_update(){

	var memberData = new Object();
	
		memberData.mberId				=	$("#mberId").val();
		memberData.mberNm				=	$("#mberNm").val();
		memberData.password			=	$("#password").val();
		memberData.passwordHint		=	$("#passwordHint").val();
		memberData.passwordCnsr		=	$("#passwordCnsr").val();
		memberData.sexdstnCode		=	$("#sexdstnCode").val();
		memberData.areaNo 				=	$("#areaNo").val();
		memberData.middleTelno		= 	$("#middleTelno").val();
		memberData.endTelno			=	$("#endTelno").val();
		memberData.mberFxnum		=	$("#mberFxnum").val();
		memberData.moblphonNo		=	$("#moblphonNo").val();
		memberData.mberEmailAdres	=	$("#mberEmailAdres").val();
		memberData.zip					=	$("#zip").val();
		memberData.adres				=	$("#adres").val();
		memberData.detailAdres		=	$("#detailAdres").val();
		memberData.mberSttus			=	$("#mberSttus").val();

	var jsonData = JSON.stringify(memberData);
	console.log(jsonData);
	
	$.ajax({
		type:"PUT",
		url:"http://192.168.56.1:8081/member/changeMbrInfo",
		contentType: 'application/json; charset=utf-8',
		dataType:'json',
		data:jsonData,
		timeout:(1000*30),
		success:function(returnData, status){
			if(status == "success") {
				alert("success");
			}else{
				alert("ERROR!");return;
			} 
		}
	});
}

/*********************************************************
 * 회원정보 삭제
 ******************************************************** */
function id_delete(){

	var memberData = new Object();
		memberData.mberId				=	$("#mberId").val();

	var jsonData = JSON.stringify(memberData);
	console.log(jsonData);
	
	$.ajax({
		type:"DELETE",
		url:"http://192.168.56.1:8081/member/deleteMbrInfo",
		contentType: 'application/json; charset=utf-8',
		dataType:'json',
		data:jsonData,
		timeout:(1000*30),
		success:function(returnData, status){
			if(status == "success") {
				alert("success");
			}else{
				alert("ERROR!");return;
			} 
		}
	});
}

/*********************************************************
 * 회원가입 상태 변경
 ******************************************************** */
function id_updateState(){

	var memberData = new Object();
		memberData.mberId				=	$("#mberId").val();
		memberData.mberSttus			=	$("#mberState").val();
		
	var jsonData = JSON.stringify(memberData);
	console.log(jsonData);
	
	$.ajax({
		type:"PUT",
		url:"http://192.168.56.1:8081/member/changeMbrState",
		contentType: 'application/json; charset=utf-8',
		dataType:'json',
		data:jsonData,
		timeout:(1000*30),
		success:function(returnData, status){
			if(status == "success") {
				alert("success");
			}else{
				alert("ERROR!");return;
			} 
		}
	});
}
</script>
<style>
.modal-content {width: 400px;}
</style>
</head>
<body>
<!-- <form id="mberManageVO" name="mberManageVO" >  -->
	<div class="wTableFrm">
	<!-- 타이틀 -->
	<h2>일반회원관리 등록</h2>

	<!-- 등록폼 -->
	<table class="wTable" summary="일반회원관리의 내역에 대한 목록을 출력합니다.">
	<caption>일반회원관리 등록</caption>
	<colgroup>
		<col style="width: 22%;"><col style="width: ;">
	</colgroup>
	<tbody>
		<!-- 입력/선택 -->
		<!-- 일반회원아이디 -->
		<tr>
			<th><label for="mberId">일반회원아이디</label> <span class="pilsu">*</span></th>
			<td class="left">
<!-- 				<input id="mberId" name="mberId" title="일반회원아이디 입력" style="width:80%;" readonly="readonly" type="text" value="" size="20" maxlength="20"/> -->
				<input id="mberId" name="mberId" title="일반회원아이디 입력" style="width:80%;" type="text" value="" size="20" maxlength="20"/>
				<button id="btnMbrId" class="btn_s2" onClick="return false;" title="삭제 버튼">중복아이디 검색</button>
				<div></div>
			</td>
		</tr>
		
		<!-- 일반회원이름 -->
		<tr>
			<th><label for="mberNm">일반회원이름</label> <span class="pilsu">*</span></th>
			<td class="left">
				<input id="mberNm" name="mberNm" title="일반회원이름 입력" type="text" value="" size="50" maxlength="50"/>
				<div></div> 
			</td>
		</tr>
		<!-- 비밀번호 -->
		
		<tr>
			<th><label for="password">비밀번호</label> <span class="pilsu">*</span></th>
			<td class="left">
				<input id="password" name="password" title="비밀번호 입력" type="password" value="" size="50" maxlength="20"/>
				<div></div> 
			</td>
		</tr>
		<!-- 비밀번호확인 -->
		
		<tr>
			<th><label for="password2">비밀번호확인</label> <span class="pilsu">*</span></th>
			<td class="left">
			<input name="password2" id="password2" title="비밀번호확인 입력" type="password" size="50" maxlength="20" />
			</td>
		</tr>
		<!-- 비밀번호힌트 -->
		
		<tr>
			<th><label for="passwordHint">비밀번호힌트</label> <span class="pilsu">*</span></th>
			<td class="left">
				<select id="passwordHint" name="passwordHint" title="비밀번호힌트 선택">
					<option value="" selected="selected">--선택하세요--</option>
					<option value=" P01">가장 기억에 남는 장소는?</option><option value=" P02">나의 좌우명은?</option><option value=" P03">나의 보물 제1호는?</option><option value=" P04">가장 기억에 남는 선생님 성함은?</option><option value=" P05">다른 사람은 모르는 나만의 신체비밀은?</option><option value=" P06">오래도록 기억하고 싶은 날짜는?</option><option value=" P07">받았던 선물 중 기억에 남는 독특한 선물은?</option><option value=" P08">가장 생각나는 친구 이름은?</option><option value=" P09">인상 깊게 읽은 책 이름은?</option><option value=" P10">내가 존경하는 인물은?</option><option value=" P11">나의 노래방 애창곡은?</option><option value=" P12">가장 감명깊게 본 영화는?</option><option value=" P13">좋아하는 스포츠팀 이름은?</option>
				</select>
				<div></div>
			</td>
		</tr>
		<!-- 비밀번호정답 -->
		
		<tr>
			<th><label for="passwordCnsr">비밀번호정답</label> <span class="pilsu">*</span></th>
			<td class="left">
				<input id="passwordCnsr" name="passwordCnsr" class="txaIpUmt" title="비밀번호정답 입력" type="text" value="" size="50" maxlength="100"/>
				<div></div>
			</td>
		</tr>
		<!-- 성별구분코드 -->
		
		<tr>
			<th><label for="sexdstnCode">성별구분코드</label></th>
			<td class="left">
				<select id="sexdstnCode" name="sexdstnCode" title="성별구분코드 선택">
					<option value="" selected="selected">--선택하세요--</option>
					<option value="M">남자</option><option value="F">여자</option>
				</select>
			</td>
		</tr>
		<!-- 전화번호 -->
		
		<tr>
			<th><label for="areaNo">전화번호</label> <span class="pilsu">*</span></th>
			<td class="left">
                    <input id="areaNo" name="areaNo" class="txaIpUmt" title="전화번호" style="width:40px;" type="text" value="" size="5" maxlength="4"/>
                    - <input id="middleTelno" name="middleTelno" class="txaIpUmt" style="width:40px;" type="text" value="" size="5" maxlength="4"/>
                    - <input id="endTelno" name="endTelno" class="txaIpUmt" style="width:40px;" type="text" value="" size="5" maxlength="4"/>
			</td>
		</tr>
		<!-- 팩스번호 -->
		
		<tr>
			<th><label for="mberFxnum">팩스번호</label></th>
			<td class="left">
                    <input id="mberFxnum" name="mberFxnum" class="txaIpUmt" title="팩스번호 입력" type="text" value="" size="20" maxlength="15"/>
                    <div></div>
			</td>
		</tr>
		<!-- 헨드폰번호 -->
		
		<tr>
			<th><label for="moblphonNo">핸드폰번호</label> <span class="pilsu">*</span></th>
			<td class="left">
                    <input id="moblphonNo" name="moblphonNo" class="txaIpUmt" title="핸드폰번호 입력" type="text" value="" size="20" maxlength="15"/>
                    <div></div>
			</td>
		</tr>
		<!-- 이메일주소 -->
		
		<tr>
			<th><label for="mberEmailAdres">이메일주소</label> <span class="pilsu">*</span></th>
			<td class="left">
                    <input id="mberEmailAdres" name="mberEmailAdres" class="txaIpUmt" title="이메일주소 입력" type="text" value="" size="30" maxlength="50"/>
                    <div></div>
			</td>
		</tr>
		<!-- 우번번호 -->
		
		<tr>
			<th><label for="zip">우편번호</label> <span class="pilsu">*</span></th>
			<td class="left">
                    <input name="zip" id="zip" title="우편번호 입력" type="text" size="20" value="" maxlength="6" style="width:60px;" />
                    <!-- form:hidden path="zip" id="zip" --> 
                    <!-- <button class="btn_s2" onClick="fn_egov_ZipSearch(document.mberManageVO, document.mberManageVO.zip, document.mberManageVO.zip_view, document.mberManageVO.adres);return false;" title="삭제 버튼">우번번호검색</button>  -->
                    <div></div>
			</td>
		</tr>
		<!-- 주소 -->
		
		<tr>
			<th><label for="adres">주소</label> <span class="pilsu">*</span></th>
			<td class="left">
                    <input id="adres" name="adres" class="txaIpUmt" title="주소 입력" type="text" value="" size="70" maxlength="100"/>
                    <div></div>
			</td>
		</tr>
		<!-- 상세주소 -->
		
		<tr>
			<th><label for="detailAdres">상세주소</label></th>
			<td class="left">
                    <input id="detailAdres" name="detailAdres" class="txaIpUmt" title="상세주소 입력" type="text" value="" size="70" maxlength="100"/>
                    <div></div>
			</td>
		</tr>
<!-- 		<input type="hidden" name="mberSttus" value="DEFAULT" /> -->
	</tbody>
	</table>
	<br>
	<!-- 하단 버튼 --> 
	<button title="회원가입신청" onclick="id_insert();" >회원가입신청</button>
	<button title="회원정보변경" onclick="id_update();" >회원정보변경</button>
	<button title="회원정보삭제" onclick="id_delete();" >회원정보삭제</button>
	<button title="회원승인" onclick="id_updateState();" >회원승인</button>
	<br>
		<tr>
			<th><label for="mberSttus">회원가입상태</label> <span class="pilsu">*</span></th>
			<td class="left">
				<select id="mberSttus" name="mberSttus" title="회원가입상태">
					<option value="" selected="selected">--선택하세요--</option>
					<option value="A">신청</option>
					<option value="P">승인</option>
					<option value="D">삭제</option>
				</select>
			</td>
		</tr>
		<!-- 비밀번호정답 -->
 <!-- 우편번호검색 -->
 <input type="hidden" name="zip_url" value="/egovframework-all-in-one/sym/ccm/zip/EgovCcmZipSearchPopup.do" />
<!-- </form> -->

<!-- Egov Modal include  -->

</body>
</html>
