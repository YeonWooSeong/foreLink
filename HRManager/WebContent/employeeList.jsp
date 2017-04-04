<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- +@ -->
<jsp:useBean id="now" class="java.util.Date" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/applicants_manager.js"></script>
<link rel="stylesheet" type="text/css" href="css/applicants_manager.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="mainDiv">
	<div class="searchDiv">
		<div class="searchDivCenter">	
		<form action="EmployeeList" method="post">
			<table class="searchTable">
				<colgroup>
					<col></col>
					<col></col>
					<col></col>
				</colgroup>
				<tr>
					<td><input class="submit" type="button" value="초기화면" onclick="location.href='EmployeeList'"></td>
					<th>성명</th>
					<th><input type="text" name="name" value="${searchName}"></th>
					<td></td>
					<th>업무</th>
					<th><input type="text" name="job" value="${searchJob}"></th>
					<td></td>
					<th>등급</th>
					<th><input type="text" name="grade" value="${searchGrade}"></th>
					<td></td>
					<th>스킬</th>
					<th><input type="text" name="skill" value="${searchSkill}"></th>
					<td></td>
					<td><input class="submit" type="submit" value="검색"></td>
					<td><input class="submit" type="button" value="등록" onclick="location.href='employeeCreate.jsp'"/></td>
					<td><input class="submit" type="button" value="삭제" onclick="fn_userDel(this)"></td> 
					<td></td>
					<td></td>
					<td class="spTd1"><input type="button" class="submitC" onclick="exel(this)" value="엑셀 다운로드"></td>
					<td></td>
				</tr>
			</table>
		</form>
		<form id="excelForm" action="ListDownLoad" method="post">	
			<input type="hidden" name="name" value="${searchName }">
			<input type="hidden" name="job" value="${searchJob }">
			<input type="hidden" name="skill" value="${searchSkill }">
			<input type="hidden" name="grade" value="${searchGrade }">
		</form>
		</div>
	</div>
	<br/><br/><br/>
	<div class="listDiv">
	<div class="listDivOuter">
	<div class="listDivInner">
	<div class="listDivCenter">	
		<table class="listTable">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>등급</th>
				<th>성별</th>
				<th>생년월일</th>
				<th>연락처</th>
				<!-- 이메일 추가  -->
				<th>이메일</th>
				<th>주소</th>
				<th>학력</th>
				<th>스킬</th>
				<th>업무</th>
				<th>자격증</th>
				<th>총경력</th>
				<th>가용년월</th>
				<th>평가</th>
				<th>비고</th>
				<!-- <th></th> -->
				 <th>
				 <input id="allCheck" name="check_group" type="checkbox" onclick="CheckAll()"/></th>
			</tr>
			<c:forEach var="entity" items="${employeeList }" varStatus="status">
				
				<tr>
					<td>${status.index }</td>
					
					<td><form action="EmployeeDetail" method="post">
						<a onclick="showDetail(this)">${entity.name }</a>
						<input type="hidden" name="entityNo" value="${entity.no}">
						</form></td>
					
					<td>${entity.grade }</td>
					<td>${entity.sex }</td>
					<td>${entity.birth }</td>
					<td>${entity.phone }</td>
					<!-- 이메일 추가  -->
					<td>${entity.email }</td>
					<td>${entity.address }</td>
					<td>${entity.education}</td>
					<td>${entity.skill}</td>
					<td>${entity.job}</td>
					<td>${entity.license }</td>
					<td>${entity.totalCareer }</td>
					<td>${entity.availdate }</td>
					<td>${entity.comment }</td>
					<td>${entity.description }</td>
				<%-- 	<td>
						<form method="post" action="boardDelete">
						<input type="button" onclick="deleteBoard(this)" value="삭제">
						<input type="hidden" value="${entity.no  }" name="index">
					</form>
					</td> --%>
					<td>
					 <form action="chkDelete" method="post" id="chkboxDelete" enctype="multipart/form-data">
					<input type="checkbox"  name="check_num" id="check_num"  class="checkSelect"  value="${entity.name}">
					<input type="hidden" name="hiddenName" value="${entity.no}"> 
					</form> 
					</td>
				</tr>	
					
			</c:forEach>
		</table>
	</div>
	</div>
	</div>
	</div>
</div>	
</body>
</html>
