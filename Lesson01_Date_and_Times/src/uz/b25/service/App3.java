package uz.b25.service;

import java.util.Calendar;

public class App3 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(2007, Calendar.FEBRUARY, 17);
        System.out.println("calendar.getTime() = " + calendar.getTime());

        Calendar today = Calendar.getInstance();
        System.out.println("today.getTime() = " + today.getTime());

        // Shodiyorbek necha kun yashagan?
        int days = 0;

        while (calendar.before(today)){
            days++;
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        System.out.println("days = " + days);

//        today.add(Calendar.DAY_OF_YEAR, -27);
//        System.out.println("today.getTime() = " + today.getTime());
//        System.out.println("calendar.before(today) = " + calendar.before(today));

    }
}
