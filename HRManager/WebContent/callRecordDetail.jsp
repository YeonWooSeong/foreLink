<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/applicants_manager.js"></script>
<link rel="stylesheet" type="text/css" href="css/applicants_manager.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table>
			<tr>
				<th>통화일시</th>
				<td>${record.callDate}</td>
				<th>가용년월</th>
				<td>${record.callAvailDate}</td>
			</tr>
			<tr>
				<th>통화내용</th>
				<td colspan="3">${record.callContents}</td>
			</tr>
			
			<tr>
				<th colspan="4"><input type="button" value="닫기" onclick="closePopup()"></th>
			</tr>
			
		</table>
	</div>
</body>
</html>