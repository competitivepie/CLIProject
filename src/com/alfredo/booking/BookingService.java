package com.alfredo.booking;

import com.alfredo.car.Car;
import com.alfredo.user.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookingService {

    private BookingDAO bookingDAO;

    {
        bookingDAO = new BookingDAO();
    }

    public void addNewBooking(UUID bookingID, User user, Car car, boolean isCanceled) {
        bookingDAO.storeBooking(new Booking(bookingID, user, car, LocalDateTime.now(), isCanceled));
    }

    public Booking[] getBookings() {
        return bookingDAO.selectAllBookings();
    }

    public int numberOfBookings() {
        return bookingDAO.getTotalBookings();
    }
}
