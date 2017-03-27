package BIZ;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.FileDao;
import ENTITY.FileEntity;
import UTILITY.jdbc;


public class FileBiz {
	public void fileUpload(FileEntity entity) throws SQLException, ClassNotFoundException{
		Connection con = jdbc.connection();
		
		try{
			FileDao dao = new FileDao();
			
			dao.fileUpload(con, entity);
			
		}catch(Exception e){
			con.rollback();
			System.out.println("FileBiz - fileUpload : " + e.getMessage());
		}finally{
			con.close();
		}
	}
	
	public ArrayList<FileEntity> fileDownLoadList(int number) throws ClassNotFoundException, SQLException{
		Connection con = jdbc.connection();
		ArrayList<FileEntity> list = null;
		
		try{
			FileDao dao = new FileDao();
			
			list = dao.fileDownLoadList(con, number);
		}catch(Exception e){
			System.out.println("FileBiz - fileDownLoad : " + e.getMessage());
		}finally{
			con.close();
		}
		
		return list;
	}
	
	public int getFileNo(String fileName) throws SQLException, ClassNotFoundException{
		Connection con = jdbc.connection();
		int no = 0;
		
		try{
			FileDao dao = new FileDao();
			
			no = dao.getFileNo(con, fileName);
		}catch(Exception e){
			System.out.println("FileBiz - fileDownLoad : " + e.getMessage());
		}finally{
			con.close();
		}
		
		return no;
	}
	
	public void deleteFile(int number) throws ClassNotFoundException, SQLException{
		Connection con = jdbc.connection();
		
		try{
			FileDao dao = new FileDao();
			
			dao.deleteFile(con, number);
		}catch(Exception e){
			System.out.println("FileBiz - fileDelete : " + e.getMessage());
		}finally{
			con.close();
		}
	}
}
