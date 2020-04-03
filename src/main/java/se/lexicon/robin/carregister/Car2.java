package se.lexicon.robin.carregister;

import java.io.Serializable;
import java.time.LocalDate;

public class Car2 implements Serializable {
    private static int counter = 0;
    private final int carId;
    private String regNumber;
    private String brand;
    private String model;
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
}
