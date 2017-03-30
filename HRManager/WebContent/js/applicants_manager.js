// 1.모두 체크
function CheckAll_dd(){ 
var gChk = document.getElementsByName("check_group"); //체크박스의 name값
var nChk = document.getElementsByName("check_num"); 
if(gChk[0].checked){ 
for(i=0; i<nChk.length;i++){ 
nChk[i].checked = true; //체크되어 있을경우 설정변경
}
}else{
for(i=0; i<nChk.length;i++){ 
nChk[i].checked = false; 
} 
}
}
//﻿2. 체크박스 선택된 것 삭제 처리 (N개) 
   function fn_userDel_dd(){
  var chkId = "";
  var memberChk = document.getElementsByName("check_num");
  var chked = false;
  var indexid = false;
  for(i=0; i < memberChk.length; i++){
   if(memberChk[i].checked){
       	chkId = memberChk[i].value;
        indexid = true;
   }
  }
  if(!indexid){
   alert("삭제할 사용자를 체크해 주세요 .");
   return;
  }
  
  var agree=confirm("삭제 하시겠습니까?");
     if (agree){
    	 alert("chkId ="+chkId);
    document.getElementById("boardDelete2").submit();
     } 
  }﻿








function Join(input){
	var id=document.getElementById("id").value;
	var pass=document.getElementById("pass").value;
	var name=document.getElementById("name").value;
	
	if(id==""){
		alert("아이디를 입력해주세요.");
		return;
	}else if(pass==""){
		alert("비밀번호를 입력해주세요.");
		return;
	}else if(name==""){
		alert("이름을 입력해주세요.");
		return;
	}else{
		document.getElementById("joinFore").submit();
	}
}


  
function login(){
	
	var id=document.getElementById("id").value;
	var pass=document.getElementById("pass").value;
	var loginForm=document.getElementById("loginForm");
	if(id==""){
		alert("아이디를 입력해주세요.");
		return;
	}else if(pass==""){
		alert("비밀번호를 입력해주세요.");
		return;
	}else{
		document.getElementById("loginForm").submit();
	}
}


function showDetail(input){
	input.parentNode.submit();
}

function update(){
	var name=document.getElementById("name").value;
	var phone=document.getElementById("phone").value;
	var startDate1=document.getElementById("startDate1").value;
	var startDate2=document.getElementById("startDate2").value;
	
	// 이메일 추가
	var email = document.getElementById("email").value;
	
	var update=document.getElementById("update");
	
	if(name==""){
		alert("이름을 입력해주세요.");
		return;
	}else if(phone==""){
		alert("연락처를 입력해주세요.");
		return;
	}else if(startDate1==""){
		alert("경력시작년월을 입력해주세요.");
		return;
	}else if(startDate2==""){
		alert("경력시작년월을 입력해주세요.");
		return;
	}else{
		if((confirm("수정하시겠습니까?"))){
			update.submit();
	}
	}
}

function showCallRecordDetail(input){	
	var employeeNo = input.nextSibling.nextSibling.value;
	var recordNo = input.nextSibling.nextSibling.nextSibling.nextSibling.value;
	window.open("/CallRecordDetail?employeeNo="+employeeNo+"&&recordNo="+recordNo,
			"basic", "width=700, height=300, toolbar=no, location=no",false);
}

function closePopup(){
	window.close();
}

function getFileName(input){
	var filePath = input.value;
	var fileName = filePath.substring(filePath.lastIndexOf("\\")+1);	
	
	var result = document.getElementById("fileName");
	
	result.value = fileName;
}

function startDownload(input){
	input.parentNode.submit();
}

function exel(input){
	document.getElementById("excelForm").submit();
}

function deleterecord(input){

	if(confirm("삭제하시겠습니까?")){
	input.parentNode.submit();
	}	
}

function employeeCreate(input){
	var name=document.getElementById("name").value;
	var phone=document.getElementById("phone").value;
	var startDate1=document.getElementById("startDate1").value;
	var startDate2=document.getElementById("startDate2").value;
	if(name==""){
		alert("이름을 입력해주세요.");
		return;
	}else if(phone==""){
		alert("연락처를 입력해주세요.");
		return;
	}else if(startDate1==""){
		alert("경력시작년월을 입력해주세요.");
		return;
	}else if(startDate2==""){
		alert("경력시작년월을 입력해주세요.");
		return;
	}else{
		document.getElementById("employeeForm").submit();
	}
	
}

function deleteFile(input){
	if(confirm("파일을 삭제하시겠습니까?")){
		input.parentNode.submit();
	}
}

function deleteBoard(input){
	if(confirm("글을 삭제하시겠습니까?")){
		input.parentNode.submit();
	}
}