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

import BIZ.EmployeeBiz;
import ENTITY.EmployeeEntity;


@WebServlet("/EmployeeList")
public class EmployeeList extends HttpServlet {		
	private static final long serialVersionUID = 1L;
       
  
    public EmployeeList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("start employeeList controller");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
			
		ArrayList<EmployeeEntity> list = null;
		
		String name=request.getParameter("name");
		String job=request.getParameter("job");
		String grade=request.getParameter("grade");
		String skill=request.getParameter("skill");
		
		HttpSession session = request.getSession();
	
		if(session.getAttribute("loginInfo")==null || !session.getAttribute("loginInfo").equals("admin")){
			response.sendRedirect("index.jsp");
		}
				
		try{
			EmployeeBiz biz = new EmployeeBiz();
			
			if(("".equals(name)||name==null)&&("".equals(job)||job==null)&&("".equals(grade)||grade==null)&&("".equals(skill)||skill==null)){
				list = biz.getAllEmployee();					
			}
			else{
				
				EmployeeEntity empEntity = new EmployeeEntity();
				
				empEntity.setName(name);
				empEntity.setJob(job);
				empEntity.setGrade(grade);
				empEntity.setSkill(skill);
				
				
				list = biz.searchEmployee(empEntity);
			}
			request.setAttribute("searchName",name);
			request.setAttribute("searchJob",job);
			request.setAttribute("searchGrade",grade);
			request.setAttribute("searchSkill",skill);
			request.setAttribute("employeeList", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("employeeList.jsp");
			
			rd.forward(request, response);
		}catch(Exception e){
			System.out.println("Servlet - employeeList : " + e.getMessage());
		}		
		
	}
}
