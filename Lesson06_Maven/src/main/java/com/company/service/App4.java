package com.company.service;

import com.company.entity.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class App4 {
    static String BASE_FOLDER = "src/main/resources";
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(UUID.randomUUID(), "Java",
                "Asad", 50d));
        bookList.add(new Book(UUID.randomUUID(), "JavaScript",
                "Sobir", 30d));
        bookList.add(new Book(UUID.randomUUID(), "Java",
                "Sobir", 50d));

        // write bookList to books.json file

        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();

        File file = new File(BASE_FOLDER, "books.json");

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.write(gson.toJson(bookList));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
