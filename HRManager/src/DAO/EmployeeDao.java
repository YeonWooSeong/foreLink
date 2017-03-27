package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ENTITY.EmployeeEntity;
import javafx.scene.control.Alert;

public class EmployeeDao {
	public ArrayList<EmployeeEntity> getAllEmployee(Connection con){	//���� ��ü �ҷ����� �޼ҵ�
		ArrayList<EmployeeEntity> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			String sql = "select no,"
					+ " name,"
					+ " sex,"
					+ " phone,"
					+ " email," // �̸��� �߰�
					+ " birth,"
					+ " license,"
					+ " address,"
					+ " education,"
					+ " graduatedate,"
					+ " skill,"
					+ " job,"
					+ " grade,"
					+ " totalCareer,"
					+ " availdate, "
					+ " comment, "
					+ " description, "
					+ " startdate, "
					+ " blankPeriod"
					+ " from employee order by availDate desc";  
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<EmployeeEntity>();
			
			
			while(rs.next()){
				EmployeeEntity entity = new EmployeeEntity();
				
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String phone = rs.getString("phone");
				//�̸��� �߰�
				String email = rs.getString("email");
				String birth = rs.getString("birth");
				String license = rs.getString("license");
				String address = rs.getString("address");
				String education = rs.getString("education");
				String graduateDate = rs.getString("graduatedate");
				String skill = rs.getString("skill");
				String job = rs.getString("job");
				String grade = rs.getString("grade");
				String totalCareer = rs.getString("totalCareer");
				String availdate = rs.getString("availdate");
				String comment = rs.getString("comment");
				String description = rs.getString("description");
				String startdate=rs.getString("startdate");
				String blankPeriod=rs.getString("blankPeriod");
				
				entity.setNo(no);
				entity.setName(name);
				entity.setSex(sex);
				entity.setPhone(phone);
				//�̸��� �߰�
				entity.setEmail(email);
				entity.setBirth(birth);
				entity.setLicense(license);
				entity.setAddress(address);
				entity.setEducation(education);
				entity.setGraduateDate(graduateDate);
				entity.setAvaildate(availdate);
				entity.setSkill(skill);
				entity.setJob(job);				
				entity.setGrade(grade);
				entity.setTotalCareer(totalCareer);
				entity.setdescription(description);
				entity.setComment(comment);
				entity.setStartdate(startdate);
				entity.setBlankPeriod(blankPeriod);
				list.add(entity);
			}
			
		}catch(SQLException e){
			System.out.println("EmployeeDAO - getAllEmployee : " +e.getMessage());
			
		}
		
		return list;
	}
	
	public EmployeeEntity employeeDetail(Connection con, int number){		//DB ������ ��ȣ�� �������� �� ���� �ҷ����� �޼ҵ�
		EmployeeEntity entity = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			String sql = "select * from employee where no = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, number);
			
			rs = pstmt.executeQuery();
			
			entity = new EmployeeEntity();
			
			
			while(rs.next()){
				
				String name = rs.getString("name");
				String grade = rs.getString("grade");
				String sex = rs.getString("sex");
				String birth = rs.getString("birth");
				String phone = rs.getString("phone");
				// �̸��� �߰�
				String email = rs.getString("email");
				String address = rs.getString("address");
				String skill = rs.getString("skill");
				String job = rs.getString("job");
				String education = rs.getString("education");
				String graduateDate = rs.getString("graduatedate");
				String license = rs.getString("license");
				String blankPeriod = rs.getString("blankPeriod");
				String totalCareer = rs.getString("totalCareer");
				String comment = rs.getString("comment");
				String description = rs.getString("description");
				String startdate=rs.getString("startdate");
				String availdate=rs.getString("availdate");

				int no=rs.getInt("no");
				
				
				entity.setAddress(address);
				entity.setBirth(birth);
				entity.setEducation(education);
				entity.setBlankPeriod(blankPeriod);
				entity.setTotalCareer(totalCareer);
				entity.setGrade(grade);
				entity.setGraduateDate(graduateDate);
				entity.setJob(job);
				entity.setLicense(license);
				entity.setName(name);
				entity.setPhone(phone);
				// �̸��� �߰�
				entity.setEmail(email);
				entity.setSex(sex);
				entity.setSkill(skill);
				entity.setNo(no);
				entity.setComment(comment);
				entity.setdescription(description);
				entity.setStartdate(startdate);
				entity.setAvaildate(availdate);
			}
			
		}catch(SQLException e){
			System.out.println("EmployeeDAO - employeeDetail : " + e.getMessage());
		}
		
		return entity;
	}
	
	public ArrayList<EmployeeEntity> searchEmployee(Connection con, EmployeeEntity key){	
		ArrayList<EmployeeEntity> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			String sql = "";
			/*String sql = "select * from employee where 1=1 ";*/
			String sql2="";
			if(!((key.getName()==null)||("".equals(key.getName())))){
				sql2+="and name like '%" + key.getName() +"%' ";
			}
			if(!((key.getGrade()==null)||("".equals(key.getGrade())))){
				sql2+="and grade like '%" + key.getGrade() +"%' ";
	}
			if(!((key.getSkill()==null)||("".equals(key.getSkill())))){
				sql2+="and skill like '%" + key.getSkill() +"%' ";
	}
			if(!((key.getJob()==null)||("".equals(key.getJob())))){
				sql2+="and job like '%" + key.getJob() +"%' ";
	}
			
			String sql3=" order by no desc";

			sql+=sql2;
			sql+=sql3;
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<EmployeeEntity>();
			
			while(rs.next()){
				EmployeeEntity entity = new EmployeeEntity();
				
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String grade = rs.getString("grade");
				String sex = rs.getString("sex");
				String birth = rs.getString("birth");
				String phone = rs.getString("phone");
				// �̸��� �߰�
				String email = rs.getString("email");
			
				String address = rs.getString("address");
				String skill = rs.getString("skill");
				String job = rs.getString("job");
				String license = rs.getString("license");
				String education = rs.getString("education");
				String graduateDate = rs.getString("graduatedate");	
				String availDate = rs.getString("availDate");
				String totalCareer = rs.getString("totalCareer");
				String comment = rs.getString("comment");
				String description = rs.getString("description");
				
				entity.setNo(no);
				entity.setName(name);
				entity.setGrade(grade);
				entity.setSex(sex);
				entity.setBirth(birth);
				entity.setPhone(phone);
				// �̸��� �߰�
				entity.setEmail(email);
				entity.setAddress(address);
				entity.setSkill(skill);
				entity.setJob(job);
				entity.setLicense(license);
				entity.setEducation(education);
				entity.setGraduateDate(graduateDate);
				entity.setAvaildate(availDate);
				entity.setTotalCareer(totalCareer);
				entity.setComment(comment);
				entity.setdescription(description);
				
				list.add(entity);
			}
			
		}catch(SQLException e){
			System.out.println("EmployeeDAO - searchResultEmployee : " + e.getMessage());
			System.out.println("chk");
		}
		
		return list;
	}

	
	public void insertEmployee(Connection con , EmployeeEntity entity) {	//���� �߰� �޼ҵ�
		PreparedStatement pstmt = null;
		
		try{
			String sql = "insert into employee(name,sex,phone,"
					+ "birth,license,address,education,graduatedate,"
					+ "skill,job,grade,blankPeriod,totalCareer,description,comment,availdate,startdate,email)"
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					/*+ "'"+ entity.getName() +"',"
					+ "'"+ entity.getGrade() + "',"
					+ "'"+ entity.getSex() + "',"
					+ ""+ entity.getBirth() + ","
					+ "'"+ entity.getPhone() + "',"
					+ "'"+ entity.getAddress() + "',"
					+ "'"+ entity.getSkill() + "',"
					+ "'"+ entity.getJob() + "',"
					+ ""+ entity.getAvailDate() + ","
					+ "'"+ entity.getEducation() +"',"
					+ ""+ entity.getGraduateDate() +","
					+ "'"+ entity.getExperience() + "',"
					+ "'"+ entity.getLicense() + "')";
			*/
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, entity.getName());
			pstmt.setString(2, entity.getSex());
			pstmt.setString(3, entity.getPhone());
			pstmt.setString(4, entity.getBirth());
			pstmt.setString(5, entity.getLicense());
			pstmt.setString(6, entity.getAddress());
			pstmt.setString(7, entity.getEducation());
			pstmt.setString(8, entity.getGraduateDate());
			pstmt.setString(9, entity.getSkill());
			pstmt.setString(10, entity.getJob());
			pstmt.setString(11, entity.getGrade());
			pstmt.setString(12, entity.getBlankPeriod());
			pstmt.setString(13, entity.getTotalCareer());
			pstmt.setString(14, entity.getdescription());
			pstmt.setString(15, entity.getComment());
			pstmt.setString(16, entity.getAvaildate());
			pstmt.setString(17, entity.getStartdate());
			// �̸��� �߰�
			pstmt.setString(18, entity.getEmail());
			
			int result = 0;
			
			result = pstmt.executeUpdate();
			
			if(result == 0){
				throw new SQLException("Insert error");
			}
			
			
			
		}catch(SQLException e){
			System.out.println("EmployeeDAO - insertEmployee : " + e.getMessage());
		}
	}
	
	public void UpdateEmployee(Connection con, EmployeeEntity entity) throws SQLException{	//���� ������Ʈ �޼ҵ�
		PreparedStatement pstmt = null;

		try{
			String sql ="update employee set "
					+ " name = ?,"
					+ " sex = ?,"
					+ " phone = ?,"
					+ " birth = ?,"
					+ " license = ?,"
					+ " address = ?,"
					+ " education = ?,"
					+ " graduatedate = ?,"
					+ " skill = ?,"
					+ " job = ?,"
					+ " startdate = ?,"
					+ " grade = ?,"
					+ " blankPeriod = ?,"
					+ " totalCareer = ?,"
					+ " comment = ?,"
					+ " description = ?,"
					+ " availdate = ?,"
					+" email = ?"
					+ " where no = ?";  
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entity.getName());
			pstmt.setString(2, entity.getSex());
			pstmt.setString(3, entity.getPhone());
			pstmt.setString(4, entity.getBirth());
			pstmt.setString(5, entity.getLicense());
			pstmt.setString(6, entity.getAddress());
			pstmt.setString(7, entity.getEducation());
			pstmt.setString(8, entity.getGraduateDate());
			pstmt.setString(9, entity.getSkill());
			pstmt.setString(10, entity.getJob());
			pstmt.setString(11, entity.getStartdate());
			pstmt.setString(12, entity.getGrade());
			pstmt.setString(13, entity.getBlankPeriod());
			pstmt.setString(14, entity.getTotalCareer());
			pstmt.setString(15, entity.getComment());
			pstmt.setString(16, entity.getdescription());
			pstmt.setString(17, entity.getAvaildate());
			pstmt.setString(18, entity.getEmail());
			pstmt.setInt(19, entity.getNo());
			

			int result = pstmt.executeUpdate();
			if(result == 0 ){
				throw new SQLException("Update Error");
			}
			
		}catch(SQLException e){
			throw new SQLException("EmployeeDAO - UpdateEmployee : " + e.getMessage());
		}
		
	}
	
	public int getNo(Connection con, EmployeeEntity entity){
		int no = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			String sql = "select no from employee where "
					+ "name = ? and "
					+ "grade = ? and "
					+ "sex = ? and "
					+ "phone = ? and "
					+ "skill = ? and "
					+ "job = ? and "
					+ "education = ? and "
					+ "license = ? and totalCareer";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, entity.getName());
			pstmt.setString(2, entity.getGrade());
			pstmt.setString(3, entity.getSex());
			pstmt.setString(4, entity.getPhone());
			pstmt.setString(5, entity.getSkill());
			pstmt.setString(6, entity.getJob());
			pstmt.setString(7, entity.getEducation());
			pstmt.setString(8, entity.getLicense());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				no = rs.getInt("no");
			}
		}catch(SQLException e){
			System.out.println("EmployeeDao - getNo : " + e.getMessage());
		}
		
		return no;
	}
}
