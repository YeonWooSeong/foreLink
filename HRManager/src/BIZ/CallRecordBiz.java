package BIZ;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.CallRecordDao;
import ENTITY.CallRecordEntity;
import UTILITY.jdbc;

public class CallRecordBiz {
	public ArrayList<CallRecordEntity> getAllRecords(int number) throws ClassNotFoundException, SQLException{
		Connection con = jdbc.connection();
		
		ArrayList<CallRecordEntity> list = null;
		
		try{
				
			CallRecordDao dao = new CallRecordDao();
			
			list = dao.getAllRecords(con, number);
			
		}catch(Exception e){
			System.out.println("CallRecordBiz - getAllRecords : " + e.getMessage());
		}finally{
			con.close();
		}
		
		return list;
	}
	
	public void addRecords(CallRecordEntity entity) throws ClassNotFoundException, SQLException{
		Connection con = jdbc.connection();
		
		try{
				
			CallRecordDao dao = new CallRecordDao();
			
			dao.addRecords(con, entity);
			
		}catch(Exception e){
			con.rollback();
			System.out.println("CallRecordBiz - getAddRecords : " + e.getMessage());
		}finally{
			con.close();
		}
	}
	
	public CallRecordEntity recordDetail(CallRecordEntity entity) throws ClassNotFoundException, SQLException{
		Connection con = jdbc.connection();
		CallRecordEntity list= null;
		
		try{
			CallRecordDao dao = new CallRecordDao();
			
			list=dao.recordDetail(con, entity);
				
		}catch(Exception e){
			con.rollback();
			System.out.println("CallRecordBiz - getRecordDetail : " + e.getMessage());
		}finally{
			con.close();
		}
		
		
		return list;
	}
	public void recordDelete(CallRecordEntity entity ) throws ClassNotFoundException, SQLException{
		Connection con = jdbc.connection();
		
		try{
			
			CallRecordDao dao = new CallRecordDao();
			
			dao.recordDelete(con, entity);
			
		}catch(Exception e){
			con.rollback();
			System.out.println("CallRecordBiz - recordDelete : " + e.getMessage());
		}finally{
			con.close();
		}
	}
}
