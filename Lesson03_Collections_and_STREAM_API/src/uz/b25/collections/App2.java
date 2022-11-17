package uz.b25.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(List.of(
                "Sarvar", "Sardor", "Azamjon", "Sarvar", "Shodiyorbek", "Zamir"));

//        String max = Collections.max(list);
        String max = Collections.max(list, Comparator.comparingInt(String::length));
        System.out.println("max = " + max);

        // belgilar sonini ko'pligi bo'yicha o'sish tartibida tartiblash

        Comparator<String> comparator = (s1, s2) -> {
            return s1.length() == s2.length() ? s1.compareTo(s2) : s1.length()-s2.length();
        };

        Collections.sort(list, comparator);

        System.out.println("list = " + list);


    }
}
