package uz.b25.service;

import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;

public class App2 {
    public static void main(String[] args) {
        // files/dayofweeks/monday.txt
        // files/dayofweeks/tuesday.txt
        //...
        // files/dayofweeks/sunday.txt

        File folder = new File("files/dayofweeks");
        folder.mkdirs();

        DayOfWeek[] dayOfWeeks = DayOfWeek.values();

        for (DayOfWeek dayOfWeek : dayOfWeeks) {
            File file = new File(folder, dayOfWeek.name().toLowerCase()+".txt");

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //file.delete();
        }


    }
}
