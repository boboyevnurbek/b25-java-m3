package uz.b25.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class WriteExample2 {
    public static void main(String[] args) {
//        InputStream, OutputStream

        File file = new File("files/b25.txt");

        while (true) {
                OutputStream out = null;
            try {
                System.out.println("Enter text: ");
                String text = new Scanner(System.in).nextLine();

                out = new FileOutputStream(file, true);

                out.write(("\n" + text).getBytes());

                System.out.println("success");


            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
