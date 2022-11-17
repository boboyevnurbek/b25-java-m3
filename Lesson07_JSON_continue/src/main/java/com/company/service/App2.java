package com.company.service;

import com.company.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class App2 {

    static String BASE_FOLDER = "src/main/resources";

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        Book book = new Book(1, null, "Shoxrux");

        // Java object to JSON file
        try {
           // mapper.writeValue(new File(BASE_FOLDER, "book.json"), book);

            // Java object to JSON string, default compact-print
            String jsonString = mapper.writeValueAsString(book);
            System.out.println("jsonString = " + jsonString);

            // pretty-print
            String jsonString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(book);
            System.out.println("jsonString2 = " + jsonString2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
