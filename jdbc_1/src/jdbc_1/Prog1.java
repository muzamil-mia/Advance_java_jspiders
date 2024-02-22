package jdbc_1;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class Prog1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// search for maven repository on browser -> search for mysql jdbc connector -> select highest usage one ->
		//click on jar 2.8m to download, done.
		 //now go to our project
		//open the project right click on it -> build path ->configure build path -> click on jre system library
	   //chose option on right side Add external jars choose file and apply done.
		
		DriverManager.registerDriver(new Driver());
		System.out.println("load done...");
	}

}
