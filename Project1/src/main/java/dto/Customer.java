package dto;

public class Customer {
	private String email;
	private String pwd;
	private double wallet;
	public Customer(String email, String pwd, double wallet) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.wallet = wallet;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
}
