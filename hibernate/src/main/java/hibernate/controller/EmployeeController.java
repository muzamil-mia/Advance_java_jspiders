package hibernate.controller;

import hibernate.dao.EmployeeCrud;
import hibernate.dto.Employee;

public class EmployeeController {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("muzamil");
		emp.setEmail("hussainmuzamil@gmail.com");
		emp.setPhone(123456778);
		emp.setPwd("muzamil@123");
		emp.setSalary(12340);
		EmployeeCrud crud = new EmployeeCrud();
		crud.saveEmployee(emp);
	}
}
