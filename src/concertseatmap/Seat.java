package concertseatmap;

public class Seat {
	private boolean sold;
	private String type;
	private double price;
	
	public Seat(boolean s, String t, double p) {
		sold = s;
		type = t;
		price = p;
	}
	public boolean getSold() {
		return sold;
	}
	public void setSold(boolean s) {
		sold = s;
	}
	public String getType() {
		return type;
	}
	public void setType(String t) {
		type = t;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double p) {
		price = p;
	}
}
