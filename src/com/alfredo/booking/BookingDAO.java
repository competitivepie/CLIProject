package com.alfredo.booking;

public interface BookingDAO {

    void storeBooking(Booking booking);
    Booking[] selectAllBookings();

    int getTotalBookings();

}
