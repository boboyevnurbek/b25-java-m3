package uz.b25.service;

import java.io.*;
import java.util.Scanner;

public class WriteExample1 {
    public static void main(String[] args) {
//        InputStream, OutputStream

        File file = new File("files/b25.txt");

        try {
            System.out.println("Enter text: ");
            String text = new Scanner(System.in).nextLine();

            OutputStream out = new FileOutputStream(file, true);

            out.write(("\n"+text).getBytes());

            System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
