package uz.b25.service;

import java.util.Calendar;

public class App11 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(2022, 15, 60);
        System.out.println("calendar.getTime() = " + calendar.getTime());
    }
}
