package uz.b25.service;

import java.io.*;
import java.util.Arrays;

public class ReadExample1 {
    public static void main(String[] args) {
        File file = new File("files/b25.txt");

        try (InputStream in = new FileInputStream(file)) {

//            byte[] bytes = in.readAllBytes();
//            String text = new String(bytes);
//            System.out.println("text = " + text);
//
//            String[] lines = text.split("\n");
//            System.out.println("lines = " + Arrays.toString(lines));

            int c;
            while ((c = in.read()) != -1){
                System.out.print((char)c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
