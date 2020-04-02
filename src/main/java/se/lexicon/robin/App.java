package se.lexicon.robin;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        File fileToRead = new File("C:\\Users\\deltagare\\Documents/RandomText.txt");
        String text = read(fileToRead);
        System.out.println(text);

        File listOfNames = new File("C:\\Users\\deltagare\\Documents/NameList.txt");
        List<String> nameList = readToList(listOfNames);
        for (String name: nameList){
            System.out.println(name);
        }
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
}