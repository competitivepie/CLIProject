package com.alfredo.car;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Car {

    private int regNumber;
    private UUID id;
    private BigDecimal rentalPricePerDay;
    private String brand;
    private boolean isElectric;
    private boolean isAvailable;

    public Car(int regNumber, UUID id, BigDecimal rentalPricePerDay, String brand, boolean isElectric, boolean isAvailable) {
        this.regNumber = regNumber;
        this.id = id;
        this.rentalPricePerDay = rentalPricePerDay;
        this.brand = brand;
        this.isElectric = isElectric;
        this.isAvailable = isAvailable;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(BigDecimal rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber=" + regNumber +
                ", id=" + id +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", brand='" + brand + '\'' +
                ", isElectric=" + isElectric +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return regNumber == car.regNumber && isElectric == car.isElectric && isAvailable == car.isAvailable && Objects.equals(id, car.id) && Objects.equals(rentalPricePerDay, car.rentalPricePerDay) && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, id, rentalPricePerDay, brand, isElectric, isAvailable);
    }
}
