package CONTROLLER;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import BIZ.CallRecordBiz;
import BIZ.EmployeeBiz;
import BIZ.FileBiz;
import ENTITY.CallRecordEntity;
import ENTITY.EmployeeEntity;
import ENTITY.FileEntity;

/**
 * Servlet implementation class EmployeeCreate
 */
@WebServlet("/EmployeeCreate")
public class EmployeeCreate extends HttpServlet {		//���ο� ���� �߰� ����
	private static final long serialVersionUID = 1L;
    
    public EmployeeCreate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
/*		
		if(session.getAttribute("loginInfo")==null || !session.getAttribute("loginInfo").equals("admin")){
			response.sendRedirect("index.jsp");
		}*/

		String encType = "UTF-8";
        int maxFilesize = 5 * 1024 * 1024;
		
        /*String root =  request.getSession().getServletContext().getRealPath("/");
        String pathname = root + "resume";*/
        String pathname = "/usr/local/tomcat7/webapps/resume";
        
		//������ ����
		
		File f = new File(pathname);
        if (!f.exists()) {
            // ������ �������� ������ ���� ����
            f.mkdirs();
            
        }
        
        
		MultipartRequest mr = new MultipartRequest(request, pathname, maxFilesize,
                encType, new DefaultFileRenamePolicy());
		

		String name 	= mr.getParameter("name");
		String sex 		= mr.getParameter("sex");
		String phone 	= mr.getParameter("phone");
		// �̸��� �߰�
		String email 	= mr.getParameter("email");
		String address	= mr.getParameter("address");
		String birth	= mr.getParameter("birth");
		String license	= mr.getParameter("license");
		String education= mr.getParameter("education");
		String graduateDate = mr.getParameter("graduateDate");
		
		String skill1	= mr.getParameter("skill1");
		String skill2	= mr.getParameter("skill2");
		String skill3	= mr.getParameter("skill3");
		String skill4	= mr.getParameter("skill4");
		String job1 		= mr.getParameter("job1");
		String job2 		= mr.getParameter("job2");
		String job3 		= mr.getParameter("job3");
		String job4 		= mr.getParameter("job4");
		String comment =mr.getParameter("comment");
		String description 	=mr.getParameter("description");
		String grade	= "";
		int startDate1=Integer.parseInt(mr.getParameter("startDate1"));
		int startDate2=Integer.parseInt(mr.getParameter("startDate2"));
		String startDate=startDate1+"�� "+startDate2+"��";

		int blankPeriod1=Integer.parseInt(mr.getParameter("blankPeriod1"));
		int blankPeriod2=Integer.parseInt(mr.getParameter("blankPeriod2"));
		String blankPeriod=blankPeriod1+"�� "+blankPeriod2+"����";
		
		

		String skill="";
		String job="";
		
		
		//������
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM"); 
		
		int sysdateYear=Integer.parseInt(sdf.format(dt).toString().split("-")[0]);
		int sysdateMonth=Integer.parseInt(sdf.format(dt).toString().split("-")[1]);
		
		//�Ѱ�°��
		int dateMonth=(sysdateYear*12+sysdateMonth)-((startDate1*12+startDate2)+(blankPeriod1*12+blankPeriod2));
		int careerYear=dateMonth/12;
		int careerMonth=dateMonth%12;
		
		String totalCareer=careerYear+"�� "+careerMonth+"����";
		
		//���
		if("����".equals(education)){
			if(careerYear<12){
				grade="�ʱ�";
			}else if(careerYear>=12&&careerYear<15){
				grade="�߱�";
			}else{
				grade="���";
			}
		}else if("�ʴ���".equals(education)){
			if(careerYear<9){
				grade="�ʱ�";
			}else if(careerYear>=9&&careerYear<12){
				grade="�߱�";
			}else if(careerYear>=12&&careerYear<15){
				grade="���";
			}else{
				grade="Ư��";
			}
		}else if("����".equals(education)){
			if(careerYear<6){
				grade="�ʱ�";
			}else if(careerYear>=6&&careerYear<9){
				grade="�߱�";
			}else if(careerYear>=9&&careerYear<12){
				grade="���";
			}else{
				grade="Ư��";
			}
		}else if("����".equals(education)){
			if(careerYear<3){
				grade="�ʱ�";
			}else if(careerYear>=3&&careerYear<6){
				grade="�߱�";
			}else if(careerYear>=6&&careerYear<9){
				grade="���";
			}else{
				grade="Ư��";
			}
		}else if("�ڻ�".equals(education)){
			if(careerYear<3){
				grade="���";
			}else{
				grade="Ư��";
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
		
		//��ȭ����
		
		String availDate =mr.getParameter("availDate");
		String callContents =mr.getParameter("callContents");
							
		try{
			EmployeeBiz biz = new EmployeeBiz();
			
			EmployeeEntity entity = new EmployeeEntity();
						
			entity.setName(name);
			entity.setSex(sex);
			entity.setPhone(phone);
			// �̸��� �߰�
			entity.setEmail(email);
			entity.setAddress(address);
			entity.setBirth(birth);
			entity.setLicense(license);
			entity.setEducation(education);
			entity.setGraduateDate(graduateDate);
			entity.setSkill(skill);
			entity.setJob(job);
			entity.setGrade(grade);
			entity.setTotalCareer(totalCareer);
			entity.setAvaildate(availDate);
			entity.setComment(comment);
			entity.setdescription(description);
			entity.setBlankPeriod(blankPeriod);
			entity.setStartdate(startDate);
			
			biz.insertEmployee(entity);
			
			int no = biz.getNo(entity);
			
			if(!("".equals(availDate)||availDate==null||"".equals(callContents)||callContents==null)){
			
			CallRecordBiz callBiz = new CallRecordBiz();
			CallRecordEntity entity2 = new CallRecordEntity();
			entity2.setNo(no);
			entity2.setCallAvailDate(availDate);
			entity2.setCallContents(callContents);
			
			callBiz.addRecords(entity2);
			}
			process(request,response,no,mr);
			
		}catch(Exception e){
			System.out.println("Controller - EmployeeCreate : " + e.getMessage());
		}
		response.sendRedirect("EmployeeList");
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
	            // ������ �������� ������ ���� ����
	            f.mkdirs();
	        }
	 
	        
	 
	        // MultipartRequest(request, ������[, �ִ����ũ��, ���ڵ��ɸ��ͼ�, ������ ���ϸ� ��ȣ ����])
	        
	 
	        File file1 = mr.getFile("fileAddress");
	        
	        String fileName = mr.getFilesystemName("fileAddress"); // ������ �̸� ���
						
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
