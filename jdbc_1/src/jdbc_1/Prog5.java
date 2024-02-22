package jdbc_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class Prog5 implements Comparable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		ArrayList<Student> list = new ArrayList<>();
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=root");
		
		Statement stm = con.createStatement();
		//execute of statement
//		 stm.execute("insert into table1 values(3, 'hussain','hussainmuzamil@gmail.com', 1234567890)");
//		 stm.execute("insert into table1 values(4, 'zakir','hussainmuzamil@gmail.com', 1234567890)");
//		 stm.executeUpdate("insert into table1 values(5, 'sabit', 'sabit@gmail.com', 914977)");
		
		ResultSet res = stm.executeQuery("select * from table1");
		System.out.println(res);
		while(res.next()) {
			int id = res.getInt(1);
			//System.out.println(id);
			String name = res.getString("name");
			System.out.println(name);
			int ph = res.getInt(4);
			list.add(new Student(id, name, ph));
//			System.out.println(res.getInt(1));
//			System.out.println(res.getInt(4));
//			System.out.println(res.getString("Name"));
		}
		System.out.println("Before sorting");
		System.out.println(list);
		Collections.sort(list);
		System.out.println("After sorting");
		System.out.println(list);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

class Student implements Comparable<Student> {
	int id;
	String name;
	int ph;
	public Student(int id, String name, int ph) {
		super();
		this.id = id;
		this.name = name;
		this.ph = ph;
	}
	@Override
	public int compareTo(Student o) {
		
		return this.name.compareTo(o.name);
	}
	@Override
	public String toString() {
		return "\nStudent [id=" + id + ", name=" + name + ", ph=" + ph + "]";
	}
}
