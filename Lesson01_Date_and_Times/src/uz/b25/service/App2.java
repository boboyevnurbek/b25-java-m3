package uz.b25.service;

import java.util.Calendar;

public class App2 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(2007, Calendar.FEBRUARY, 17);
        System.out.println("calendar.getTime() = " + calendar.getTime());

        Calendar today = Calendar.getInstance();
        System.out.println("today.getTime() = " + today.getTime());

        // Shodiyorbek necha kun yashagan?

        long days = (today.getTimeInMillis() - calendar.getTimeInMillis()) / 1000 / 86400;
        System.out.println("days = " + days);
    }
}
