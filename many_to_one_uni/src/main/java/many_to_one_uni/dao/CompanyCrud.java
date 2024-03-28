package many_to_one_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many_to_one_uni.dto.Company;

public class CompanyCrud {
EntityManager em = Persistence.createEntityManagerFactory("muzamil").createEntityManager();
EntityTransaction et = em.getTransaction();
	public void saveCompany(Company company) {
		et.begin();
		em.persist(company);
		et.commit();
	}
}
