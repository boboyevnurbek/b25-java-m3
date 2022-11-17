package uz.b25.time_api.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class App4_v2 {
    public static void main(String[] args) {
        // 2022-yilning barcha yakshanbalarini ekranga chiqarish

        LocalDate localDate = LocalDate.of(2022, 1, 1);

        // find first sunday
        while (!localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            localDate = localDate.plusDays(1);
        }

        // print all sundays in 2022
        while (localDate.getYear() == 2022) {
            System.out.println("localDate = " + localDate);
            localDate = localDate.plusWeeks(1);
        }


    }
}
