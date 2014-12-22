
public class StockQuote {

	public static void main(String[] args) {
		System.out.println("Hello, World");
		StockObj myStock = new StockObj("RHT");
		System.out.println(myStock.getName());
		System.out.println(myStock.isValid() + "\n");
//		System.out.println(myStock.getHtml());
		System.out.println(myStock.getPrice());
	}

}
