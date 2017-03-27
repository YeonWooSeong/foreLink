package CONTROLLER;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BIZ.CallRecordBiz;
import ENTITY.CallRecordEntity;

/**
 * Servlet implementation class CallRecordDelete
 */
@WebServlet("/CallRecordDelete")
public class CallRecordDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallRecordDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int number=Integer.parseInt(request.getParameter("employeeNo"));
		int recordNo=Integer.parseInt(request.getParameter("recordNo"));
	
		CallRecordBiz biz=new CallRecordBiz();
		CallRecordEntity entity= new CallRecordEntity();
		
		entity.setNo(number);
		entity.setRecordNo(recordNo);
		try {
			biz.recordDelete(entity);
		}catch(Exception e){
			System.out.println("Controller - CallRecordDelete : " + e.getMessage());
		}
		request.setAttribute("number", number);
		response.sendRedirect("EmployeeDetail?entityNo="+number);
		
	}

}
