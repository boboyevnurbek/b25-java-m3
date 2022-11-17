package uz.b25.service;

import java.io.*;
import java.util.Scanner;

public class WriteExample4 {
    public static void main(String[] args) {
//        InputStream, OutputStream

        File file = new File("files/numbers.txt");

        while (true) {
            try (Writer writer = new FileWriter(file, true)) {

                System.out.println("Enter text: ");
                String text = new Scanner(System.in).nextLine();

                writer.write(text+"\n");

                System.out.println("success");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
