package CONTROLLER;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BIZ.EmployeeBiz;
import ENTITY.EmployeeEntity;

/**
 * Servlet implementation class ListDownLoad
 */
@WebServlet("/ListDownLoad")
public class ListDownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListDownLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
				ArrayList<EmployeeEntity> list = null;
		
		String name=request.getParameter("name");
		String job=request.getParameter("job");
		String grade=request.getParameter("grade");
		String skill=request.getParameter("skill");
		
		
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
						
			RequestDispatcher rd = request.getRequestDispatcher("exel.jsp");
			
			rd.forward(request, response);
		}catch(Exception e){
			System.out.println("Servlet - employeeList : " + e.getMessage());
		}
	}

}
