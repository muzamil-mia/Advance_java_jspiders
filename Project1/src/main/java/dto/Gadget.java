package dto;

public class Gadget {
	private int id;
	private String brandName;
	private String phoneName;
	private double size;
	private double price;
	private double battery;
	private double version;
	public Gadget(int id, String phoneName, double price) {
		super();
		this.id = id;
		this.phoneName = phoneName;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Gadget [brandName=" + brandName + ", phoneName=" + phoneName + ", size=" + size + ", price=" + price
				+ ", battery=" + battery + ", version=" + version + "]";
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getPhoneName() {
		return phoneName;
	}
	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getBattery() {
		return battery;
	}
	public void setBattery(double battery) {
		this.battery = battery;
	}
	public double getVersion() {
		return version;
	}
	public void setVersion(double version) {
		this.version = version;
	}
	public Gadget() {
		super();
	}
	public Gadget(int id2) {
		this.id = id2;
	}
}
