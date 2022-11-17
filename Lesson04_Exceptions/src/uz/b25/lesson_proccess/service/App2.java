package uz.b25.lesson_proccess.service;

public class App2 {
    public static void main(String[] args) {
//        Exception
//        CHECKED = COMPILE TIME => Exception
//        UNCHECKED = RUN TIME => RuntimeException


        try {
            System.out.println(10/0);
        }
        catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
        catch (StringIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
            System.out.println();
        }

        System.out.println("FINISH");
    }
}
