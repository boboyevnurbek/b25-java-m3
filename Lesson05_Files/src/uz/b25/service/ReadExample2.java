package uz.b25.service;

import java.io.*;

public class ReadExample2 {
    public static void main(String[] args) {
        File file = new File("files/numbers.txt");

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file))) {

            String line;
            while( (line = reader.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
