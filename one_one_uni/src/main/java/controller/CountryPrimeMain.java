package controller;

import javax.persistence.Persistence;

import one_one_uni.dao.CountryCrud;
import one_one_uni.dao.PrimeMinisterCrud;
import one_one_uni.dto.Country;
import one_one_uni.dto.PrimeMinister;

public class CountryPrimeMain {

	public static void main(String[] args) {
//		CountryCrud cc = new CountryCrud();
//		cc.saveCountry(new Country("india", 12000, "peacock", "tiger"));
//		
		PrimeMinisterCrud pc = new PrimeMinisterCrud();
//		pc.savePrimeMinister(2, new PrimeMinister("rahul","male",70,"bjp"));
		
//	   Country country = new Country();
//	   country.setName("Pakistan");
//	   country.setId(1);
//	   cc.updateCountry(country);
//	   cc.deleteCountry(1);
	   
	   pc.deletePrimeminister(3);
	}
}
