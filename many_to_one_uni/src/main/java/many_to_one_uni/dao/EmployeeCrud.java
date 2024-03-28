package many_to_one_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many_to_one_uni.dto.Company;
import many_to_one_uni.dto.Employee;

public class EmployeeCrud {
	EntityManager em = Persistence.createEntityManagerFactory("muzamil").createEntityManager();
	EntityTransaction et = em.getTransaction();
	public void save(Employee emp, int id) {
		Company db = em.find(Company.class, id); 
		if(db != null) {
			et.begin();
			emp.setCompany(db);
			em.persist(emp);
			et.commit();
		}
	}

}
