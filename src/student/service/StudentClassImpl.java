package student.service;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import student.model.Student;

public class StudentClassImpl implements StudentClass {
	List<Student> slist=new ArrayList<>();
	@Override
	public void addStudent(Student s)  {
		String url="jdbc:mysql://localhost:3306/sita";
		String user_name="root";
		String password="#mySQL123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user_name,password);
			String q="insert into students values(?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(q);
//			stmt.setInt(1,101);//1 specifies the first parameter in the query
			pstmt.setInt(1,s.getId());
			pstmt.setString(2,s.getFname());
			pstmt.setString(3, s.getLname());
			pstmt.setInt(4, s.getRoll());
			pstmt.setString(5, s.getFaculty());
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		connectDatabase(url, user_name, password, s);
//		slist.add(s);
	}

	@Override
	public void deletestudent(int ind) {
		// TODO Auto-generated method stub
//		slist.remove(ind);
		String url="jdbc:mysql://localhost:3306/sita";
		String user_name="root";
		String password="#mySQL123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user_name,password);
			
			String q="delete from students where id='"+ind+"'";
			
			Statement stmt=con.createStatement();
			stmt.execute(q);
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/sita";
		String user_name="root";
		String password="#mySQL123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user_name,password);
			
			String q="select * from students";
			Statement stmt=con.createStatement();
			ResultSet datas=stmt.executeQuery(q);
			//row mapping to object to create list of students
			while(datas.next()) {
				Student s=new Student();
				s.setId(datas.getInt("id"));
				s.setFname(datas.getString("Firstname"));
				s.setLname(datas.getString("lastname"));
				s.setRoll(datas.getInt("Rollnumber"));
				s.setFaculty(datas.getString("Faculty"));
				
				slist.add(s);
			}
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return slist;
	}
	

}
