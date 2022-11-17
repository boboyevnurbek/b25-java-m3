package com.company.service;

import com.company.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App2_v2 {

    static String BASE_FOLDER = "src/main/resources";

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        List<Book> bookList = new ArrayList<>();

        Book book = new Book(1, "Java", "Shoxrux");
        bookList.add(book);
        bookList.add(new Book(2, "Java", "Ali"));
        bookList.add(new Book(3, "Python", "Ali"));

        // Java object to JSON file
        try {
            mapper.writeValue(new File(BASE_FOLDER, "books.json"), bookList);

            // Java object to JSON string, default compact-print
            String jsonString = mapper.writeValueAsString(bookList);
            System.out.println("jsonString = " + jsonString);

            // pretty-print
            String jsonString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookList);
            System.out.println("jsonString2 = " + jsonString2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
