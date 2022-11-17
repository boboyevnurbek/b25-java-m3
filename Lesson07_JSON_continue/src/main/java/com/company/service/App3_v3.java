package com.company.service;

import com.company.entity.Book;
import com.company.entity.Todo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class App3_v3 {

    static String BASE_FOLDER = "src/main/resources";

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        // Java object to JSON file
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/todos");

            Todo[] todos = mapper.readValue(url, Todo[].class);

            for (Todo todo : todos) {
                System.out.println(todo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
