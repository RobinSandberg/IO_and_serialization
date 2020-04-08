package se.lexicon.robin.carregister.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class Car2 implements Serializable {
    private static int counter = 0;
    private int carId;
    private String regNumber;
    private String brand;
    private String model;
    @JsonFormat(shape= JsonFormat.Shape.STRING)
    private LocalDate regDate;
    private Owner owner;

    public Car2(String regNumber, String brand, String model, LocalDate regDate, Owner owner) {
        this.carId = ++counter;
        this.regNumber = regNumber;
        this.brand = brand;
        this.model = model;
        this.regDate = regDate;
        this.owner = owner;
    }

    public Car2(){
    }

    public int getCarId() {
        return carId;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public Owner getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Car2{" +
                "carId=" + carId +
                ", regNumber='" + regNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", regDate=" + regDate +
                ", owner=" + owner +
                '}';
    }
}
