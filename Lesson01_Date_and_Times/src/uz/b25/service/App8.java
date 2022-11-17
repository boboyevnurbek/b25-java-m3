package uz.b25.service;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class App8 {
    public static void main(String[] args) {
        // 2022-yilning har bir oyining oxirgi sanasini chiqarish
        // getActualMaximum(Calendar.DAY_OF_MONTH)

        Calendar calendar2=Calendar.getInstance();
        calendar2.set(2022, Calendar.JANUARY,1);

        while (calendar2.get(Calendar.YEAR)==2022) {
            calendar2.set(calendar2.get(Calendar.YEAR),
                    calendar2.get(Calendar.MONTH),
                    calendar2.getActualMaximum(Calendar.DAY_OF_MONTH));
            System.out.println(calendar2.getTime());
            calendar2.add(Calendar.MONTH,1);
        }


    }
}
