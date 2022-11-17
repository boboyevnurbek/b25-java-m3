package uz.b25.stream_api;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App4 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(5, 4, 3, 78, -9, 10);

        IntSummaryStatistics statistics = intStream.summaryStatistics();

        System.out.println("statistics.getAverage() = " + statistics.getAverage());
        System.out.println("statistics.getSum() = " + statistics.getSum());
        System.out.println("statistics.getMax() = " + statistics.getMax());
        System.out.println("statistics.getMin() = " + statistics.getMin());
        System.out.println("statistics.getCount() = " + statistics.getCount());

        System.out.println();

        IntSummaryStatistics statistics1 = IntStream.of(10, 20, 30).summaryStatistics();
        IntSummaryStatistics statistics2= IntStream.of(100, 200, 300).summaryStatistics();
        System.out.println("statistics1.getSum() = " + statistics1.getSum());
        System.out.println("statistics1.getMax() = " + statistics1.getMax());

        statistics1.combine(statistics2);

        System.out.println("statistics1.getSum() = " + statistics1.getSum());
        System.out.println("statistics1.getMax() = " + statistics1.getMax());

        System.out.println("statistics1 = " + statistics1);

    }
}
