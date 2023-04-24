package com.alfredo.car;

public class CarService {

    private CarDAO carDAO;

    {
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
}
