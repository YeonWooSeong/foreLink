<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/applicants_manager.js"></script>
<link rel="stylesheet" type="text/css" href="css/applicants_manager.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인적 자원 관리 시스템</title>
</head>
<body>
<div class="detailDiv">
<div class="detailDivOuter">
<div class="detailDivInner">
<div class="detailDivCenter">
	<img src="./content/forelink_logo.jpg">
	<h1>인적 자원 관리 시스템. - 신규등록.</h1>
	<form id="joinFore" action="joinCreate2" method="post" enctype="multipart/form-data">
	<table class="loginTable">
		<tr>
			<th>ID</th>
			<td><input class="textLogin" type="text" name="id" id="id"></td>
			
		</tr>
		<tr>
			<th>PW</th>
			<td><input class="textLogin" type="password" name="pass" id="pass" onkeydown="javascript: if (event.keyCode == 13) {login();}"></td>
		</tr>
			<tr>
			<th>이름</th>
			<td><input class="textLogin" type="text" name="name" id="name"></td>
			
		</tr>
		<tr>
			<td colspan='2'><input class="submitLogin" type="button" value="등록" id="join" onclick="Join(this)"/>
		</tr>
		<tr>
			<td colspan='2'><input class="submitLogin" type="button" value="초기화면" onclick="location.href='index.jsp'"></td>
		</tr>
		<tr>
			
		</tr>
	</table>
	</form>
</div>
</div>
</div>
</div>

<script type="text/javascript">

</script>
</body>


</html>