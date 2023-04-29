package com.alfredo.car;

public class CarService {

    private final CarDAO carDAO;

    public CarService() {
        carDAO = new CarDAO();
    }

    public void removeCar(Car car) {
        carDAO.deleteCar(car);
    }

    public Car[] getCars() {
        return carDAO.selectAllCars();
    }

    public int numberOfAvailableCars() {
        return carDAO.getAvailableCars();
    }

    public int numberOfAvailableElectricCars() {
        return carDAO.getAvailableElectricCars();
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
