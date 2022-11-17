package uz.b25.service;

import java.io.File;
import java.util.Arrays;

public class App3 {
    public static void main(String[] args) {
        File folder = new File("./");

        String[] list = folder.list();
        System.out.println("list = " + Arrays.toString(list));

        File[] files = folder.listFiles();
        for (File file : files) {
            System.out.println("file = " + file);
        }
    }


}
