package se.lexicon.robin;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        //---------task 1
        File fileToRead = new File("C:\\Users\\deltagare\\Documents/RandomText.txt");
        String text = read(fileToRead);
        System.out.println(text);

        //---------task 2
        File listOfNames = new File("C:\\Users\\deltagare\\Documents/NameList.txt");
        List<String> nameList = readToList(listOfNames);
        for (String name: nameList){
            System.out.println(name);
        }

        //---------task 3
        List<String> games = Arrays.asList("Warframe", "DDO", "Wolcen" , "Elder scrolls", "Guild wars 2");
        File gameList = new File("C:\\Users\\deltagare\\Documents/GameList.txt");
        writeFromList(gameList , games);

        //---------task 4
        File gameListOriginal = new File("C:\\Users\\deltagare\\Documents/GameList.txt");
        File gameListCopy = new File("C:\\Users\\deltagare\\Documents/GameListCopy.txt");
        copyFiles(gameListOriginal,gameListCopy);

        //---------task 5
        List<Car> cars = Arrays.asList(new Car("ABC 123", "Volvo" , "S60" , LocalDate.parse("2005-10-20"),"Robin Sandberg"),
                new Car("CBA 654", "Saab" , "9000" , LocalDate.parse("2000-05-15"),"Bengt Svensson"),
                new Car("WDC 951", "Nissan" , "Skyline" , LocalDate.parse("2000-03-27"),"Eva Dhalgren"));
        String path = "C:\\Users\\deltagare\\Documents/Cars.txt";
        serialize(cars, path);
        File serializedCars = new File("C:\\Users\\deltagare\\Documents/Cars.txt");
        readSerialize(serializedCars);
    }

    public static String read(File name){
        StringBuilder builder = new StringBuilder();
        try(FileReader reader = new FileReader(name)){
            int i;
            while((i = reader.read()) != -1){
                char letter = (char) i;
                builder.append(letter);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static List<String> readToList(File name){
        List<String> names = new ArrayList<>();
        String nameString;
        try(BufferedReader reader = new BufferedReader(new FileReader(name))){
           while ((nameString = reader.readLine()) != null){
               names.add(nameString);
           }
        }catch(IOException e){
            e.printStackTrace();
        }
        return names;
    }

    public static void writeFromList(File name , List<String> items){
        try(FileWriter writer = new FileWriter(name)){
            if(!name.exists()){
                name.createNewFile();
            }
            for (String item: items) {
                writer.write(item + "\n");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void copyFiles(File original , File copy){
        try(   BufferedInputStream in = new BufferedInputStream(new FileInputStream(original));
               BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(copy))
        ) {
            byte[] buffer = new byte[1024];
            int byteRead;
            while ((byteRead = in.read(buffer)) > 0){
                out.write(buffer , 0 , byteRead);
                out.flush();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void  serialize(List<Car> cars, String path){
        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)
        ){
            out.writeObject(cars);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void readSerialize(File name){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(name))){
            List<Car> deSerializedCars = (List<Car>) in.readObject();

            for (Car car: deSerializedCars) {
                System.out.println("Car Id: " + car.getCarId() +
                "\nRegistration number: " + car.getRegNumber() +
                "\nBrand: " + car.getBrand() +
                "\nModel: " + car.getModel() +
                "\nRegistration date: " + car.getRegDate() +
                "\nOwner: " + car.getOwner() + "\n");
            }

        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}