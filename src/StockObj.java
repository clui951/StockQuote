public class StockObj {
	protected String symbol;
	protected String name;
	protected String date;
	protected double price;
	protected String link;
	protected String html;
	protected boolean valid = false;

	public StockObj(String symbol) {
		this.symbol = symbol;
		this.link = "http://finance.yahoo.com/q?s=" + symbol;
		this.updateQuote();
		
		// Set name of stock
		int titleTag = this.html.indexOf("<title>", 0);
		int nameFrom = this.html.indexOf("Summary for ", titleTag) + 12; //12 offset, start from after string
		int nameTo = this.html.indexOf("- Yahoo! Finance", nameFrom);
		String newName = this.html.substring(nameFrom, nameTo);
		this.name = newName;
	}

	public void updateQuote() {
		try {
			this.html = GrabHTML.readHTML(this.link);
			this.updatePrice();
			this.updateDate();
			this.valid = true;
		} catch (Exception e1) {
			e1.printStackTrace();
			this.valid = false;
		}
	}

	protected void updatePrice() {
		int startTag = this.html.indexOf("yfs_l84", 0);
		int priceFrom = this.html.indexOf( "\">", startTag) + 2; // 2 offset, start from after >
		int priceTo = this.html.indexOf( "</span>", priceFrom);
		String newPrice = this.html.substring( priceFrom, priceTo);
		this.price = Double.parseDouble(newPrice);
	}

	protected void updateDate() {

	}

	public String getSymbol() {
		return this.symbol;
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

	public boolean isValid() {
		return this.valid;
	}

}
