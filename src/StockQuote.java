
public class StockQuote {

	public static void main(String[] args) {
		System.out.println("Hello, World");
		StockObj myStock = new StockObj("stock");
		System.out.println(myStock.getName());
		try {
		System.out.println(GrabHTML.readHTML("www.google.com"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
