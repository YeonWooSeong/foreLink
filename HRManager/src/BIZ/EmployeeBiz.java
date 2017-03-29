package BIZ;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.EmployeeDao;
import ENTITY.EmployeeEntity;
import ENTITY.EmployeeLogin;
import UTILITY.jdbc;

public class EmployeeBiz {
	public ArrayList<EmployeeEntity> getAllEmployee() throws SQLException, ClassNotFoundException{
		Connection con = jdbc.connection();
		ArrayList<EmployeeEntity> list = null;
		
		try{
			list = new ArrayList<EmployeeEntity>();
			
			EmployeeDao dao = new EmployeeDao();
			
			list = dao.getAllEmployee(con);
			
			
		}catch(Exception e){
			System.out.println("EmployeeBiz - getAllEmployee : " + e.getMessage());
		}finally{
			con.close();
		}
		
		return list;
	}
	
	public ArrayList<EmployeeEntity> searchEmployee(EmployeeEntity entity) throws SQLException, ClassNotFoundException{
		Connection con = jdbc.connection();
		ArrayList<EmployeeEntity> list = null;
		
		try{
			list = new ArrayList<EmployeeEntity>();
			
			EmployeeDao dao = new EmployeeDao();
			
			list = dao.searchEmployee(con, entity);
			
			
		}catch(Exception e){
			System.out.println("EmployeeBiz - searchEmployee : " + e.getMessage());
		}finally{
			con.close();
		}
		
		return list;
	}
	
	public void joinEmployee(EmployeeLogin entity) throws SQLException, ClassNotFoundException{
		Connection con = jdbc.connection();
		
		try{
				
			EmployeeDao dao = new EmployeeDao();
			
			dao.joinEmployee(con, entity);
			System.out.println("EmployeeBiz - insertEmployee : success");
		}catch(Exception e){
			con.rollback();
			System.out.println("EmployeeBiz - insertEmployee : " + e.getMessage());
		}finally{
			con.close();
		}
		
	}
	
	/**/
	public void boardDelete(EmployeeEntity entity ) throws ClassNotFoundException, SQLException{
		Connection con = jdbc.connection();
		
		try{
			System.out.println("delete board - s");
			EmployeeDao dao = new EmployeeDao();
			dao.boardDelete(con, entity);
		}catch(Exception e){
			con.rollback();
			System.out.println("CallRecordBiz - recordDelete : " + e.getMessage());
		}finally{
			con.close();
		}
	}
	
	
	
	public EmployeeLogin checkJoin(String idd) throws SQLException, ClassNotFoundException{
		Connection con = jdbc.connection();
		EmployeeLogin entity = null;
		try{
			EmployeeDao dao = new EmployeeDao();
			entity = dao.checkJoin(con, idd);
		}catch(Exception e){
			con.rollback();
			System.out.println("EmployeeBiz - insertEmployee  - chk join: " + e.getMessage());
		}finally{
			con.close();
		}
		return entity;
		
	}
	
	
	public void insertEmployee(EmployeeEntity entity) throws SQLException, ClassNotFoundException{
		Connection con = jdbc.connection();
		
		try{
				
			EmployeeDao dao = new EmployeeDao();
			
			dao.insertEmployee(con, entity);
			
		}catch(Exception e){
			con.rollback();
			System.out.println("EmployeeBiz - insertEmployee : " + e.getMessage());
		}finally{
			con.close();
		}
		
	}
	
	public EmployeeEntity employeeDetail(int number) throws SQLException, ClassNotFoundException{
		Connection con = jdbc.connection();
		
		EmployeeEntity entity = null;
		
		try{
				
			EmployeeDao dao = new EmployeeDao();
			
			entity = dao.employeeDetail(con, number);
			
		}catch(Exception e){
			System.out.println("EmployeeBiz - employeeDetail : " + e.getMessage());
		}finally{
			con.close();
		}
		
		return entity;
	}
	
	public void UpdateEmployee(EmployeeEntity entity) throws ClassNotFoundException, SQLException{
		Connection con = jdbc.connection();
		try{
			EmployeeDao dao = new EmployeeDao();
			dao.UpdateEmployee(con, entity);
		}catch(Exception e){
			//con.rollback();
			System.out.println("EmployeeBiz - UpdateEmployee : " + e.getMessage());
		}finally{
			
			con.close();
		}
	}
	
	public int getNo(EmployeeEntity entity) throws ClassNotFoundException, SQLException{
		Connection con = jdbc.connection();
		int no = 0;
		try{
			EmployeeDao dao = new EmployeeDao();
			
			no = dao.getNo(con, entity);
		}catch(Exception e){
			System.out.println("EmplyeeBiz - getNo : " + e.getMessage());
		}finally{
			con.close();
		}
		
		return no;
	}
}
