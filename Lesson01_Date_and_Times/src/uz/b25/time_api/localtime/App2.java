package uz.b25.time_api.localtime;

import java.time.LocalTime;

public class App2 {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime = " + localTime);

        localTime = localTime.plusHours(2).plusMinutes(-15);

        System.out.println("localTime = " + localTime);

        // task
        // start from 14:30   => necha daqiqa dars bo'lganini aniqlash

        LocalTime time = LocalTime.now().minusHours(14).minusMinutes(30);
        System.out.println("time = " + time);
    }
}
