package se.lexicon.robin.carregister;

import se.lexicon.robin.carregister.model.Car2;
import se.lexicon.robin.carregister.model.Owner;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Owner> owners = Arrays.asList(new Owner("Robin Sandberg", LocalDate.parse("1982-10-29")),
                new Owner("Eva Dhalgren" , LocalDate.parse("1978-05-16")));

        List<Car2> car2s = Arrays.asList(new Car2("ABC 123" , "Volvo", "S60", LocalDate.parse("2005-04-21"),owners.get(0)),
                new Car2("CDA 321", "Saab","9000",LocalDate.parse("2002-02-08"), owners.get(1)));

        JsonIO jasonIO = new JsonIO();

        boolean success = jasonIO.writeToJson(car2s, new File("src/main/resources/cars.json"));
        System.out.println("Success = " + success);
        success = jasonIO.writeToJson(owners, new File("src/main/resources/owners.json"));
        System.out.println("Success = " + success);

        List<Car2> jsonCars = jasonIO.readFromJson(new File("src/main/resources/cars.json"), ArrayList::new);

        List<Owner> jsonOwners = jasonIO.readFromJson(new File("src/main/resources/owners.json"), ArrayList::new);
        jsonOwners.forEach(System.out::println);
        jsonCars.forEach(System.out::println);
    }
}
