package com.company.service;

import com.company.entity.User;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class App3 {
    static class LocalDateAdapter implements JsonSerializer<LocalDate> {

        public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
        }
    }

    public static void main(String[] args) {
        User user = new User(
                7, "diyor", null, List.of("Java", "Database")
        );
        //user.setBirthDate(LocalDate.of(2007, 2, 17));
        System.out.println("user = " + user);

        // GSON, Jackson, json-simple, org.json, ...

        //Gson gson = new Gson();
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        String json = gson.toJson(user);
        System.out.println("json = " + json);

        String myJsonObject = "{\n" +
                "  \"id\": 75,\n" +
                "  \"username\": \"diyorbek\",\n" +
                "  \"password\": \"9999\",\n" +
                "  \"subjects\": [\n" +
                "    \"C++\",\n" +
                "    \"C#\"\n" +
                "  ],\n" +
                "  \"birthDate\": \"2017-07-17\"\n" +
                "}";

        User otherUser = gson.fromJson(myJsonObject, User.class);
        System.out.println("otherUser = " + otherUser);
    }
}
