package CONTROLLER;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import BIZ.CallRecordBiz;
import BIZ.EmployeeBiz;
import BIZ.FileBiz;
import ENTITY.CallRecordEntity;
import ENTITY.EmployeeEntity;
import ENTITY.FileEntity;

@WebServlet("/Update")
public class Update extends HttpServlet {		//회원정보 및 통화내역 동시에 수정
	private static final long serialVersionUID = 1L;
   
    public Update() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String encType = "UTF-8";
        int maxFilesize = 5 * 1024 * 1024;
		
        /*String root =  request.getSession().getServletContext().getRealPath("/");
        String pathname = root + "resume";*/
        String pathname = "/usr/local/tomcat7/webapps/resume";
        
		MultipartRequest mr = new MultipartRequest(request, pathname, maxFilesize,
                encType, new DefaultFileRenamePolicy());
		
		String callContents = mr.getParameter("callContents");
		String callAvailDate = mr.getParameter("availDate");
		int no = Integer.parseInt(mr.getParameter("number"));
		
		String name 	= mr.getParameter("name");
		String sex 		= mr.getParameter("sex");
		String phone 	= mr.getParameter("phone");
		
		// 이메일 추가
		String email = mr.getParameter("email");
		
		String address	= mr.getParameter("address");
		String birth	= mr.getParameter("birth");
		String license	= mr.getParameter("license");
		String education= mr.getParameter("education");
		String graduateDate = mr.getParameter("graduateDate");
		String availDate= mr.getParameter("availDate");
		String comment =mr.getParameter("comment");
		String description=mr.getParameter("description");
		
		String skill1	= mr.getParameter("skill1");
		String skill2	= mr.getParameter("skill2");
		String skill3	= mr.getParameter("skill3");
		String skill4	= mr.getParameter("skill4");
		String job1 		= mr.getParameter("job1");
		String job2 		= mr.getParameter("job2");
		String job3 		= mr.getParameter("job3");
		String job4 		= mr.getParameter("job4");
		
		String grade	= "";
		int startDate1=Integer.parseInt(mr.getParameter("startDate1"));
		int startDate2=Integer.parseInt(mr.getParameter("startDate2"));
		String startDate=startDate1+"년 "+startDate2+"월";

		int blankPeriod1=Integer.parseInt(mr.getParameter("blankPeriod1"));
		int blankPeriod2=Integer.parseInt(mr.getParameter("blankPeriod2"));
		String blankPeriod=blankPeriod1+"년 "+blankPeriod2+"개월";
		
		

		String skill="";
		String job="";
		
		
		//현재년월
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM"); 
		
		int sysdateYear=Integer.parseInt(sdf.format(dt).toString().split("-")[0]);
		int sysdateMonth=Integer.parseInt(sdf.format(dt).toString().split("-")[1]);
		
		//총경력계산
		int dateMonth=(sysdateYear*12+sysdateMonth)-((startDate1*12+startDate2)+(blankPeriod1*12+blankPeriod2));
		int careerYear=dateMonth/12;
		int careerMonth=dateMonth%12;
		
		String totalCareer=careerYear+"년 "+careerMonth+"개월";
		
		//등급
		if("고졸".equals(education)){
			if(careerYear<12){
				grade="초급";
			}else if(careerYear>=12&&careerYear<15){
				grade="중급";
			}else{
				grade="고급";
			}
		}else if("초대졸".equals(education)){
			if(careerYear<9){
				grade="초급";
			}else if(careerYear>=9&&careerYear<12){
				grade="중급";
			}else if(careerYear>=12&&careerYear<15){
				grade="고급";
			}else{
				grade="특급";
			}
		}else if("대졸".equals(education)){
			if(careerYear<6){
				grade="초급";
			}else if(careerYear>=6&&careerYear<9){
				grade="중급";
			}else if(careerYear>=9&&careerYear<12){
				grade="고급";
			}else{
				grade="특급";
			}
		}else if("석사".equals(education)){
			if(careerYear<3){
				grade="초급";
			}else if(careerYear>=3&&careerYear<6){
				grade="중급";
			}else if(careerYear>=6&&careerYear<9){
				grade="고급";
			}else{
				grade="특급";
			}
		}else if("박사".equals(education)){
			if(careerYear<3){
				grade="고급";
			}else{
				grade="특급";
			}
		}
		
		
		if(!(skill1==null||"".equals(skill1))){
			skill+=skill1;
		}
		
		if(!(skill2==null||"".equals(skill2))){
			if(!("".equals(skill1))){
				skill+=","+skill2;
			}else{
				skill+=skill2;
			}	
		}
		
		if(!(skill3==null||"".equals(skill3))){
			if("".equals(skill1)&&"".equals(skill2)){
				skill+=skill3;
				
			}else{
				skill+=","+skill3;
			}	
		}
		
		if(!(skill4==null||"".equals(skill4))){
			if("".equals(skill1)&&"".equals(skill2)&&"".equals(skill3)){
				skill+=skill4;
			}else{
				skill+=","+skill4;
			}	
		}
	
		
	

		if(!(job1==null||"".equals(job1))){
			job+=job1;
		}
		
		if(!(job2==null||"".equals(job2))){
			if(!("".equals(job1))){
				job+=","+job2;
			}else{
				job+=job2;
			}	
		}
		
		if(!(job3==null||"".equals(job3))){
			if("".equals(job1)&&"".equals(job2)){
				job+=job3;
			}else{
				job+=","+job3;
			}	
		}
		
		if(!(job4==null||"".equals(job4))){
			if("".equals(job1)&&"".equals(job2)&&"".equals(job3)){
				job+=job4;
			}else{
				job+=","+job4;
			}	
		}


		try{
			CallRecordBiz cbiz = new CallRecordBiz();
			CallRecordEntity entity = new CallRecordEntity();
			
			ArrayList<CallRecordEntity> list = new ArrayList<CallRecordEntity>(); 
			
			list = cbiz.getAllRecords(no);
			
			
			if(!"".equals(callContents)){
				entity.setCallAvailDate(callAvailDate);			
				entity.setCallContents(callContents);
				entity.setNo(no);
				cbiz.addRecords(entity);
			}
			EmployeeBiz ebiz = new EmployeeBiz();
			
			EmployeeEntity entity2 = new EmployeeEntity();
					
			entity2.setNo(no);
			entity2.setAddress(address);
			//이메일 추가 
			entity2.setEmail(email);
			
			entity2.setBirth(birth);
			entity2.setEducation(education);
			entity2.setGrade(grade);
			entity2.setGraduateDate(graduateDate);
			entity2.setJob(job);
			entity2.setLicense(license);
			entity2.setName(name);
			entity2.setPhone(phone);
			entity2.setSex(sex);
			entity2.setSkill(skill);
			entity2.setStartdate(startDate);
			entity2.setBlankPeriod(blankPeriod);
			entity2.setTotalCareer(totalCareer);
			
			System.out.println(availDate);
			
			entity2.setAvaildate(availDate);
			entity2.setComment(comment);
			entity2.setDescription(description);

			ebiz.UpdateEmployee(entity2);		
			request.setAttribute("number", no);			
			request.setAttribute("employee", entity2);
			request.setAttribute("callRecordsList", list);
			
			process(request,response,no,mr);
			
		}catch(Exception e){
			System.out.println("Controller Update : " + e.getMessage());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("EmployeeDetail");
		
		rd.forward(request, response);
		
	}
	
	protected void process(HttpServletRequest req, HttpServletResponse resp, int number, MultipartRequest mr)
            throws ServletException, IOException {
			
		 /*String root =  request.getSession().getServletContext().getRealPath("../");
        String pathname = root + "resume";*/
        String pathname = "/usr/local/tomcat7/webapps/resume";
		
		try{
			FileBiz fBiz = new FileBiz();
			FileEntity entity = new FileEntity();
			
			File f = new File(pathname);
	        if (!f.exists()) {
	            // 폴더가 존재하지 않으면 폴더 생성
	            f.mkdirs();
	        }
	 
	        
	 
	        // MultipartRequest(request, 저장경로[, 최대허용크기, 인코딩케릭터셋, 동일한 파일명 보호 여부])
	        
	 
	        File file1 = mr.getFile("fileAddress");
	        
	        String fileName = mr.getFilesystemName("fileAddress"); // 파일의 이름 얻기
			System.out.println(fileName);
						
	        int employeeNo = number;
	        String fileType = mr.getParameter("type");
	        	        
	        entity.setEmployeeNo(employeeNo);
	        entity.setFileName(fileName);
	        entity.setFileType(fileType);
	        entity.setFileAddress(file1.toString());
	        
	        fBiz.fileUpload(entity);
	        
		}catch(Exception e){
			System.out.println("Controller - FileUpload"+e.getMessage());
		}
         
        
    }

}
