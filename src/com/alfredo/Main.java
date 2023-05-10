package com.alfredo;

import com.alfredo.booking.BookingService;
import com.alfredo.car.CarService;
import com.alfredo.user.UserService;

import java.util.Scanner;

public class Main {

   private static final BookingService bookingService = new BookingService();
   private static final CarService carService = new CarService();
   private static final UserService userService = new UserService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var isRunning = true;
        var input = 0;

        while (isRunning) {
            displayMainMenu();
            try {
                input = scanner.nextInt();
                switch (input) {
                    case 1 -> bookingService.startBookingProcess(scanner);
                    case 2 -> bookingService.viewAllUserBookedCars(scanner);
                    case 3 -> { viewAllBookings(); }
                    case 4 -> { viewAllAvailableCars(); }
                    case 5 -> { viewAvailableElectricCars(); }
                    case 6 -> userService.displayAllUsers();
                    case 7 -> isRunning = false;
                    default -> System.out.println(input + " is not a valid option. "
                            + "You must enter a number between 1 and 7!");
                }
            } catch (Exception e) {
                System.out.println("\n\nYour input is invalid. You must enter a number between 1 and 7!\n\n");
                scanner.next();
            }
        }
        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("1 - Book a Car");
        System.out.println("2 - View All User Booked Cars");
        System.out.println("3 - View All Bookings");
        System.out.println("4 - View All Available Cars");
        System.out.println("5 - View Available Electric Cars");
        System.out.println("6 - View All Users");
        System.out.println("7 - Exit");
    }

    private static void viewAllBookings() {
        if (bookingService.numberOfBookings() == 0) {
            System.out.println("\n\nNo bookings have been made.");
        } else {
            bookingService.displayAllBookings();
        }
    }

    private static void viewAllAvailableCars() {
        if (carService.numberOfAvailableCars() == 0) {
            System.out.println("\n\nNo cars available. :(");
        } else {
            carService.displayAllAvailableCarsMenu();
        }
    }

    private static void viewAvailableElectricCars() {
        if (carService.numberOfAvailableElectricCars() == 0) {
            System.out.println("\n\nNo electric cars available. :(");
        } else {
            carService.displayAllElectricCarsMenu();
        }
    }


}