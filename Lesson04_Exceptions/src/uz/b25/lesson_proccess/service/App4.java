package uz.b25.lesson_proccess.service;

public class App4 {
    public static void main(String[] args) {
        int result = someMethod();
        System.out.println("result = " + result);
    }

    private static int someMethod() {
        try {
            // System.exit(0);
            System.out.println(10/0);
            return 10;
        } catch (ArithmeticException e) {
            return 20;
        } finally {
            System.out.println("finally");
            return 30;
        }

    }
}
