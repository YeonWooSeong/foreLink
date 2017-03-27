 <%@ page language="java" contentType="application/vnd.ms-excel; name='excel', text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	response.setHeader("Content-Disposition", "attachment; filename=list.xls"); 
    response.setHeader("Content-Description", "JSP Generated Data"); 
    response.setContentType("application/vnd.ms-excel");
%>
<table>
	<tr>
		<th>번호</th>
		<th>성명</th>
		<th>등급</th>
		<th>성별</th>
		<th>생년월일</th>
		<th>연락처</th>
		<th>이메일</th>
		<th>주소</th>
		<th>학력</th> 
		<th>스킬</th>
		<th>업무</th>
		<th>자격증유무</th>
		<th>총경력</th>
		<th>가용년월</th>
		<th>평가</th>
		<th>비고</th>
	</tr>
	<c:forEach var="entity" items="${employeeList }" varStatus="status">
		
		<tr>
			<td>${status.count }</td>
			
			<td><form action="EmployeeDetail" method="post">
				<a class="submitA" onclick="showDetail(this)">${entity.name }</a>
				<input type="hidden" name="entityNo" value="${entity.no }">
				</form></td>
			
			<td>${entity.grade }</td>
			<td>${entity.sex }</td>
			<td>${entity.birth }</td>
			<td>${entity.phone }</td>
			<td>${entity.email }</td>
			<td>${entity.address }</td>
			<td>${entity.education }</td>
			<td>${entity.skill }</td>
			<td>${entity.job }</td>
			<td>${entity.license }</td>
			<td>${entity.totalCareer }</td>
			<td>${entity.availdate }</td>
			<td>${entity.comment}</td>
			<td>${entity.description}</td>
		</tr>	
			
	</c:forEach>
</table>

</body>
</html>
