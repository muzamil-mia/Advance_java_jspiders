package jdbc_4_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jdbc_4_controller.StudentMain;
import jdbc_4_dto.Student;

public class StudentCrud {

	public void createBatch(List<Student> stu) {
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?)");
			for (Student student : stu) {
				ps.setInt(1, student.getId());
				ps.setString(2, student.getName());
				ps.setString(3, student.getEmail());
				ps.setLong(4, student.getPhone());
				ps.setString(5, student.getPwd());
				ps.setDouble(6, student.getMarks());
				ps.addBatch();
			}
			ps.executeBatch();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateStudent(List<Student> stu) {
		Connection con = DatabaseConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("update student set name = ? where id = ?");
			for (Student student : stu) {
				ps.setString(1, student.getName());
				ps.setInt(2, student.getId());
				ps.addBatch();
			}
			ps.executeBatch();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fetch() {
		Connection con = DatabaseConnection.getConnection();
		try {
			PreparedStatement ps =con.prepareStatement("select * from student");
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				System.out.print(res.getInt(1) + " " + res.getString(2) + " " + res.getString(3) + " " +  res.getLong(4) + " " +res.getString(5) + " " +res.getDouble(6));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
