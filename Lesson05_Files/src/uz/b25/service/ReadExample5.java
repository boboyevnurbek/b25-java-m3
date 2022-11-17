package uz.b25.service;

import java.io.*;
import java.util.ArrayList;

public class ReadExample5 {
    public static void main(String[] args) {
        File file1 = new File("files/b25.txt");
        File file2 = new File("files/numbers.txt");
        File file3 = new File("files/join.txt");

        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2));
             PrintWriter printWriter = new PrintWriter(file3);
        ) {

            String s1, s2;

            while (true) {
                s1 = reader1.readLine();
                s2 = reader2.readLine();

                if(s1==null && s2==null) break;
                if(s1==null) s1 = "";
                if(s2==null) s2 = "";

                printWriter.println(s1 + " " + s2);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
