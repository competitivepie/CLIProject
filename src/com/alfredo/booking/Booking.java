package com.alfredo.booking;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.alfredo.car.Car;
import com.alfredo.user.User;

public class Booking {

    private UUID bookingID;
    private User user;
    private Car car;
    private LocalDateTime bookingTime;
    private boolean isCanceled;

    public Booking(UUID bookingID, User user, Car car, LocalDateTime bookingTime, boolean isCanceled) {
        this.bookingID = bookingID;
        this.user = user;
        this.car = car;
        this.bookingTime = bookingTime;
        this.isCanceled = isCanceled;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return  "booking = Booking{" +
                "bookingID=" + bookingID +
                ", user=" + user +
                ", car=" + car +
                ", bookingTime=" + bookingTime +
                ", isCanceled=" + isCanceled +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return isCanceled == booking.isCanceled && Objects.equals(bookingID, booking.bookingID) && Objects.equals(user, booking.user) && Objects.equals(car, booking.car) && Objects.equals(bookingTime, booking.bookingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingID, user, car, bookingTime, isCanceled);
    }
}
