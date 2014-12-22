
public class StockQuote {

	public static void main(String[] args) {
		System.out.println("Hello, World");
		StockObj myStock = new StockObj("RHT");
		myStock.printStock();
		
		try {
		    Thread.sleep(10000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		myStock.updateQuote();
		myStock.printStock();
		
		try {
		    Thread.sleep(10000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		myStock.updateQuote();
		myStock.printStock();
		
	}

}
