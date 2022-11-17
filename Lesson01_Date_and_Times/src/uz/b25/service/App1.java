package uz.b25.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App1 {
    public static void main(String[] args) {
        // Vaqt
//     Tashkent: 15:00
//     Istanbul: 15:00

//        Calendar calendar = new GregorianCalendar();
        Calendar calendar = Calendar.getInstance();

//        month: 0-11
//        day of week : 1-sunday, 2-monday ..., 7-saturday

        System.out.println("calendar = " + calendar);

        System.out.println();
        Date date = calendar.getTime();
        System.out.println("date = " + date.toString());

        System.out.println("calendar.get(Calendar.YEAR) = " + calendar.get(Calendar.YEAR));
        System.out.println("calendar.get(Calendar.MONTH) = " + calendar.get(Calendar.MONTH));
        System.out.println("calendar.get(Calendar.WEEK_OF_YEAR) = " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("calendar.get(Calendar.DAY_OF_YEAR) = " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("calendar.get(Calendar.DAY_OF_MONTH) = " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("calendar.get(Calendar.DAY_OF_WEEK) = " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("calendar.get(Calendar.HOUR) = " + calendar.get(Calendar.HOUR));
        System.out.println("calendar.get(Calendar.HOUR_OF_DAY) = " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("calendar.get(Calendar.MINUTE) = " + calendar.get(Calendar.MINUTE));
        System.out.println("calendar.get(Calendar.SECOND) = " + calendar.get(Calendar.SECOND));
        System.out.println("calendar.get(Calendar.MILLISECOND) = " + calendar.get(Calendar.MILLISECOND));
        System.out.println("calendar.get(Calendar.AM_PM) = " + calendar.get(Calendar.AM_PM));


    }
}
