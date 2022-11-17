package uz.b25.time_api.localdate;

import java.time.LocalDate;

public class App3 {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(2007, 2, 17);
        LocalDate today = LocalDate.now();

        // Shodiyorbek necha kun yashagan?
        int days = 0;

        while (localDate.isBefore(today)) {
            days++;
            localDate = localDate.plusDays(1);
        }

        System.out.println("days = " + days);

    }
}
