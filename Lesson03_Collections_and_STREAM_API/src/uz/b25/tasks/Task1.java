package uz.b25.tasks;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        // 1. tasodifiy 5 ta toq son generate qiluvchi stream yozing

        Stream.generate(() -> new Random().nextInt(100))
                .filter(number -> number % 2 != 0)
                .limit(5)
                .forEach(n -> System.out.println("n =" + n));

        // 2. tasodifiy 5 ta son generate qiluvchi stream yozing
        // va ularning eng kattasini ekranga chiqaring
        System.out.println();

        List<Integer> collect = Stream.generate(() -> new Random().nextInt())
                .limit(5).toList();
        collect.forEach(System.out::println);

        System.out.println("max = " + collect.stream().max(Integer::compareTo));

        // 3. Dastlabki 10 ta juft sondan iborat list hosil qiluvchi stream yozing
        // va ularning yig'indisini hisoblang

        System.out.println();

        List<Integer> list = Stream.iterate(2, (n) -> n + 2)
                .limit(10).toList();
        System.out.println("list = " + list);

        Integer total = list.stream().reduce(0, Integer::sum);
        System.out.println("total = " + total);

    }
}
