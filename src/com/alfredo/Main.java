package com.alfredo;

import com.alfredo.booking.Booking;
import com.alfredo.booking.BookingService;
import com.alfredo.car.Car;
import com.alfredo.car.CarService;
import com.alfredo.user.User;
import com.alfredo.user.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class Main {

   private static final BookingService bookingService = new BookingService();
   private static final CarService carService = new CarService();
   private static final UserService userService = new UserService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var isRunning = true;
        var isBookingCar = false;
        var isSelectingUser = false;
        var input = 0;

        while (isRunning) {
            displayMainMenu();
            try {
                input = sc.nextInt();
                switch (input) {
                    case 1 -> {
                        isBookingCar = true;
                        while (isBookingCar) {
                            try {
                                displayAllAvailableCarsMenu();
                                System.out.println("-> Select car reg number");
                                String carSelected = sc.next();
                                for (Car car : carService.getCars()) {
                                    if (car == null) {
                                        continue;
                                    }
                                    if (Integer.parseInt(carSelected) == car.getRegNumber()) {
                                        int carRegNumber = car.getRegNumber();
                                        isSelectingUser = true;
                                        while (isSelectingUser) {
                                            try {
                                                displaySelectUserIDMenu();
                                                UUID userSelected = UUID.fromString(sc.next().trim());
                                                for (User user : userService.getUsers()) {
                                                    if (user.getId().equals(userSelected)) {
                                                        UUID bookingID = UUID.randomUUID();
                                                        bookingService.addNewBooking(bookingID, user, car, false);
                                                        carService.removeCar(car);
                                                        System.out.println("Success! Booked car with reg number " + carRegNumber +
                                                                " for user " + user);
                                                        System.out.println("Booking reference: " + bookingID);
                                                        isSelectingUser = false;
                                                        isBookingCar = false;
                                                        break;
                                                    }
                                                }
                                            } catch (IllegalArgumentException e) {
                                                System.out.println("Your input is invalid. Try again!");
                                            }
                                        }
                                    } else {
                                        continue;
                                    }
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Your input is invalid. Try again!");
                            }
                        }
                    }
                    case 2 -> {
                        isSelectingUser = true;
                        while(isSelectingUser) {
                            try {
                                displaySelectUserIDMenu();
                                String userSelected = sc.next();
                                for (User user : userService.getUsers()) {
                                    if (user == null) {
                                        continue;
                                    }
                                    Booking[] bookingsMadeByUser = new Booking[bookingService.numberOfBookings()];
                                    var totalUserBookings = 0;
                                    if (user.getId().equals(UUID.fromString(userSelected))) {
                                        for (int i = 0; i < bookingsMadeByUser.length; i++) {
                                            if (bookingService.getBookings()[i].getUser().equals(user)) {
                                                bookingsMadeByUser[i] = bookingService.getBookings()[i];
                                                totalUserBookings++;
                                            }
                                        }
                                        isSelectingUser = false;
                                        if(totalUserBookings == 0) {
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
                            } catch (NumberFormatException e) {
                                System.out.println("Your input is invalid. You must enter a user ID.");
                            }
                        }
                    }
                    case 3 -> {
                        if (bookingService.numberOfBookings() == 0) {
                            System.out.println("No bookings have been made.");
                        } else {
                            displayAllBookings();
                        }
                    }
                    case 4 -> {
                        if (carService.numberOfAvailableCars() == 0) {
                            System.out.println("No cars available. :(");
                        } else {
                            displayAllAvailableCarsMenu();
                        }
                    }
                    case 5 -> {
                        if (carService.numberOfAvailableElectricCars() == 0) {
                            System.out.println("No electric cars available. :(");
                        } else {
                            displayAllElectricCarsMenu();
                        }
                    }
                    case 6 -> displayAllUsers();
                    case 7 -> isRunning = false;
                    default -> System.out.println(input + " is not a valid option. "
                            + "You must enter a number between 1 and 7!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Your input is invalid. You must enter a number between 1 and 7!");
                sc.next();
            }
        }
        sc.close();
    }

    // This method creates the main menu.
    private static void displayMainMenu() {
        System.out.println("1 - Book a Car");
        System.out.println("2 - View All User Booked Cars");
        System.out.println("3 - View All Bookings");
        System.out.println("4 - View Available Cars");
        System.out.println("5 - View Available Electric Cars");
        System.out.println("6 - View All Users");
        System.out.println("7 - Exit");
    }

    /*
    This method creates the select user id menu
    after selecting the 2-View All User Booked Cars
    option.
     */
    private static void displaySelectUserIDMenu() {
        System.out.println("-> Select User ID");
        displayAllUsers();
    }

    private static void displayAllBookings() {
        for (Booking booking : bookingService.getBookings()) {
            if (booking == null) {
                break;
            }
            System.out.println(booking);
        }
    }

    /*
    This method displays the car menu after selecting the
    book a car option.
     */
    private static void displayAllAvailableCarsMenu() {
        for (Car car : carService.getCars()) {
            if (car == null) {
                continue;
            }
            if (car.isAvailable()) {
                System.out.println(car);
            }
        }
    }

    private static void displayAllElectricCarsMenu() {
        for (Car car : carService.getCars()) {
            if (car == null) {
                continue;
            }
            if (car.isAvailable() && car.isElectric()) {
                System.out.println(car);
            }
        }
    }

    private static void displayAllUsers() {
        for (User user : userService.getUsers()) {
            System.out.println(user);
        }
    }
}