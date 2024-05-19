package hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate.dto.Employee;

public class EmployeeCrud {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("muzamil");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	public void saveEmployee(Employee emp) {
		et.begin();
		em.persist(emp);
		et.commit();
		System.out.println("employee saved");
	}
	
}
