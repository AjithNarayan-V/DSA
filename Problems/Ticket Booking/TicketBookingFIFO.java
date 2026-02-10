import java.util.LinkedList;
import java.util.Queue;

public class TicketBookingFIFO {

    private Queue<String> bookingQueue;
    private int availableTickets;

    // Constructor
    public TicketBookingFIFO(int totalTickets) {
        bookingQueue = new LinkedList<>();
        availableTickets = totalTickets;
    }

    // Add user to queue
    public void addCustomer(String name) {
        bookingQueue.offer(name);
        System.out.println(name + " added to booking queue");
    }

    // Process booking (FIFO)
    public void processBooking() {
        while (!bookingQueue.isEmpty() && availableTickets > 0) {
            String customer = bookingQueue.poll();
            availableTickets--;
            System.out.println("Ticket booked for " + customer +
                               " | Remaining tickets: " + availableTickets);
        }

        if (!bookingQueue.isEmpty() && availableTickets == 0) {
            System.out.println("Tickets sold out!");
            while (!bookingQueue.isEmpty()) {
                System.out.println("Booking failed for " + bookingQueue.poll());
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        TicketBookingFIFO system = new TicketBookingFIFO(3);

        system.addCustomer("Ajith");
        system.addCustomer("Rahul");
        system.addCustomer("Sneha");
        system.addCustomer("Kiran");

        system.processBooking();
    }
}
