package jdbc_2.dto;
//encapsulated class
public class Student {
	private int id;
	private String name;
	private String email;
	private long phone;
	private String pwd;
	private double marks;
	public Student(int id, String name, String email, long phone, String pwd, double marks) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.pwd = pwd;
		this.marks = marks;
	}
	public Student(int id1, String newName) {
		this.id = id1;
		this.name = newName;
	}
	public Student(String deleteName) {
		this.name = deleteName;
	}
	public Student() {
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", pwd=" + pwd
				+ ", marks=" + marks + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
}
