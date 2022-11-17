package uz.b25.lesson_proccess.service;

import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App5 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                try {
                    System.out.print("Birinchi sonni kiriting: ");
                    int firstNumber = scanner.nextInt();

                    System.out.print("Ikkinchi sonni kiriting sonni kiriting: ");
                    int secondNumber = scanner.nextInt();

                    try {
                        System.out.println("Bolinmasi: " + (firstNumber / secondNumber));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.println("Yigindisi: " + (firstNumber + secondNumber));
                    System.out.println("Ayirmasi: " + (firstNumber - secondNumber));
                    System.out.println("Ko'paytmasi: " + (firstNumber * secondNumber));

                } catch (InputMismatchException e) {
                    System.out.println("Son kiritish kerak edi!");
                    scanner = new Scanner(System.in);
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Some exception. Try again");
                }
            }
        }catch (Exception e){

        }
    }
}
