package uz.b25.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class App9 {
    public static void main(String[] args) {
        Set<String> availableCalendarTypes = Calendar.getAvailableCalendarTypes();
        System.out.println("availableCalendarTypes = " + availableCalendarTypes);

        Date date = new Date();
        System.out.println("date = " + date);

        date = new Date(1_000_000_000_000L);
        System.out.println("date = " + date);

        Date stopDate = new Date(new Date().getTime()+30*60*1000);
        System.out.println("stopDate = " + stopDate);

        System.out.println("date.getTime() = " + date.getTime());
        System.out.println("stopDate.getTime() = " + stopDate.getTime());
    }
}
