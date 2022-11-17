package com.company.service;

import com.company.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App3_v2 {

    static String BASE_FOLDER = "src/main/resources";

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();


        // Java object to JSON file
        try {
            Book[] books = mapper.readValue(new File(BASE_FOLDER, "books.json"), Book[].class);

            ArrayList<Book> bookList = new ArrayList<>(List.of(books));

            bookList.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
