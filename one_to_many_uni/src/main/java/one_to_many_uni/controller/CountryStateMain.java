package one_to_many_uni.controller;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Persistence;

import one_to_many_uni.dao .Country1Crud;
import one_to_many_uni.dto.Country1;
import one_to_many_uni.dto.State;

public class CountryStateMain {

	public static void main(String[] args) {
//		Persistence.createEntityManagerFactory("muzamil").createEntityManager();
		
		List<State> list = new ArrayList<>();
		list.add(new State("AP","jagan", 14,"telugo"));
		list.add(new State("MP","jagannath", 23,"malyalm"));
		list.add(new State("Telengana","jagan", 33,"telugo"));
		Country1 country1 = new Country1("India",120000000,"peacock","tiger", (ArrayList<State>) list);
		Country1Crud crud = new Country1Crud();
		crud.saveCountry(country1);
	}
}
