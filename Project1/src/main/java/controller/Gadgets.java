package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.UserCrud;
import dto.Gadget;

public class Gadgets {

	public static void main(String[] args) {
		UserCrud  crud = new UserCrud();
		List<Gadget> list = new ArrayList<>();
		list.add(new Gadget(1,"S9 Plus", 60000));
		list.add(new Gadget(2,"Redmi 9", 20000));
		list.add(new Gadget(3,"Iphone 14", 100000));
		crud.addGadgets(list);
	}

}
