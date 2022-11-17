package uz.b25.service;

import java.util.Calendar;

public class App5 {
    public static void main(String[] args) {
        // 2022-yilning barcha yakshanbalarini ekranga chiqarish
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);

        System.out.println("calendar.getTime() = " + calendar.getTime());
        System.out.println("calendar.get(Calendar.DAY_OF_WEEK) = " +
                calendar.get(Calendar.DAY_OF_WEEK));

        Calendar calendar1=Calendar.getInstance();
        calendar1.set(2022, Calendar.JANUARY,1);

        while(calendar1.get(Calendar.YEAR)<2023){
            if(calendar1.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
                System.out.println(calendar1.getTime());
            }
            calendar1.add(Calendar.DAY_OF_WEEK,1);
        }


    }
}
