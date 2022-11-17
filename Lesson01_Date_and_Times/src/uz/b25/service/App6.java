package uz.b25.service;

import java.util.Calendar;

public class App6 {
    public static void main(String[] args) {
        // 2022-yilning 33-jumasini aniqlash

        Calendar calendar1=Calendar.getInstance();
        calendar1.set(2022, Calendar.JANUARY,1);

        // find first friday
        while(calendar1.get(Calendar.DAY_OF_WEEK) != Calendar.FRIDAY){
            calendar1.add(Calendar.DAY_OF_WEEK,1);
        }

        // print 33-friday in 2022

//        calendar1.add(Calendar.DAY_OF_WEEK,32*7);
        calendar1.add(Calendar.WEEK_OF_YEAR,32);

        // result
        System.out.println(calendar1.getTime());

    }
}
