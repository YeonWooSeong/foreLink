package CONTROLLER;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sun.media.jfxmedia.logging.Logger;

import BIZ.EmployeeBiz;
import DAO.EmployeeDao;
import ENTITY.EmployeeEntity;

/**
 * Servlet implementation class loginForm
 */
@WebServlet("/loginForm")
public class loginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginForm() {
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
		
/*		HttpSession session = request.getSession();*/
		String encType = "UTF-8";
        int maxFilesize = 5 * 1024 * 1024;
        String pathname = "/usr/local/tomcat7/webapps/resume";
		
        MultipartRequest mr = new MultipartRequest(request, pathname, maxFilesize,
                encType, new DefaultFileRenamePolicy());
        
        String id =   mr.getParameter("id");
        String pass = mr.getParameter("pass");
		String name = mr.getParameter("name");
		try { 
			String idd = "";
			idd = id;
			EmployeeBiz biz = new EmployeeBiz();
			EmployeeEntity entity = new EmployeeEntity();
			entity = biz.checkJoin(idd);
			System.out.println("sql- id ="+id);
			System.out.println("sql- pass ="+pass);
			//--
			System.out.println("sql - name ="+name);
			System.out.println("sql - name2 = "+entity.getName());
			
			request.setAttribute("yourName",entity.getName());
			RequestDispatcher rd = request.getRequestDispatcher("employeeList.jsp");
			rd.forward(request, response);
			
			/*RequestDispatcher rd = request.getRequestDispatcher("employeeCreate.jsp");
			rd.forward(request, response);
			//Cannot forward after response has been committed redirect는 마지막에 써줘야함 순서중요*/
			
			System.out.println("success controller checking id and pass");
		} catch (Exception e) {
			System.out.println("controller - Join - [chk] :"+e.getMessage());
			response.sendRedirect("index.jsp");
		}
		
	}
	
			
}
