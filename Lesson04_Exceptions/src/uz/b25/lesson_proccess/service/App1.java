package uz.b25.lesson_proccess.service;

public class App1 {
    public static void main(String[] args) {
//        Throwable => Error, Exception
//        StackOverflowError, OutOfMemoryError

        // recursion();

        // m1();

        int[] arr = new int[1_000_000_000];
        System.out.println("arr[0] = " + arr[0]);

    }

    private static void m1() {
        m2();
    }

    private static void m2() {
        m1();
    }

    private static void recursion() {
        recursion();
    }
}
