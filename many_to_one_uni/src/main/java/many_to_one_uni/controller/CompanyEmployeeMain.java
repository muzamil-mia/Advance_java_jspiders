package many_to_one_uni.controller;

import javax.persistence.Persistence;

import many_to_one_uni.dao.CompanyCrud;
import many_to_one_uni.dao.EmployeeCrud;
import many_to_one_uni.dto.Company;
import many_to_one_uni.dto.Employee;

public class CompanyEmployeeMain {

	public static void main(String[] args) {
		Company company = new Company();
		company.setId(1);
		company.setName("testyntra");
		company.setAddress("banglore");
		company.setCeo("vivek");
		CompanyCrud crud = new CompanyCrud();
		crud.saveCompany(company);
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("muzamil");
		emp.setEmail("hussian@gmail");
		emp.setSalary(1200000);
		emp.setDesig("software developer");
		EmployeeCrud empCrud = new EmployeeCrud();
		empCrud.save(emp, 1);
	}

}
