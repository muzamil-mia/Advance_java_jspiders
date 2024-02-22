package demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ThirdStepCallable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?createDatabaseIfNotExist=true","root","root");
		CallableStatement cs = con.prepareCall("call studentdb.insert(?, ?, ?, ?, ?, ?)");
		cs.setInt(1,8);
		cs.setString(2, "junaid-qazi");
		cs.setString(3, "junaidqazi@gmail");
		cs.setInt(4, 37609232);
		cs.setString(5, "junaidqazi@123");
		cs.setDouble(6, 98);
		cs.execute();
		cs.close();
		con.close();
		System.out.println("inserted");
	}

}
