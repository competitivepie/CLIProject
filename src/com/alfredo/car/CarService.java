package com.alfredo.car;

public class CarService {

    private static final CarArrayDataAccessService carArrayDataAccessService;

    static {
        carArrayDataAccessService = new CarArrayDataAccessService();
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
}
