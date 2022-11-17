package uz.b25.time_api.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class App8 {
    public static void main(String[] args) {
        // 2022-yildagi dam olish kunlari (SATURDAY, SUNDAY) nechta?

        LocalDate localDate = LocalDate.of(2022, 1, 1);

        int holidays = 0;

        while (localDate.getYear() == 2022) {
            DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.SUNDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                holidays++;
            }

            localDate = localDate.plusDays(1);
        }

        System.out.println("holidays = " + holidays);
    }
}
