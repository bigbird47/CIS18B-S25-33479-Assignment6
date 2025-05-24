// Brian Siebert
// CIS-17C
// Assignment #8

package ticket;

// Create a Customer class that extends Thread or implements Runnable.
public class Customer implements Runnable {
	  private final String name;
	  private final TicketPool pool;

	  public Customer(String name, TicketPool pool) {
	    this.name = name;
	    this.pool = pool;
	  }

	  // Each customer attempts to reserve a ticket.
	  @Override
	  public void run() {
	    Ticket ticket = pool.reserveTicket(name);
	    if (ticket != null) {
	      System.out.println(name + " got Ticket #" + ticket.getId());
	    }
	  }
	}