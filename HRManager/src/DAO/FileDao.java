package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ENTITY.FileEntity;

public class FileDao {
	public void fileUpload(Connection con,FileEntity entity){
		PreparedStatement pstmt = null;
		
		
		try{
			String sql = "insert into file(employeeNo, fileName, fileType, fileAddress) values(?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, entity.getEmployeeNo());
			pstmt.setString(2, entity.getFileName());
			pstmt.setString(3, entity.getFileType());
			pstmt.setString(4, entity.getFileAddress());
			
			int result = pstmt.executeUpdate();
			
			if(result == 0 ){
				throw new SQLException();
			}
		}catch(SQLException e){
			System.out.println("FileDao - fileUpload : " +e.getMessage());
		}
	}
	
	public ArrayList<FileEntity> fileDownLoadList(Connection con,int number){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FileEntity> list = null;
		
		try{
			String sql = "select fileName, fileType, fileAddress from file where employeeNo = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, number);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<FileEntity>();
				
			while(rs.next()){
				FileEntity entity = new FileEntity();
				
				String fileName = rs.getString("fileName");
				String fileType = rs.getString("fileType");
				String fileAddress = rs.getString("fileAddress");
				
				entity.setEmployeeNo(number);
				entity.setFileAddress(fileAddress);
				entity.setFileName(fileName);
				entity.setFileType(fileType);
				
				System.out.println(fileName);
				
				list.add(entity);
			}
		}catch(SQLException e){
			System.out.println("FileDao - downLoad : " + e.getMessage());
		}
		
		return list;
	}
	
	public int getFileNo(Connection con, String fileName){
		int no = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			
			String sql = "select fileNo from file where fileName = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, fileName);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				no = rs.getInt("fileNo");
			}
			
		}catch(SQLException e){
			System.out.println("FileDao - getFileNo : " + e.getMessage());
		}
		
		return no;
	}
	
	public void deleteFile(Connection con, int number){
		PreparedStatement pstmt = null;
		
		try{
			String sql = "delete from file where fileNo = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, number);
			
			int result = pstmt.executeUpdate();
			
			if(result == 0){
				throw new SQLException("fileDelete failed");
			}
		}catch(SQLException e){
			System.out.println("FileDao - deleteFile : " + e.getMessage());
		}
	}
}
