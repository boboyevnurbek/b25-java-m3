package uz.b25.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class WriteExample3 {
    public static void main(String[] args) {
//        InputStream, OutputStream

        File file = new File("files/b25.txt");

        while (true) {
            try (OutputStream out = new FileOutputStream(file, true)) {
                System.out.println("Enter text: ");
                String text = new Scanner(System.in).nextLine();

                out.write(("\n" + text).getBytes());

                System.out.println("success");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
