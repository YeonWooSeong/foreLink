<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/employeeDetail.css">
<script type="text/javascript" src="js/applicants_manager.js"></script>
<script type="text/javascript">
	


	function checkDupSkill() {
		
		var skill1= "" ;
		var skill2= "" ;
		var skill3= "" ;
		
		var dup =0;
		
		for (var i=0;i<document.getElementById("skill1").length;i++){
			if(document.getElementById("skill1")[i].selected ){
				skill1 = document.getElementById("skill1")[i].value;
				if(skill1==""){
					++dup;
				}
			}
		}
		
		for (var i=0;i<document.getElementById("skill2").length;i++){
			if(document.getElementById("skill2")[i].selected ){
				skill2 = document.getElementById("skill2")[i].value;
				if(skill2==""){
					++dup;
				}
			}
		}
		
		for (var i=0;i<document.getElementById("skill3").length;i++){
			if(document.getElementById("skill3")[i].selected ){
				skill3 = document.getElementById("skill3")[i].value;
				if(skill3==""){
					++dup;
				}
			}
		}

		if(skill1 == skill2 || skill2==skill3 || skill3 ==skill1 ){
			if(dup<2){
				alert(11111);
				return false;
			}
			

		}
		
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="container">
	<div id="header">
		<div id="header-l">
			인원 등록
		</div>
		<div id="header-r">
			<a href="EmployeeList"><img src="./content/forelink_logo2.jpg"></a>
		</div>
	</div>
	<div id="main">
	<div id="contents">
		<form id="employeeForm" action="EmployeeCreate" method="post" enctype="multipart/form-data">
		<table class="detailTable">
			<tr>
				<th>성 명</th><td><input class="detailWidth" type="text" name="name" id="name"></td>
			</tr>
			<tr>	
				<th>성별</th><td><input type="radio" name="sex" value="남자" checked="checked">남
								<input type="radio" name="sex" value="여자">여</td>
			</tr>	
			<tr>
				<th>연락처</th><td colspan="3"><input class="detailWidth" type="text" name="phone" id="phone" maxlength="13">
				ex)010-0000-0000
				</td>
				
			</tr>	
			<!-- 이메일 추가 -->
			<tr>
				<th>이메일</th><td colspan="3"><input class="detailWidth" type="text" name="email" id="email"></td>
			</tr>	
			<tr>
				<th>주 소</th><td colspan="3"><input class="detailWidth"  type="text" name="address"></td>
			</tr>
			<tr>
				<th>생년월일</th><td><input class="detailWidth" type="text" name="birth" maxlength="6">ex)800101</td>
			</tr>
			<tr>	
				<th>자격증</th><td><input type="radio" name="license" value="유">유
								  <input type="radio" name="license" value="무" checked="checked">무</td>
			</tr>	
			<tr>
				<th>학 력</th><td><select name="education">
									<option value="고졸" selected="selected">고졸</option>
									<option value="초대졸">초대졸</option>
									<option value="대졸">대졸</option>
									<option value="석사">석사</option>
									<option value="박사">박사</option>
								</select></td>
			</tr>
			<tr>	
				<th>졸업년월</th><td><input class="detailWidth" type="text" name="graduateDate"></td>
				
			</tr>	
			
			<tr>
				<th>스 킬</th><td>
				<select name="skill1" id="skill1"  >
				<option value="">선택</option>
				<option value="Java">Java</option>
				<option value="Pro-C">Pro-C</option>
				<option value="Unix-C">Unix-C</option>
				<option value="C++">C++</option>
				</select><br/>
				<select name="skill2" id="skill2" onchange="checkDupSkill()">
				<option value="">선택</option>
				<option value="Java">Java</option>
				<option value="Pro-C">Pro-C</option>
				<option value="Unix-C">Unix-C</option>
				<option value="C++">C++</option>
				</select><br/>
				<select name="skill3" id="skill3"  onchange="checkDupSkill()">
				<option value="">선택</option>
				<option value="Java">Java</option>
				<option value="Pro-C">Pro-C</option>
				<option value="Unix-C">Unix-C</option>
				<option value="C++">C++</option>
				</select><br/>
				<input class="detailWidth" type="text" name="skill4">
				</td>
			</tr>
			<tr>
				<th>업 무</th><td><br/>
				<select name="job1">
				<option value="">선택</option>
				<option value="통신">통신</option>
				<option value="금융">금융</option>
				<option value="공공">공공</option>
				<option value="DBA">DBA</option>
				<option value="AA">AA</option>
				<option value="DW">DW</option>
				<option value="미들웨어">미들웨어</option>
				</select><br/>
				<select name="job2">
				<option value="">선택</option>
				<option value="통신">통신</option>
				<option value="금융">금융</option>
				<option value="공공">공공</option>
				<option value="DBA">DBA</option>
				<option value="AA">AA</option>
				<option value="DW">DW</option>
				<option value="미들웨어">미들웨어</option>
				</select><br/>
				<select name="job3">
				<option value="">선택</option>
				<option value="통신">통신</option>
				<option value="금융">금융</option>
				<option value="공공">공공</option>
				<option value="DBA">DBA</option>
				<option value="AA">AA</option>
				<option value="DW">DW</option>
				<option value="미들웨어">미들웨어</option>
				</select><br/>
				<input class="detailWidth" type="text" name="job4">
				</td>
			</tr>	
			<tr>
				<th>경력시작년월</th><td><input class="detailWidthShort" type="text" name="startDate1" size="3" id="startDate1" maxlength="4">년
									<input class="detailWidthShort" type="text" name="startDate2" size="3" id="startDate2" maxlength="2">월</td>
			</tr>
			<tr>	
				<th>등 급</th><td>
				-
				</td>
			</tr>
			<tr>
				<th>공백기간</th><td><input class="detailWidthShort" type="text" name="blankPeriod1" value="0" size="3" maxlength="4">년
							<input class="detailWidthShort" type="text" name="blankPeriod2" value="0" size="3" maxlength="2">개월</td>
			</tr>
			<tr>	
				<th>총경력</th><td>
				-
				</td>
			</tr>
			<tr>
				<th>평가</th>
					<td>
						<input type="radio" name="comment" value="A">A
						<input type="radio" name="comment" value="B">B
						<input type="radio" name="comment" value="C">C
						<input type="radio" name="comment" value="D">D
					</td>
			</tr>
			<tr>
				<th>비고</th><td><input class="detailWidth" type="text" name="description"></td>
			</tr>
			<tr>
				<th>가용년월</th><td  colspan="3"><input class="detailWidth"  type="text" name="availDate"></td>
			</tr>
			<tr>
			<td colspan=4>

				<select name="type">
					<option value="일반">일반</option>
					<option value="KT">KT</option>
					<option value="U+">U+</option>
				</select>
			
				<input type="file" name="fileAddress">
				
			</td>
			</tr>
			<tr><td colspan="4" height="15"></td></tr>
						
			<tr>
				<th>통화내용</th><td colspan="3"><textarea rows="6" cols="57"  name="callContents">${yourName}</textarea></td>
			</tr>		
		</table>
		<div id="input-div">
			<input class="submit" type="button" value="추가" onclick="employeeCreate(this)">
			<input class="submit" type="reset" value="초기화">
			<input class="submit" type="button" value="돌아가기" onclick="location.href='EmployeeList'">
		</div>
	</form>
	</div>
	</div>
</div>
</body>
</html>
