// Brian Siebert
// CIS-17C
// Assignment #8

package ticket;

import java.util.concurrent.*;

public class VirtualTicketSystem {
  public static void main(String[] args) {
    TicketPool pool = new TicketPool(5);

    // Replace traditional thread creation with virtual threads using Java’s Thread.startVirtualThread or Executors.newVirtualThreadPerTaskExecutor().
    try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
      for (int i = 1; i <= 10; i++) {
        executor.submit(new Customer("Customer-" + i, pool));
      }
    }
  }
}