package com.jsp.ShopifyApplication.dto;

public class BuyerDTO {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double wallet;
	private long phone;
	private String address;


	public BuyerDTO(String firstName, String lastName, String email, String password, long phone, double wallet,
			String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.wallet = wallet;
		this.phone = phone;
		this.address = address;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public double getWallet() {
		return wallet;
	}


	public void setWallet(double wallet) {
		this.wallet = wallet;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
}
