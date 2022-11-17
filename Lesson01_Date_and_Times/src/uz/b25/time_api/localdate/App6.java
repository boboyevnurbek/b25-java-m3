package uz.b25.time_api.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class App6 {
    public static void main(String[] args) {
        // keyingi oyning oxirgi shanbasini topish
        LocalDate now = LocalDate.now();
        LocalDate result = null;

//        Month month = now.getMonth();
//        while (now.getMonth().equals(month)){
//            if(now.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
//                result = now;
//                now = now.plusWeeks(1);
//            }else {
//                now = now.plusDays(1);
//            }
//        }

        result = now.with(TemporalAdjusters.lastInMonth(DayOfWeek.SATURDAY));

        System.out.println("result = " + result);
    }
}
