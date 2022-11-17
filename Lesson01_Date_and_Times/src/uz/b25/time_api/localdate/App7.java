package uz.b25.time_api.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class App7 {
    public static void main(String[] args) {
        // keyingi yakshanbani topish

        LocalDate today = LocalDate.now();
        System.out.println("today = " + today);

        System.out.println("today.isLeapYear() = " + today.isLeapYear());

        // LocalDate result = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        // LocalDate result = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));

        LocalDate result = LocalDate.of(2023, 1, 1)
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));

        System.out.println("result = " + result);
    }
}
