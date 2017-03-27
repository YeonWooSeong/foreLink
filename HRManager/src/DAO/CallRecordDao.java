package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ENTITY.CallRecordEntity;

public class CallRecordDao {
	public ArrayList<CallRecordEntity> getAllRecords(Connection con,int number){	//해당 직원의 모든 통화기록을 불러오는 메소드
		ArrayList<CallRecordEntity> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			String sql = "select callDate,"
					+ "	callAvailDate,"
					+ " employee_no,"
					+ " record_no,"
					+ " callContents"
					+ " from "
					+ " call_records "
					+ " where employee_no = ? order by record_no desc "
					+ " limit 10";
						
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, number);
			
			rs = pstmt.executeQuery();
				
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			list = new ArrayList<CallRecordEntity>();
			
			while(rs.next()){
				CallRecordEntity entity = new CallRecordEntity();
				
				Date callDate = rs.getDate("callDate");
				int employeeNo=rs.getInt("employee_no");
				int recordNo=rs.getInt("record_no");
				String callContents = rs.getString("callContents");
				String callTitle="";
				if(callContents.length()>20){
					callTitle+=callContents.substring(0, 20)+"...";
				}else{
					callTitle+=callContents;
				}
				String callAvailDate = rs.getString("callAvailDate");
				
				entity.setCallAvailDate(callAvailDate);
				entity.setNo(employeeNo);
				entity.setRecordNo(recordNo);
				entity.setCallDate(transFormat.format(callDate));
				entity.setCallContents(callTitle);
				
				list.add(entity);
			}
			
		}catch(SQLException e){
			System.out.println("CallRecordDAO - getAllRecords : " + e.getMessage());
		}
		
		return list;
	}
	
	public void addRecords(Connection con, CallRecordEntity entity){	//통화내역 추가 메소드
		PreparedStatement pstmt = null;
		
		try{
			String sql="insert into call_records(callDate,callContents,callAvailDate,employee_no)"
					+ " values("
					+ "SYSDATE(),?,?,?)";
					/*+ "'"+ entity.getCallContents() +"',"
					+ "'"+ entity.getCallTitle() +"',"
					+ "'"+ entity.getCallAvailDate() + "',"
					+ "'"+ entity.getNo() + "')";*/
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entity.getCallContents());
			pstmt.setString(2, entity.getCallAvailDate());
			pstmt.setInt(3, entity.getNo());
			
			int result = pstmt.executeUpdate();			
			
			if(result== 0){
				throw new SQLException();
			}
			
		}catch(SQLException e){
			System.out.println("CallRecordDAO - addRecords : " + e.getMessage());
		}
	}
	
	public CallRecordEntity recordDetail(Connection con,CallRecordEntity entity){
		CallRecordEntity list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			String sql = "select callDate,"
					+ "	callAvailDate,"
					+ "	callContents from "
					+ " call_records "
					+ " where employee_no = ? and record_no = ?";
					
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, entity.getNo());
			pstmt.setInt(2, entity.getRecordNo());
					
			rs = pstmt.executeQuery();
				
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			
			if(rs.next()){
				list= new CallRecordEntity();
				Date callDate = rs.getDate("callDate");
				String callContents = rs.getString("callContents");
				String callAvailDate = rs.getString("callAvailDate");
				
				list.setCallAvailDate(callAvailDate);
				list.setCallDate(transFormat.format(callDate));
				list.setCallContents(callContents);
				
			}
			
		}catch(SQLException e){
			System.out.println("CallRecordDAO - getAllRecords : " + e.getMessage());
		}
		
		return list;
	}	
	
	public void recordDelete(Connection con,CallRecordEntity entity){
		PreparedStatement pstmt = null;
		
		try{
			String sql = "delete from call_records where employee_no = ? and record_no = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, entity.getNo());
			pstmt.setInt(2, entity.getRecordNo());
					
			int result = pstmt.executeUpdate();			
			
			if(result == 0){
				throw new SQLException();
			}
			
		}catch(SQLException e){
			System.out.println("CallRecordDAO - recordDelete : " + e.getMessage());
			
		}
	
	}
}
