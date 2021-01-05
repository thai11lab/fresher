package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import datasource.MySqlConnector;
import model.Student;

public class StudentService {
	
	public List<Student> getStudent() {
		//Khởi tạo kết nối với database;
		List<Student> listST= new ArrayList<Student>();
		Connection connection = MySqlConnector.getConnection();		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String sql ="SELECT  *FROM baitap.student";
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) { 
				Long id = result.getLong("id");
				String name = result.getString("name");
				String adrress = result.getString("address");
				String email = result.getString("email");
				Student student = new Student(id, name, adrress,email);
				listST.add(student);
			}
			connection.close();
			statement.close();
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listST;
	}
	
	
	public void insertStudent(Student student) {
		Connection connection = MySqlConnector.getConnection();
		PreparedStatement statement = null;
		String sql="INSERT INTO baitap.student(id,name,address,email) VALUES(?,?,?,?)";
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1,student.getId());
			statement.setString(2, student.getName());
			statement.setString(3, student.getAdrress());
			statement.setString(4, student.getEmail());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateStudent(Student student,String email) {
		Connection connection = MySqlConnector.getConnection();
		PreparedStatement statement = null;
		Student student2 = findByEmail(email);
		System.out.println("-----------"+student.getName()+"------------");
		String sql="UPDATE baitap.student SET name=?,address=? WHERE email = ? ";	
		try {
			statement = connection.prepareStatement(sql);			
			if(student.getName().equals("")) {
				statement.setString(1,student2.getName());
			}else {
				statement.setString(1, student.getName());
			}
			if(student.getAdrress().equals("")) {
				statement.setString(2, student2.getAdrress());
			}else {
				statement.setString(2, student.getAdrress());
			}			
			statement.setString(3,email);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public Student findByEmail(String emailR) {
		Student student = new Student();
		Connection connection = MySqlConnector.getConnection();		
		PreparedStatement statement = null;		
		String sql ="SELECT  *FROM baitap.student WHERE email = '"+emailR+"'";
		try {
			statement = connection.prepareStatement(sql);			
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) { 
				Long id = result.getLong("id");
				String name = result.getString("name");
				String adrress = result.getString("address");
				String email = result.getString("email");
				student = new Student(id, name, adrress,email);			
			}
			connection.close();
			statement.close();
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
}
