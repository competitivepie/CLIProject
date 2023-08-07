package com.alfredo.booking;

import java.util.ArrayList;
import java.util.List;

public class BookingArrayDataAccessService implements BookingDAO {

    private final List<Booking> bookings;

    public BookingArrayDataAccessService() {
        this.bookings = new ArrayList<>();
    }

    public void storeBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> selectAllBookings() {
        return bookings;
    }

    public int getTotalBookings() {
        return bookings.size();
    }

}
