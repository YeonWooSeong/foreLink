package UTILITY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc {
	
	public static Connection connection() throws ClassNotFoundException{		//mysql ���� Connection ��ü ����
		Connection con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");						  //employee_manager
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useSSL=false","root","forelink1");
		}catch(SQLException e){
			System.out.println("SQLException : " + e.getMessage());
			System.out.println("SQLState : " + e.getSQLState());
		}
		
		return con;
	}
}
