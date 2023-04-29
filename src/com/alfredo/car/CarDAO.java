package com.alfredo.car;

import java.math.BigDecimal;
import java.util.UUID;

public class CarDAO {

    private static Car[] cars;
    private static int availableCars;
    private static int availableElectricCars;

    static {
        cars = new Car[]{
                new Car(1234, UUID.fromString("95231e5f-6069-4939-b647-97917211995b"), new BigDecimal("45.00"), "TOYOTA", false, true),
                new Car(5555, UUID.fromString("4b9b59b7-28dd-4e9e-9d02-f565a39664cd"), new BigDecimal("90.00"), "TESLA", true, true),
                new Car(6789, UUID.fromString("0f0c4660-2a78-4014-a782-123de26d5276"), new BigDecimal("65.00"), "MERCEDES", false, true),
                new Car(3434, UUID.fromString("6b7e1e37-ccf3-417d-9c73-1f9bec2d6bd7"), new BigDecimal("120.00"), "NISSAN", true, true),
                new Car(9999, UUID.fromString("afff42d5-0590-4166-9d27-15109cf98681"), new BigDecimal("87.00"), "HONDA", false, true)
        };
        availableCars = cars.length;
        availableElectricCars = 2;
    }

    protected void deleteCar(Car car) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == car) {
                cars[i] = null;
                if (car.isElectric()) {
                    availableElectricCars--;
                }
                availableCars--;
            }
        }
    }

    protected Car[] selectAllCars() {
        return cars;
    }

    protected int getAvailableCars() {
        return availableCars;
    }

    protected int getAvailableElectricCars() {
        return availableElectricCars;
    }

}