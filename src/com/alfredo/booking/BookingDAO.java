package com.alfredo.booking;

public class BookingDAO {

    private Booking[] bookings;
    private int totalBookings;

    // TODO
    // initialize bookings array with proper capacity
    // bookings size should be total amount of cars available
    public BookingDAO() {
        bookings = new Booking[5];
        totalBookings = 0;
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
