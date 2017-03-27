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
	<h1>인적 자원 관리 시스템.</h1>
	<form id="loginForm" action="loginForm" method="post" enctype="multipart/form-data">
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
			<td colspan='2'><input class="submitLogin" type="button" value="로그인" onclick="login()"></td>
		</tr>
		<tr>
			<td colspan='2'><input class="submitLogin" type="button" value="신규등록" id="join" onclick="location.href='index2.jsp'"></td>
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