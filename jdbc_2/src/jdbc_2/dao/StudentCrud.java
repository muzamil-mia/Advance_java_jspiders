package jdbc_2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;

import jdbc_2.dto.Student;

//database logic 5 steps
public class StudentCrud {
	
	public void createTable() {
		//Student student = new Student();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?createDatabaseIfNotExist=true","root","root");
			Statement s = con.createStatement();
			//ResultSet res = s.executeQuery();
			s.execute("create table if not exists student(id int primary key,"
					+ " name varchar(45), email varchar(45), phone bigint,"
					+ " pwd varchar(45), marks double)");
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("connection created successfully");
	}
	
	public void saveStudent(Student student) {
		//System.out.println(student);
		System.out.println(student.getEmail());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?)");
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.setLong(4, student.getPhone());
			ps.setString(5, student.getPwd());
			ps.setDouble(6, student.getMarks());
			ps.execute();
			System.out.println("student saved successfully");
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateStudent(Student student) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
			PreparedStatement ps = con.prepareStatement("update student set name = ? where id = ?");
			ps.setString(1, student.getName());
			ps.setInt(2, student.getId());
			ps.execute();
			System.out.println("update successfully");
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteStudent(Student student) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
			PreparedStatement ps = con.prepareStatement("delete from student where name = ?");
			System.out.println(student.getName());
			ps.setString(1, student.getName());
			ps.execute();
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fetchStudents() {
		ArrayList<Student> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
			PreparedStatement ps = con.prepareStatement("select * from student");
			ResultSet res = ps.executeQuery();
			System.out.println(res);
			while(res.next()) {
				Student student = new Student();
				//System.out.println(student);  //default values
				System.out.println();
//				System.out.println(res.getString(2));
//				System.out.println(res.getString(3));
//				System.out.println(res.getLong(4));
//				System.out.println(res.getString(5));
//				System.out.println(res.getDouble(6));
				student.setId(res.getInt(1));
		        student.setName(res.getString(2));
		        student.setEmail(res.getString(3));
		        student.setPhone(res.getLong(4));
		        student.setPwd(res.getString(5));
		        student.setMarks(res.getDouble(6));
		        //System.out.println(student);
		        list.add(student);
			}
			for(Student stu : list) {
				System.out.println(stu);
			}
			//System.out.println(list);
			res.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
