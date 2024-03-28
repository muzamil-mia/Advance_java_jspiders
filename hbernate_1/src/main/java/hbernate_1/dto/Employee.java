package hbernate_1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int id;
	private String name;
	private String email;
	private double salary;
	private String pwd;
	private long phone;
	public Employee(int id, String name, String email, double salary, String pwd, long phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.pwd = pwd;
		this.phone = phone;
		this.address = address;
	}


	private String address;
	
	public Employee() {
		super();
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + ", pwd=" + pwd
				+ ", phone=" + phone + ", address=" + address + "]";
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


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
}
