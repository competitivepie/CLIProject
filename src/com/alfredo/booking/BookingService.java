package com.alfredo.booking;

import com.alfredo.car.Car;
import com.alfredo.car.CarService;
import com.alfredo.user.User;
import com.alfredo.user.UserService;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class BookingService {

    private final BookingDAO bookingDAO;
    private final UserService userService;
    private final CarService carService;

    public BookingService() {
        bookingDAO = new BookingDAO();
        userService = new UserService();
        carService = new CarService();
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

    public void bookACar(Scanner scanner) {
        var isBookingCar = true;
        var isSelectingUser = false;
        var isBooked = false;
        while (isBookingCar) {
            try {
                if(carService.numberOfAvailableCars() == 0) {
                    System.out.println("\n\nNo cars available to book. :(");
                    break;
                }
                carService.displayAllAvailableCarsMenu();
                System.out.println("-> Select car reg number (Press 7 to go back to previous menu) ");
                String carSelected = scanner.next();
                var carRegNumber = Integer.parseInt(carSelected);
                if (carRegNumber == 7) {
                    break;
                }
                for (Car car : carService.getCars()) {
                    if (car == null) {
                        continue;
                    }
                    if (carRegNumber == car.getRegNumber()) {
                        carRegNumber = car.getRegNumber();
                        isSelectingUser = true;
                        while (isSelectingUser) {
                            try {
                                userService.displaySelectUserIDMenu();
                                String userSelected = scanner.next().trim();
                                if (userSelected.equals("7".trim())) {
                                    isBooked = true;
                                    break;
                                }
                                UUID userID = UUID.fromString(userSelected);
                                for (User user : userService.getUsers()) {
                                    if (user.getId().equals(userID)) {
                                        UUID bookingID = UUID.randomUUID();
                                        addNewBooking(bookingID, user, car, false);
                                        carService.removeCar(car);
                                        System.out.println("\n\nSuccess! Booked car with reg number " + carRegNumber +
                                                " for user " + user);
                                        System.out.println("Booking reference: " + bookingID);
                                        car.setAvailable(false);
                                        isSelectingUser = false;
                                        isBookingCar = false;
                                        isBooked = true;
                                        break;
                                    }
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println("\n\nYour input is invalid. Try again!\n\n");
                            }
                        }
                    }
                }
                if (!isBooked) {
                    System.out.println("\n\nYour input is invalid. Try again!\n\n");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\n\nYour input is invalid. Try again!\n\n");
            }
        }
    }

    public void viewAllUserBookedCars(Scanner scanner) {
        var isSelectingUser = true;
        while(isSelectingUser) {
            try {
                userService.displaySelectUserIDMenu();
                String userSelected = scanner.next();
                if (userSelected.equals("7".trim())) {
                    break;
                }
                for (User user : userService.getUsers()) {
                    if (user == null) {
                        continue;
                    }
                    Booking[] bookingsMadeByUser = new Booking[numberOfBookings()];
                    var totalUserBookings = 0;
                    if (user.getId().equals(UUID.fromString(userSelected))) {
                        for (int i = 0; i < bookingsMadeByUser.length; i++) {
                            if (getBookings()[i].getUser().equals(user)) {
                                bookingsMadeByUser[i] = getBookings()[i];
                                totalUserBookings++;
                            }
                        }
                        isSelectingUser = false;
                        if (totalUserBookings == 0) {
                            System.out.println("\n\nNo cars have been booked by this user.\n\n");
                        } else {
                            System.out.println("\n\nBookings made by " + user + "\n\n");
                            for (Booking booking : bookingsMadeByUser) {
                                if (booking != null) {
                                    System.out.println(booking);
                                }
                            }
                        }
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\n\nYour input is invalid. You must enter a user ID.\n\n");
            }
        }
    }

    public void displayAllBookings() {
        for (Booking booking : getBookings()) {
            if (booking == null) {
                break;
            }
            System.out.println(booking);
        }
    }
}
