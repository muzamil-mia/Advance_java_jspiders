package one_one_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import one_one_uni.dto.Country;
import one_one_uni.dto.PrimeMinister;

public class PrimeMinisterCrud {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("muzamil");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	public void savePrimeMinister(int country_id, PrimeMinister primeMinister) {
		
		//check whether country is present in db or not
	    Country countrydbc = em.find(Country.class, country_id);
	    //System.out.println(countrydbc);
	    if(countrydbc != null) {
	    	et.begin();
	    	PrimeMinister pm = em.merge(primeMinister);
	    	countrydbc.setPm(pm);
	    	et.commit();
	    }else {
	    	System.out.println("id does not exist");
	    }
	}
	public void deletePrimeminister(int id) {
		PrimeMinister pm = em.find(PrimeMinister.class, id);
		
		if(pm != null) {
			
			Query query = em.createQuery("SELECT c FROM Country c WHERE c.pm = :pm");
			query.setParameter("pm", pm);
			Country cc = (Country) query.getSingleResult();
			cc.setPm(null);
			et.begin();
			em.remove(pm);
			et.commit();
		}
	}

}
