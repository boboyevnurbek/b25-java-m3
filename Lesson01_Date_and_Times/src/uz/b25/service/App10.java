package uz.b25.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App10 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("date = " + date); // 07.11.2022

        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy hh:mm:ss a zzz EEEE D");
        String format = dateFormat.format(date);
        System.out.println("format = " + format);


        dateFormat = new SimpleDateFormat("'\nSana: 'dd MMMM yyyy '\nVaqt: 'HH:mm:ss");
        format = dateFormat.format(date);
        System.out.println(format);
    }
}
