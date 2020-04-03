package se.lexicon.robin.carregister;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Owner> owners = Arrays.asList(new Owner("Robin Sandberg", LocalDate.parse("1982-10-29")),
                new Owner("Eva Dhalgren" , LocalDate.parse("1978-05-16")));

        List<Car2> car2s = Arrays.asList(new Car2("ABC 123" , "Volvo", "S60", LocalDate.parse("2005-04-21"),owners.get(0)),
                new Car2("CDA 321", "Saab","9000",LocalDate.parse("2002-02-08"), owners.get(1)));

        for(Car2 car : car2s){
            System.out.println(car.getCarId());
            System.out.println(car.getRegNumber());
            System.out.println(car.getBrand());
            System.out.println(car.getModel());
            System.out.println(car.getRegDate());
            System.out.println("Owner: ");
            System.out.println(car.getOwner().getOwnerId());
            System.out.println(car.getOwner().getName());
            System.out.println(car.getOwner().getBirthday());
        }

    }
}
