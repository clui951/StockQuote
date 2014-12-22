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
		int nameFrom = this.html.indexOf("Summary for ", titleTag);
		int nameTo = this.html.indexOf("- Yahoo! Finance", nameFrom);
		String newName = this.html.substring(nameFrom + 12, nameTo);
		this.name = newName;
	}

	public void updateQuote() {
		try {
			this.html = GrabHTML.readHTML(this.link);
			this.updatePrice();
			this.updateDate();
			this.valid = true;
		} catch (Exception e1) {
			System.out.println(e1);
			this.valid = false;
		}
	}

	protected void updatePrice() {
		int startTag = this.html.indexOf("yfs_194", 0);
		int priceFrom = this.html.indexOf( "\">", startTag);
		int priceTo = this.html.indexOf( "</span>", priceFrom);
		String newPrice = this.html.substring( priceFrom + 1, priceTo);
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
