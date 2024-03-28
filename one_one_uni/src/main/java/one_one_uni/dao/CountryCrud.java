package one_one_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import one_one_uni.dto.Country;

public class CountryCrud {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("muzamil");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	public void saveCountry(Country country) {
		et.begin();
		em.persist(country);
		et.commit();
	}
	public void updateCountry(Country country) {
		Country db = em.find(Country.class, country.getId());
		if(db!= null) {
			et.begin();
			em.merge(country);
			et.commit();
		}else {
			System.out.println("no such country present");
		}
	}
	public void deleteCountry(int id) {
		Country country = em.find(Country.class, id);
		if(country != null) {
			et.begin();
			em.remove(country);
			et.commit();
		}
	}
	

}
