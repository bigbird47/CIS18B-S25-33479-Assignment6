// Brian Siebert
// CIS-17C
// Assignment #8

package ticket;

// Design a Ticket class with immutable properties (final fields, no setters).
public class Ticket {
    private final int id;
    private final String event;

    public Ticket(int id, String event) {
        this.id = id;
        this.event = event;
    }

    public int getId() { return id; }
    public String getEvent() { return event; }
}