package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

import one.Demo1;

public class Demo2 {

	public static void main(String[] args) throws IOException {
		try {
			DriverManager.registerDriver(new Driver());
			FileInputStream stream = new FileInputStream("dbconfig.properties");
			Properties properties = new Properties();
			properties.load(stream);
			DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase?createDatabaseIfNotExist = true", properties);
			System.out.println("done");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//goto browser eclipse download -> eclipse downloads -> click on download packages 
		}
	}

}
