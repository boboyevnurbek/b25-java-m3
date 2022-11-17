package uz.b25.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadExample3 {
    public static void main(String[] args) {
        File file = new File("files/numbers.txt");

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file))) {

            double total = 0;

            String line;
            while( (line = reader.readLine()) != null){
                // [+-]\\d+(\\.\\d*)?
                try {
                    total += Double.parseDouble(line);
                } catch (NumberFormatException e) {

                }
            }
            System.out.println("total = " + total);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
