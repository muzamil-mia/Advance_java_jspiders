package hbernate_1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hbernate_1.dto.Employee;

public class EmployeeCrud {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("muzamil");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction et = entityManager.getTransaction();
	public void saveEmployee(Employee emp) {
		et.begin();
		entityManager.persist(emp);
		et.commit();
	}
	public Employee fetchEmployeeById(int id) {
		return entityManager.find(Employee.class, id);
	}
	public void deleteEmployee(int id) {
		Employee emp = entityManager.find(Employee.class, id);
		if(emp != null) {
			et.begin();
			entityManager.remove(emp);
			et.commit();
		}else {
			System.out.println("no such employye present....");
		}
	}
	//update by using db object
	public void updateEmployee(Employee employee) {
		
		Employee dbEmp = entityManager.find(Employee.class, employee.getId());
		if(dbEmp != null) {
			if(employee.getName() == null) {
				employee.setName(dbEmp.getName());
			}else if(employee.getEmail() == null){
				employee.setEmail(dbEmp.getEmail());
			}
			et.begin();
			entityManager.merge(employee);
			et.commit();
		}	
	} 
	
	public void fetchAllEmployee() {
		Query emp = entityManager.createQuery("select emp from Employee emp");
		List<Employee> list = emp.getResultList();
		System.out.println(list);
	}
	public void fetchEmployeeByEmail(String email) {
		//number based jpql query
		//Query query = entityManager.createQuery("select a from Employee a where email = ?1");
		//query.setParameter(1, email);
		
		//name based jpql query 
		Query query = entityManager.createQuery("select a from Employee a where email = :e");
		query.setParameter("e", email);
		System.out.println(query.getResultList());
	}
	
}
