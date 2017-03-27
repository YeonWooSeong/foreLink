package CONTROLLER;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BIZ.CallRecordBiz;
import ENTITY.CallRecordEntity;

/**
 * Servlet implementation class CallRecordDetail
 */
@WebServlet("/CallRecordDetail")
public class CallRecordDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallRecordDetail() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginInfo")==null || !session.getAttribute("loginInfo").equals("admin")){
			response.sendRedirect("index.jsp");
		}
		
		int employeeNo=Integer.parseInt(request.getParameter("employeeNo"));
		int recordNo=Integer.parseInt(request.getParameter("recordNo"));
		try {
			CallRecordBiz biz= new CallRecordBiz();
			CallRecordEntity entity=new CallRecordEntity();
			CallRecordEntity record=null;
			entity.setNo(employeeNo);
			entity.setRecordNo(recordNo);
			record=biz.recordDetail(entity);
			
			request.setAttribute("record", record);
			
			
			
		}catch(Exception e){
			System.out.println("Controller - CallRecordDetail : " + e.getMessage());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("callRecordDetail.jsp");
		
		rd.forward(request, response);
		
	}

}
