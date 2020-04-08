package se.lexicon.robin.carregister.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class Owner implements Serializable {
    private static int counter = 0;
    private int ownerId;
    private String name;
    @JsonFormat(shape= JsonFormat.Shape.STRING)
    private LocalDate birthday;

    public Owner(String name, LocalDate birthday) {
        this.ownerId = ++counter;
        this.name = name;
        this.birthday = birthday;
    }

    public Owner(){
    }


    public int getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
