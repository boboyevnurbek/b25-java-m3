package com.company.service;

import com.company.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class App3 {

    static String BASE_FOLDER = "src/main/resources";

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();


        // Java object to JSON file
        try {
            Book book = mapper.readValue(new File(BASE_FOLDER, "book.json"), Book.class);

            System.out.println("book = " + book);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
