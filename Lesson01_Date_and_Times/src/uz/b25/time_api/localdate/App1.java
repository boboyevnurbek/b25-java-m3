package uz.b25.time_api.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class App1 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);
        // yyyy-MM-dd : ISO DATE FORMAT

        System.out.println("localDate.getYear() = " + localDate.getYear());
        System.out.println("localDate.getMonthValue() = " + localDate.getMonthValue());
        System.out.println("localDate.getMonth() = " + localDate.getMonth());
        System.out.println("localDate.getDayOfMonth() = " + localDate.getDayOfMonth());
        System.out.println("localDate.getDayOfWeek() = " + localDate.getDayOfWeek());
        System.out.println("localDate.getDayOfYear() = " + localDate.getDayOfYear());

        System.out.println("****");
        System.out.println("localDate.get(ChronoField.DAY_OF_WEEK) = " + localDate.get(ChronoField.DAY_OF_WEEK));
        // ...
        //System.out.println("localDate.get(ChronoField.HOUR_OF_DAY) = " + localDate.get(ChronoField.HOUR_OF_DAY));
        System.out.println("****");

//        Month, DayOfWeek
        System.out.println();

        System.out.println("LocalDate.MIN = " + LocalDate.MIN);
        System.out.println("LocalDate.MAX = " + LocalDate.MAX);

        LocalDate localDate1 = LocalDate.of(2007, Month.FEBRUARY, 17);
        System.out.println("localDate1 = " + localDate1);
        localDate1 = LocalDate.of(2007, 2, 17);
        System.out.println("localDate1 = " + localDate1);
        localDate1 = LocalDate.ofYearDay(2022, 311);
        System.out.println("localDate1 = " + localDate1);
        localDate1 = LocalDate.parse("2007-02-17");
        System.out.println("localDate1 = " + localDate1);
        localDate1 = LocalDate.parse("17.02.2007", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println("localDate1 = " + localDate1);
    }
}
