package one_to_many_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_many_uni.dto.Country1;

public class Country1Crud {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("muzamil");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	public void saveCountry(Country1 country1) {
		et.begin();
		em.persist(country1);
		et.commit();
	}
	
}
