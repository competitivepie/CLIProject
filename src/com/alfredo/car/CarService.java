package com.alfredo.car;

public class CarService {

    private final CarArrayDataAccessService carArrayDataAccessService;

    public CarService(CarArrayDataAccessService carArrayDataAccessService) {
        this.carArrayDataAccessService = carArrayDataAccessService;
    }

    public void removeCar(Car car) {
        carArrayDataAccessService.deleteCar(car);
    }

    public Car[] getCars() {
        return carArrayDataAccessService.selectAllCars();
    }

    public int numberOfAvailableCars() {
        return carArrayDataAccessService.getAllAvailableCars();
    }

    public int numberOfAvailableElectricCars() {
        return carArrayDataAccessService.getAvailableElectricCars();
    }

    public void displayAllAvailableCarsMenu() {
        for (Car car : getCars()) {
            if (car == null) {
                continue;
            }
            if (car.isAvailable()) {
                System.out.println(car);
            }
        }
    }

    public void displayAllElectricCarsMenu() {
        for (Car car : getCars()) {
            if (car == null) {
                continue;
            }
            if (car.isAvailable() && car.isElectric()) {
                System.out.println(car);
            }
        }
    }

    public void viewAvailableCars() {
        if (numberOfAvailableCars() == 0) {
            System.out.println("\n\nNo cars available. :(");
        } else {
            displayAllAvailableCarsMenu();
        }
    }

    public void viewAvailableElectricCars() {
        if (numberOfAvailableElectricCars() == 0) {
            System.out.println("\n\n No electric cars available. :(");
        } else {
            displayAllElectricCarsMenu();
        }
    }
}
