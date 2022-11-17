package com.company.service;

import com.company.entity.User;

import java.util.ArrayList;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        User user = new User(
                7, "diyor", "123", List.of("Java", "Database")
        );
        System.out.println("user = " + user);

        // toJson = serialize
        // fromJson = deserialize

        User user2 = new User(
                8, "sardor", "456", List.of("Python", "Database")
        );
        System.out.println("user2 = " + user2);

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        System.out.println("userList = " + userList);
    }
}
