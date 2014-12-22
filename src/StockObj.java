
public class StockObj {
	private String name;
	private String date;
	private double price;
	private String html;
	private boolean valid = false;
	
	public StockObj( String name ) {
		this.name = name;
		try {
			GrabHTML.readHTML("http://finance.yahoo.com/q?s=" + name);
			this.valid = true;
		} catch (Exception e1) {}
	}
	
	
	public String getName() {
		return this.name;
	}
	public String getDate() {
		return this.date;
	}	
	public double getPrice() {
		return this.price;
	}
	public String getHtml() {
		return this.html;
	}	
	public boolean valid() {
		return this.valid;
	}
	
	
}
