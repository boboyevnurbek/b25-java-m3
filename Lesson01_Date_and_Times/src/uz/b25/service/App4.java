package uz.b25.service;

import java.util.Calendar;

public class App4 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(2007, Calendar.FEBRUARY, 17);
        System.out.println("calendar.getTime() = " + calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR, 10_000);
        System.out.println("calendar.getTime() = " + calendar.getTime());
    }
}
