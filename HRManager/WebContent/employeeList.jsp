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
<c:set var="now" value="<%=new java.util.Date()%>" />
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
					<td><input class="submit" type="button" value="삭제" onclick="fn_userDel()"></td>
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
	<h5>" ${yourName} " 님이 로그인 하셨습니다.</h5> 
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
				<th><input id="allCheck" type="checkbox" onclick="allChk(this)"/></th>
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
					<td><c:choose>
					<c:when test="${entity.availdate eq ''}">
					<fmt:formatDate pattern="yyyy-MM-dd" value="${now}" />
					</c:when>
					<c:otherwise>
					${entity.availdate }
					</c:otherwise>
					</c:choose> </td>
					<td>${entity.comment }</td>
					<td>${entity.description }</td>
					<td><input﻿ name="memberChk" id="memberChk" type="checkbox" value="${status.index}"/></td>
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
