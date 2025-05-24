// Brian Siebert
// CIS-17C
// Assignment #8

package ticket;

public class TraditionalTicketSystem {
	  public static void main(String[] args) {
	    TicketPool pool = new TicketPool(5);

	    for (int i = 1; i <= 10; i++) {
	        Thread t = new Thread(new Customer("Customer-" + i, pool));
	        t.start();
	    }
	  }
	}