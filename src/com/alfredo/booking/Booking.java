package com.alfredo.booking;

import java.time.LocalDateTime;
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

    public UUID getBookingID() {
        return bookingID;
    }

    public void setBookingID(UUID bookingID) {
        this.bookingID = bookingID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
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
}
