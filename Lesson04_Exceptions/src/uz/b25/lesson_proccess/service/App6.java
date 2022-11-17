package uz.b25.lesson_proccess.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App6 {
    public static void main(String[] args) {
        // Klaviaturdan satr kiritiladi
        // nechanni indexdan boshlab nechangi indexgacha substring
        // olish uchun indexlar kiriitladi.

        // kerakli qismni ajratib ekranga chiqaring.

        // text = "Java backend B25", beginIndex=5, endIndex=11
        // result = "backend"

        Scanner textScanner = new Scanner(System.in);
        Scanner numberScanner = new Scanner(System.in);

        String text;
        while (true) {
            try {
                System.out.print("Satr kiriting: ");
                text = textScanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Satr kiritish kerak");
            }
        }
        int startIndex;
        while (true) {
            try {
                System.out.print("Nechanchi index dan substring qilmoqchisiz: ");
                startIndex = numberScanner.nextInt();

                break;
            } catch (InputMismatchException e) {
                numberScanner = new Scanner(System.in);
                System.out.println("Son kiritish kerak edi");
            }
        }
        int endIndex;
        while (true) {
            try {
                System.out.print("Nechanchi indexgacha olmoqshisiz");
                endIndex = numberScanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                numberScanner = new Scanner(System.in);
                System.out.println("son kiritish kerak edi");
            }
        }
        String newStr;
        try {
            newStr = text.substring(startIndex, endIndex);
            System.out.println(newStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
