package CONTROLLER;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import BIZ.EmployeeBiz;
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
		
		HttpSession session = request.getSession();
		String encType = "UTF-8";
        int maxFilesize = 5 * 1024 * 1024;
        String pathname = "/usr/local/tomcat7/webapps/resume";
		
        MultipartRequest mr = new MultipartRequest(request, pathname, maxFilesize,
                encType, new DefaultFileRenamePolicy());
        
        String id =   mr.getParameter("id");
		String pass = mr.getParameter("pass");
		
		System.out.println("view -> controller parameter id [chk]="+id);
		System.out.println("view -> controller parameter pass  [chk] ="+pass);
		
		
		try {
			EmployeeBiz biz = new EmployeeBiz();
			EmployeeEntity entity = new EmployeeEntity();
			
			entity.setId(id);
			entity.setPass(pass);
			System.out.println(" controller  id [chk]="+entity.getId());
			System.out.println(" controller  pass [chk] ="+entity.getPass());
			
			biz.joinEmployee(entity);
			response.sendRedirect("employeeList.jsp");
			System.out.println("success controller checking id and pass");
		} catch (Exception e) {
			System.out.println("controller - Join - [chk] :"+e.getMessage());	
		}
		
	}
	
			
}
