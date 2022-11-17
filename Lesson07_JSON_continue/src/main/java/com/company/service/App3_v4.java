package com.company.service;

import com.company.entity.Post;
import com.company.entity.Todo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class App3_v4 {

    static String BASE_FOLDER = "src/main/resources";

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        // Java object to JSON file
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");

            Post[] posts = mapper.readValue(url, Post[].class);

            for (Post post : posts) {
                System.out.println(post);
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
