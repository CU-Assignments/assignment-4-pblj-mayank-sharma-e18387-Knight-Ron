import java.util.concurrent.atomic.AtomicBoolean;

class TicketBookingSystem {
    private static final int TOTAL_SEATS = 10;
    private static AtomicBoolean[] seats = new AtomicBoolean[TOTAL_SEATS];

    static {
        for (int i = 0; i < TOTAL_SEATS; i++) {
            seats[i] = new AtomicBoolean(false);
        }
    }

    public synchronized void bookSeat(String bookingType) {
        for (int i = 0; i < TOTAL_SEATS; i++) {
            if (!seats[i].get()) {
                seats[i].set(true);
                System.out.println(bookingType + " booked seat number " + (i + 1));
                return;
            }
        }
        System.out.println(bookingType + " booking failed: No available seats!");
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem bookingSystem;
    private String bookingType;

    public BookingThread(TicketBookingSystem bookingSystem, String bookingType, int priority) {
        this.bookingSystem = bookingSystem;
        this.bookingType = bookingType;
        setPriority(priority);
    }

    @Override
    public void run() {
        bookingSystem.bookSeat(bookingType);
    }
}

public class TicketBookingApp {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem();

        // Creating VIP booking threads (High Priority)
        for (int i = 1; i <= 5; i++) {
            new BookingThread(bookingSystem, "VIP Booking " + i, Thread.MAX_PRIORITY).start();
        }

        // Creating Regular booking threads (Normal Priority)
        for (int i = 1; i <= 10; i++) {
            new BookingThread(bookingSystem, "Regular Booking " + i, Thread.NORM_PRIORITY).start();
        }
    }
}
