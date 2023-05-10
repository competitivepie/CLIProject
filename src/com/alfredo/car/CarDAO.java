package com.alfredo.car;

public interface CarDAO {

    void deleteCar(Car car);

    Car[] selectAllCars();

    int getAllAvailableCars();

    int getAvailableElectricCars();

}
