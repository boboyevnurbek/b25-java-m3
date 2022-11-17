package uz.b25.time_api.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class App4 {
    public static void main(String[] args) {
        // 2022-yilning barcha yakshanbalarini ekranga chiqarish

        LocalDate localDate = LocalDate.of(2022, 1, 1);
        LocalDate localDate1 = LocalDate.of(2023, 1, 1);

        while (localDate.isBefore(localDate1)){
            if(localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                System.out.println("localDate = " + localDate);
                localDate = localDate.plusWeeks(1);
            }
            else{
                localDate = localDate.plusDays(1);
            }
        }


    }
}
