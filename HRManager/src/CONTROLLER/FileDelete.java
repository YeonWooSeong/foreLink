package CONTROLLER;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BIZ.FileBiz;

@WebServlet("/FileDelete")
public class FileDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FileDelete() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String fileName = request.getParameter("fileName");
		int number = Integer.parseInt(request.getParameter("employeeNo"));
		
		try{
			FileBiz fBiz = new FileBiz();
			
			int fileNo = fBiz.getFileNo(fileName);
			
			fBiz.deleteFile(fileNo);
			
			
			
		}catch(Exception e){
			System.out.println("Controller - FileDelete : " + e.getMessage());
		}
		
		request.setAttribute("number", number);
		response.sendRedirect("EmployeeDetail?entityNo="+number);
	}

}
