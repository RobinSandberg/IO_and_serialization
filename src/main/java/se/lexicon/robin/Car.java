package se.lexicon.robin;

import java.io.Serializable;
import java.time.LocalDate;

public class Car implements Serializable {
    private static int counter = 0;
    private final int carId;
    private String regNumber;
    private String brand;
    private String model;
    private LocalDate regDate;
    private String owner;

    public Car(String regNumber, String brand, String model, LocalDate regDate, String owner) {
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

    public String getOwner() {
        return owner;
    }
}
