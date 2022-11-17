package uz.b25.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadExample4 {
    public static void main(String[] args) {
        File file = new File("files/b25.txt");

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file))) {

            String line;
            String longestLine = "";

            ArrayList<String> longList = new ArrayList<>();

            while( (line = reader.readLine()) != null){
               if(line.length() > longestLine.length()){
                   longestLine = line;
                   longList.clear();
                   longList.add(line);
               }else if(line.length() == longestLine.length()){
                   longList.add(line);
               }
            }

            System.out.println("longList = " + longList);
            System.out.println("****");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
