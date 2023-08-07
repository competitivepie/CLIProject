package com.alfredo.booking;

import java.util.List;

public interface BookingDAO {

    void storeBooking(Booking booking);
    List<Booking> selectAllBookings();

    int getTotalBookings();

}
