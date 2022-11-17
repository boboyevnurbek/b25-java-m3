package com.company.files;

import com.company.entity.Todo;
import com.company.entity.User;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WorkWithFiles {
    public static List<Todo> getTodos(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Todo[] todos = mapper.readValue(
                    new URL("https://jsonplaceholder.typicode.com/todos"), Todo[].class);

            return new ArrayList<Todo>(List.of(todos));
        } catch (IOException e) {

        }
        return new ArrayList<>();
    }

    public static List<User> getUsers(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            User[] users = mapper.readValue(
                    new URL("https://jsonplaceholder.typicode.com/users"), User[].class);

            return new ArrayList<>(List.of(users));
        } catch (IOException e) {

        }
        return new ArrayList<>();
    }
}
