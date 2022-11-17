package uz.b25.time_api.localtime;

import java.time.LocalTime;

public class App1 {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println("now = " + now);

        System.out.println("LocalTime.MIN = " + LocalTime.MIN);
        System.out.println("LocalTime.MIDNIGHT = " + LocalTime.MIDNIGHT);
        System.out.println("LocalTime.NOON = " + LocalTime.NOON);
        System.out.println("LocalTime.MAX = " + LocalTime.MAX);

        System.out.println();

        LocalTime localTime = LocalTime.parse("18:46");
        System.out.println("localTime = " + localTime);

        localTime = LocalTime.of(18, 46, 52);
        System.out.println("localTime = " + localTime);

        localTime = LocalTime.ofSecondOfDay(50_000);
        System.out.println("localTime = " + localTime);

//        localTime = LocalTime.of(28, 46, 52);
//        System.out.println("localTime = " + localTime);


    }
}
