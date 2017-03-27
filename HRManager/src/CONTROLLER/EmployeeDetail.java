package CONTROLLER;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BIZ.CallRecordBiz;
import BIZ.EmployeeBiz;
import BIZ.FileBiz;
import ENTITY.CallRecordEntity;
import ENTITY.EmployeeEntity;
import ENTITY.FileEntity;


@WebServlet("/EmployeeDetail")
public class EmployeeDetail extends HttpServlet {		//클릭한 한명의 직원 정보 불러오기
	private static final long serialVersionUID = 1L;
       
   
    public EmployeeDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginInfo")==null || !session.getAttribute("loginInfo").equals("admin")){
			response.sendRedirect("index.jsp");
		}
		
		int number = 0;
		if(request.getParameter("entityNo") != null){
			number = Integer.parseInt(request.getParameter("entityNo"));
			
		}else{
			number = (int) request.getAttribute("number");
		}
		String[] educationArray={"","고졸","초대졸","대졸","석사","박사"};
		String[] skillArray={"","Java","Pro-C","Unix-C","C++"};
		String[] jobArray={"","통신","금융","공공","DBA","AA","DW","미들웨어"};
	
		try{
			EmployeeEntity entity = new EmployeeEntity();
			ArrayList<CallRecordEntity> list = new ArrayList<CallRecordEntity>(); 
			EmployeeBiz biz = new EmployeeBiz();
			CallRecordBiz cbiz = new CallRecordBiz(); 
			FileBiz fBiz = new FileBiz();
		
			entity = biz.employeeDetail(number);
			list = cbiz.getAllRecords(number);
			
			
			
			
			ArrayList<FileEntity> download = fBiz.fileDownLoadList(number);

			

			String skill=entity.getSkill();
			int skillCount=skill.split(",").length;
			String skill1="";
			String skill2="";
			String skill3="";
			String skill4="";
			int count=0;
			if(skillCount==1){
				skill1=skill.split(",")[0];
				for(int i=0;i<skillArray.length;i++){
					if(skill1.equals(skillArray[i])){
					count++;
					}
				}
				if(count!=1){
					
					skill4+=skill1;
					skill1="";					
				}
				count=0;
			}else if(skillCount==2){
				skill1=skill.split(",")[0];
				skill2=skill.split(",")[1];
				for(int i=0;i<skillArray.length;i++){
					if(skill1.equals(skillArray[i])||skill2.equals(skillArray[i])){
					count++;
					}
				}
				if(count!=2){
					
					skill4+=skill2;
					skill2="";
					
				}
				count=0;
			}else if(skillCount==3){
				skill1=skill.split(",")[0];
				skill2=skill.split(",")[1];
				skill3=skill.split(",")[2];
				for(int i=0;i<skillArray.length;i++){
					if(skill1.equals(skillArray[i])||skill2.equals(skillArray[i])||skill3.equals(skillArray[i])){
						count++;
					}			
				}
					if(count!=3){
					
					skill4+=skill3;
					skill3="";
									}
					count=0;
			}else if(skillCount==4){
				skill1=skill.split(",")[0];
				skill2=skill.split(",")[1];
				skill3=skill.split(",")[2];
				skill4=skill.split(",")[3];
				count=0;
			}
			String job=entity.getJob();
			int jobCount=job.split(",").length;
			String job1="";
			String job2="";
			String job3="";
			String job4="";		

			if(jobCount==1){
				job1=job.split(",")[0];
				for(int i=0;i<jobArray.length;i++){
					if(job1.equals(jobArray[i])){
					count++;
					}
				}
				if(count!=1){
					
					job4+=job1;
					job1="";
				}
				count=0;
			}else if(jobCount==2){
				job1=job.split(",")[0];
				job2=job.split(",")[1];
				for(int i=0;i<jobArray.length;i++){
					if(job1.equals(jobArray[i])||job2.equals(jobArray[i])){
					count++;
					}
				}
				if(count!=2){
					
					job4+=job2;
					job2="";
					
				}
				count=0;
			}else if(jobCount==3){
				job1=job.split(",")[0];
				job2=job.split(",")[1];
				job3=job.split(",")[2];
				for(int i=0;i<jobArray.length;i++){
					if(job1.equals(jobArray[i])||job2.equals(jobArray[i])||job3.equals(jobArray[i])){
						count++;
					}			
				}
					if(count!=3){
					
						job4+=job3;
						job3="";
					
				}
					count=0;
			}else if(jobCount==4){
				job1=job.split(",")[0];
				job2=job.split(",")[1];
				job3=job.split(",")[2];
				job4=job.split(",")[3];
				count=0;
			}
			
			request.setAttribute("skill1", skill1);
			request.setAttribute("skill2", skill2);
			request.setAttribute("skill3", skill3);
			request.setAttribute("skill4", skill4);
			request.setAttribute("job1", job1);
			request.setAttribute("job2", job2);
			request.setAttribute("job3", job3);
			request.setAttribute("job4", job4);
			request.setAttribute("educationArray", educationArray);
			request.setAttribute("skillArray", skillArray);
			request.setAttribute("jobArray", jobArray);
			request.setAttribute("employee", entity);
			request.setAttribute("callRecordsList", list);
			request.setAttribute("number", number);
			request.setAttribute("downloadList", download);
			
		}catch(Exception e){
			System.out.println("Controller - EmployeeDetail : " + e.getMessage());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("employeeDetail.jsp");
		
		rd.forward(request, response);
		
	}

}
