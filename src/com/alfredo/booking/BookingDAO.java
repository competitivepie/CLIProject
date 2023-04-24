package com.alfredo.booking;

public class BookingDAO {

    private static Booking[] bookings;
    private static int totalBookings;

    static {
        bookings = new Booking[5]; // dummy
        totalBookings = 0;
        // initialize bookings array with proper capacity
        // bookings size should be total amount of cars available
    }

   protected void storeBooking(Booking booking) {
        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i] == null) {
                bookings[totalBookings++] = booking;
                break;
            }
        }
    }

    protected Booking[] selectAllBookings() {
        return bookings;
    }

    protected int getTotalBookings() {
        return totalBookings;
    }

}
