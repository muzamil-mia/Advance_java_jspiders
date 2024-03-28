package hbernate_1.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hbernate_1.dao.EmployeeCrud;
import hbernate_1.dto.Employee;

public class EmployeeController {
	public static void main(String[] args) {
		Employee emp = new Employee(1,"muzamil", "muzamil@gmail.com", 30000, "abc123", 124352452,"hyderabad");
		EmployeeCrud crud = new EmployeeCrud();
		//crud.saveEmployee(emp);
//		
//		Employee emp1 = crud.fetchEmployeeById(1);
//		System.out.println(emp1);
		
		//crud.deleteEmployee(12); //no such employee
		//crud.deleteEmployee(1);
		Employee emp2 = new Employee();
		emp2.setId(1);
		emp2.setName("hussain");
		emp2.setSalary(1300000);
		crud.updateEmployee(emp2);
		crud.fetchAllEmployee();
		//crud.fetchEmployeeByEmail("muzamil@gmail.com");
	}
}
