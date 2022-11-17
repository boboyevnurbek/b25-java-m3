package uz.b25.service;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class App7 {
    public static void main(String[] args) {

        Calendar calendar=Calendar.getInstance();
        calendar.set(2200, Calendar.JANUARY,1);

        System.out.println("calendar.getMaximum(Calendar.DAY_OF_YEAR) = " +
                calendar.getMaximum(Calendar.DAY_OF_YEAR)); // 366
        System.out.println("calendar.getActualMaximum(Calendar.DAY_OF_YEAR) = " +
                calendar.getActualMaximum(Calendar.DAY_OF_YEAR)); // 365

        boolean leapYear = new GregorianCalendar().isLeapYear(
                calendar.get(Calendar.YEAR));
        System.out.println("leapYear = " + leapYear);

    }
}
