package com.alfredo;

import com.alfredo.booking.BookingArrayDataAccessService;
import com.alfredo.booking.BookingService;
import com.alfredo.car.CarArrayDataAccessService;
import com.alfredo.car.CarService;
import com.alfredo.user.UserFileDataAccessService;
import com.alfredo.user.UserService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BookingArrayDataAccessService bookingArrayDataAccessService = new BookingArrayDataAccessService();
        CarArrayDataAccessService carArrayDataAccessService = new CarArrayDataAccessService();
        UserFileDataAccessService userFileDataAccessService = new UserFileDataAccessService();
        CarService carService = new CarService(carArrayDataAccessService);
        UserService userService = new UserService(userFileDataAccessService);
        BookingService bookingService = new BookingService(bookingArrayDataAccessService,
                userService,
                carService
        );
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
                    case 3 -> bookingService.viewAllBookings();
                    case 4 ->  carService.viewAvailableCars();
                    case 5 ->  carService.viewAvailableElectricCars();
                    case 6 ->  userService.viewAllUsers();
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

}