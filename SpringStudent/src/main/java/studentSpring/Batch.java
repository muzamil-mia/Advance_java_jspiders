package studentSpring;

public class Batch {
	private int rNo;
	private String stream;
	@Override
	public String toString() {
		return "Batch [rNo=" + rNo + ", Stream=" + stream + "]";
	}
	public int getrNo() {
		return rNo;
	}
	public Batch(String stream) {
		super();
		this.stream = stream;
	}
	public Batch(int rNo, String stream) {
		super();
		this.rNo = rNo;
		this.stream = stream;
	}
	public void setrNo(int rNo) {
		this.rNo = rNo;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
}
