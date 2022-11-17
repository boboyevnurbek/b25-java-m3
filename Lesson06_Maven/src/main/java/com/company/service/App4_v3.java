package com.company.service;

import com.company.entity.Book;
import com.company.util.ScannerUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class App4_v3 {
    static String BASE_FOLDER = "src/main/resources";

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();

        File file = new File(BASE_FOLDER, "books.json");

        List<Book> bookList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            Type type = new TypeToken<List<Book>>() {
            }.getType();

            bookList = gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (bookList == null || bookList.isEmpty()) {
            System.out.println("no books for edit");
            return;
        }

        bookList.forEach(System.out::println);

        System.out.println("Enter book id");
        UUID bookId = UUID.fromString(ScannerUtil.SCANNER_STR.nextLine());

        Book book = bookList.stream()
                .filter(book1 -> book1.getId().equals(bookId))
                .findFirst().orElse(null);

        if(book == null){
            System.out.println("Book not found");
            return;
        }

        System.out.println("Enter title");
        String title = ScannerUtil.SCANNER_STR.nextLine();
        System.out.println("Enter author");
        String author = ScannerUtil.SCANNER_STR.nextLine();
        System.out.println("Enter price");
        double price = ScannerUtil.SCANNER_NUM.nextDouble();

        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.write(gson.toJson(bookList));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
