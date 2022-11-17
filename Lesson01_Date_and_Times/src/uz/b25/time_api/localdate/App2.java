package uz.b25.time_api.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class App2 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(1991, 9, 1);
        System.out.println("localDate = " + localDate);

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);

        localDate = localDate.plusDays(100);

        System.out.println("localDate = " + localDate);

        localDate = localDate.plusDays(10)
                .plusWeeks(2)
                .plusYears(5)
                .plusMonths(8)
                .minusWeeks(200);

        System.out.println("localDate = " + localDate);

        localDate = localDate.plus(2, ChronoUnit.MONTHS);

        System.out.println("localDate = " + localDate);
    }
}
