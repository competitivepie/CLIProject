package com.alfredo.car;

import java.util.List;

public class CarService {

    private final CarArrayDataAccessService carArrayDataAccessService;

    public CarService(CarArrayDataAccessService carArrayDataAccessService) {
        this.carArrayDataAccessService = carArrayDataAccessService;
    }

    public void removeCar(Car car) {
        carArrayDataAccessService.deleteCar(car);
    }

    public List<Car> getCars() {
        return carArrayDataAccessService.selectAllCars();
    }

    public int numberOfAvailableCars() { return carArrayDataAccessService.selectAllCars().size(); }

    public int numberOfAvailableElectricCars() {
        int availableElectricCars = 0;
        for(Car car : carArrayDataAccessService.selectAllCars()) {
            if(car.isElectric()) {
                availableElectricCars++;
            }
        }
        return availableElectricCars;
    }

    public void displayAllAvailableCarsMenu() {
        for (Car car : getCars()) {
            System.out.println(car);
        }
    }

    public void displayAllElectricCarsMenu() {
        for (Car car : getCars()) {
            if (car.isElectric()) {
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
