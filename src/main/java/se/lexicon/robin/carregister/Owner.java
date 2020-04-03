package se.lexicon.robin.carregister;

import java.io.Serializable;
import java.time.LocalDate;

public class Owner implements Serializable {
    private static int counter = 0;
    private final int ownerId;
    private String name;
    private LocalDate birthday;

    public Owner(String name, LocalDate birthday) {
        this.ownerId = ++counter;
        this.name = name;
        this.birthday = birthday;
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
}
