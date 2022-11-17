package uz.b25.time_api.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class App5 {
    public static void main(String[] args) {
        // 2022-yilning 33-jumasini aniqlash

        LocalDate localDate = LocalDate.of(2022, 1, 1);

        // find first friday
        while (!localDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
            localDate = localDate.plusDays(1);
        }

        localDate = localDate.plusWeeks(32);
        System.out.println("localDate = " + localDate);
    }
}
