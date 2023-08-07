package com.alfredo.car;

import java.util.List;

public interface CarDAO {

    void deleteCar(Car car);

    List<Car> selectAllCars();

}
