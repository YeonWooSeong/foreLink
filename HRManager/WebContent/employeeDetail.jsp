<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="ENTITY.EmployeeEntity"%>
<%@page import="ENTITY.CallRecordEntity"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/applicants_manager.js"></script>
<link rel="stylesheet" type="text/css" href="css/employeeDetail.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%
	EmployeeEntity entity=(EmployeeEntity)(request.getAttribute("employee"));
	String startDate1=entity.getStartdate().substring(0,4);
	String startDate2=entity.getStartdate().substring(6,7);

	String blankPeriod1=entity.getBlankPeriod().split("년")[0];
	String blankPeriod2=entity.getBlankPeriod().substring(blankPeriod1.length()+2,entity.getBlankPeriod().length()-2);


 	%>
<title>상세정보</title>
</head>
<body>
<div class="container">
	<div id="header">
		<div id="header-l">
			상세 정보
		</div>
		<div id="header-r">
			<a href="EmployeeList"><img src="./content/forelink_logo2.jpg"></a>
		</div>
	</div>
	<div id="menu">
	<form action="Update" method="post" enctype="multipart/form-data" id="update">
	<table class="detailTable">
		<tr>
			<th>성 명</th>
			<td>${employee.name }<input type="hidden" name="number" value="${employee.no}">
								<input type="hidden" name="name" id="name" value="${employee.name}">
			</td>
		</tr>
		<tr>
			<th>성별</th>
			<td><c:if test="${employee.sex=='남자' }">
				<input type="radio" name="sex" value="남자" checked="checked">남
				<input type="radio" name="sex" value="여자">여
				</c:if> <c:if test="${employee.sex!='남자' }">
				<input type="radio" name="sex" value="남자">남
				<input type="radio" name="sex" value="여자" checked="checked">여
				</c:if>
			</td>
		</tr>
		<tr>
			<th>연락처</th>
			<td colspan="3"><input  class="detailWidth"  type="text" name="phone"	value="${employee.phone }" id="phone" maxlength="13">
			<!-- 예시 추가  -->
			ex) 010-0000-0000
			</td>
		</tr>
		<!-- 이메일 추가 -->
		<tr>
			<th>이메일</th>
			<td colspan="3"><input  class="detailWidth"  type="text" name="email"	value="${employee.email }" id="email">
			</td>
		</tr>
		
		<tr>
			<th>주 소</th>
			<td colspan="3"><input  class="detailWidth"  type="text" name="address" value="${employee.address }">
			</td>
		</tr>
		<tr>	
		
		</tr>
		<tr>
			<th>생년월일</th>
			<td><input class="detailWidth" type="text" name="birth"	value="${employee.birth }" maxlength="6">
				ex)800101
			</td>
		</tr>
		<tr>
			<th>자격증</th>
			<td><c:if test="${employee.license=='유' }">
				<input type="radio" name="license" value="유" checked="checked">유
				<input type="radio" name="license" value="무">무
				</c:if> <c:if test="${employee.license=='무' }">
				<input type="radio" name="license" value="유">유
				<input type="radio" name="license" value="무" checked="checked">무
				</c:if>
			</td>
		</tr>
		<tr>
			<th>졸업년월</th>
			<td><input class="detailWidth" type="text" name="graduateDate" value="${employee.graduateDate }"></td>
		</tr>
		<tr>
			<th>학 력</th>
			<td><select name="education">
				<c:forEach var="educationList" items="${educationArray}" varStatus="status">
					<option value="${educationList}" ${educationList == employee.education ? 'selected="selected"' : '' }>${educationList}</option>		
				</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th>스 킬</th>
			<td><select name="skill1">
				<c:forEach var="skillList" items="${skillArray}" varStatus="status">
					<option value="${skillList}" ${skillList == skill1 ? 'selected="selected"' : '' }>${skillList}</option>		
				</c:forEach>
				</select><br/>
				<select name="skill2">
				<c:forEach var="skillList" items="${skillArray}" varStatus="status">
					<option value="${skillList}" ${skillList == skill2 ? 'selected="selected"' : '' }>${skillList}</option>		
				</c:forEach>
				</select><br/>
				<select name="skill3">
				<c:forEach var="skillList" items="${skillArray}" varStatus="status">
					<option value="${skillList}" ${skillList == skill3 ? 'selected="selected"' : '' }>${skillList}</option>		
				</c:forEach>
				</select><br/>
				<input class="detailWidth" type="text" name="skill4" value="${skill4}">
			</td>
		</tr>
		<tr>
			<th>업 무</th>
			<td><select name="job1">
				<c:forEach var="jobList" items="${jobArray}" varStatus="status">
					<option value="${jobList}" ${jobList == job1 ? 'selected="selected"' : '' }>${jobList}</option>		
				</c:forEach>
				</select><br/>
				<select name="job2">
				<c:forEach var="jobList" items="${jobArray}" varStatus="status">
					<option value="${jobList}" ${jobList == job2 ? 'selected="selected"' : '' }>${jobList}</option>		
				</c:forEach>
				</select><br/>
				<select name="job3">
				<c:forEach var="jobList" items="${jobArray}" varStatus="status">
					<option value="${jobList}" ${jobList == job3 ? 'selected="selected"' : '' }>${jobList}</option>		
				</c:forEach>
				</select><br/>
				<input class="detailWidth" type="text" name="job4" value="${job4}">
			</td>
			</tr>
			<tr>
				<th>경력시작년월</th>
				<td><input class="detailWidthShort" type="text" name="startDate1" size="3" value=<%=startDate1%> id="startDate1" maxlength="4">년
				    <input class="detailWidthShort" type="text" name="startDate2" size="3" value=<%=startDate2%> id="startDate2" maxlength="2">월
				</td>
			</tr>
			<tr>	
				<th>등 급</th>
				<td>${employee.grade }</td>
			</tr>
			<tr>
				<th>공백기간</th>
				<td><input class="detailWidthShort" type="text" name="blankPeriod1" value=<%=blankPeriod1%> size="3" maxlength="4">년
				    <input class="detailWidthShort" type="text" name="blankPeriod2" value=<%=blankPeriod2%> size="3" maxlength="2">개월
				</td>
			</tr>
			<tr>
				<th>총경력</th>
				<td>${employee.totalCareer}</td>
			</tr>
			<tr>
				<th>평가</th>
					<td>
						<input type="radio" name="comment" value="A" <c:if test="${employee.comment.equals('A')}">checked="checked"</c:if>>A
						<input type="radio" name="comment" value="B" <c:if test="${employee.comment.equals('B')}">checked="checked"</c:if> >B
						<input type="radio" name="comment" value="C" <c:if test="${employee.comment.equals('C')}">checked="checked"</c:if> >C
						<input type="radio" name="comment" value="D" <c:if test="${employee.comment.equals('D')}">checked="checked"</c:if> >D
					</td>
			</tr>
			<tr>	
				<th>비고</th><td><input class="detailWidth" type="text" name="description" value="${employee.description}"></td>
			</tr>
			<tr>
				<th>가용년월</th>
				<td colspan="3"><input class="detailWidth" type="text" name="availDate" value="${employee.availdate}"/></td>
			</tr>
			<tr>
				<td colspan="4" height="15"></td>
			</tr>
			<tr>
				<th>통화내용</th>
				<td colspan="3"><textarea rows="6" cols="57" name="callContents"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<select name="type">
						<option value="일반">일반</option>
						<option value="KT">KT</option>
						<option value="U+">U+</option>
					</select>
					<input type="file" name="fileAddress">
				</td>
			</tr>
			</table>
		<div id="input-div">
			<input class="submit" type="button" value="업데이트" onclick="update()">
			<input class="submit" type="button" value="돌아가기" onclick="location.href='EmployeeList'">
		</div>
	</form> 
	</div>
	<div id="content">
	<table class="resumeList">
		<colgroup>
			<col width="150px" />
			<col />
			<col width="100px" />
		</colgroup>
		<tr>
			<th class="resumeTitle" colspan='3'>이력서 목록</th>
			<c:if test="${downloadList.size() == 0 }">
		<tr>
			<td colspan="4">파일이 없습니다.</td>
		</tr>
			</c:if>
			<c:forEach var="entity" items="${downloadList }">
			<tr>
				<td>
				<form action="FileDownLoad" method="post">
					<a class="submitA" onclick="startDownload(this)">${entity.fileName }</a>
					<input class="submit" type="hidden" name="fileName" value="${entity.fileName }">
				</form>
				</td>
				<th>
					${entity.fileType }
				</th>
				<th>
					<form method="post" action="FileDelete">
						<input class="submitB" type="button" onclick="deleteFile(this)" value="삭제">
						<input type="hidden" value="${entity.fileName }" name="fileName">
						<input type="hidden" value="${entity.employeeNo }" name="employeeNo">
					</form>
				</th>
			</tr>
			</c:forEach>
		</tr>
	</table>
	<br>
	<p class="pTitle">통화 내역</p>
	<table class="callTable">
		<colgroup>
			<col width="150px" />
			<col />
			<col width="100px" />
			<col width="100px" />
		</colgroup>
		<tr>
			<th>통화일시</th>
			<th>목적 및 주요내용</th>
			<th>가용년월</th>
			<th></th>
		</tr>
			<c:if test="${callRecordsList.size() == 0 }">
		<tr>
			<td colspan="4">통화 내역이 없습니다.</td>
		</tr>
			</c:if>
			<c:forEach var="entity" items="${callRecordsList}">
		<tr>
			<td>${entity.callDate }</td>
			<td>
				<form action="CallRecordDetail" method="post">
					<a onclick="showCallRecordDetail(this)">${entity.callContents}</a>
					<input type="hidden" name="employeeNo" value="${entity.no}"> 
					<input type="hidden" name="recordNo"  value="${entity.recordNo}">
				</form>
			</td>
			<td>${entity.callAvailDate}</td>
			<td>
				<form action="CallRecordDelete" method="post" id="deleterecord">						
					<input class="submitB" type="button" value="삭제" onclick="deleterecord(this)">
					<input type="hidden" name="employeeNo" id="employeeNo" value="${entity.no}">
					<input type="hidden" name="recordNo" id="recordNo" value="${entity.recordNo}">	
				</form>
			</td>
		</tr>
			</c:forEach>
	</table>
	</div>
</div>
</body>
</html>