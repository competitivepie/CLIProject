package com.alfredo.booking;

public class BookingArrayDataAccessService implements BookingDAO {

    private final Booking[] bookings;
    private int totalBookings;

    public BookingArrayDataAccessService() {
        this.bookings = new Booking[5];
        this.totalBookings = 0;
    }

    public void storeBooking(Booking booking) {
        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i] == null) {
                bookings[totalBookings++] = booking;
                break;
            }
        }
    }

    public Booking[] selectAllBookings() {
        return bookings;
    }

    public int getTotalBookings() {
        return totalBookings;
    }

}
