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
        while (isBookingCar) {
            try {
                if(carService.numberOfAvailableCars() == 0) {
                    System.out.println("No cars available to book. :(");
                    break;
                }
                carService.displayAllAvailableCarsMenu();
                System.out.println("-> Select car reg number (Press 7 to go back to previous menu) ");
                String carSelected = scanner.next();
                if (Integer.parseInt(carSelected) == 7) {
                    break;
                }
                for (Car car : carService.getCars()) {
                    if (car == null) {
                        continue;
                    }
                    if (Integer.parseInt(carSelected) == car.getRegNumber()) {
                        int carRegNumber = car.getRegNumber();
                        isSelectingUser = true;
                        while (isSelectingUser) {
                            try {
                                userService.displaySelectUserIDMenu();
                                String userSelected = scanner.next().trim();
                                if (userSelected.equals("7".trim())) {
                                    break;
                                }
                                UUID userID = UUID.fromString(userSelected);
                                for (User user : userService.getUsers()) {
                                    if (user.getId().equals(userID)) {
                                        UUID bookingID = UUID.randomUUID();
                                        addNewBooking(bookingID, user, car, false);
                                        carService.removeCar(car);
                                        System.out.println("Success! Booked car with reg number " + carRegNumber +
                                                " for user " + user);
                                        System.out.println("Booking reference: " + bookingID);
                                        car.setAvailable(false);
                                        isSelectingUser = false;
                                        isBookingCar = false;
                                        break;
                                    }
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println("Your input is invalid. Try again!");
                                break;
                            }
                        }
                    } else {
                        continue;
                    }
                    break;
                }
            //    System.out.println("Your input is invalid. Try again!");
            } catch (IllegalArgumentException e) {
                System.out.println("Your input is invalid. Try again!");
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
                            System.out.println("No cars have been booked by this user.");
                        } else {
                            System.out.println("Bookings made by " + user);
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
                System.out.println("Your input is invalid. You must enter a user ID.");
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
