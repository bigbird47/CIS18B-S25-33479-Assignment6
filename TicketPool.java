// Brian Siebert
// CIS-17C
// Assignment #8

package ticket;

//Design a TicketPool class that tracks available tickets.
public class TicketPool {
    private int availableTickets;

    public TicketPool(int totalTickets) {
        this.availableTickets = totalTickets;
    }

    // Synchronize access to the ticket count to avoid race conditions.
    // If a thread finds no tickets available, it should wait or handle it gracefully using guarded blocks (while loops with conditions inside synchronized blocks).
    public synchronized Ticket reserveTicket(String customerName) {
    	while (availableTickets == 0) {
    		try {
    			System.out.println(customerName + " is waiting for a ticket...");
    			wait();
    		} catch (InterruptedException e) {
    			Thread.currentThread().interrupt();
    			return null;
    		}
    	}
    	
    	availableTickets--;
    	Ticket ticket = new Ticket(availableTickets, "Concert");
    	System.out.println(customerName + " reserved Ticket #" + ticket.getId() + ". Tickets left: " + availableTickets);
    	return ticket;
    }

    public synchronized void releaseTicket() {
    	availableTickets++;
    	notify();
    }
}