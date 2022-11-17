package com.company.service2;

import com.company.entity.Currency;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.LinkedList;

public class App1 {
    public static void main(String[] args) {
        Currency currency = new Currency();
        currency.setId(100);
        currency.setCode("111");
        currency.setCcy("ABC");
        currency.setRate("150");

        System.out.println("currency = " + currency);

        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

        String json = gson.toJson(currency);
        System.out.println("json = " + json);

        System.out.println();
        json = "{\n" +
                "  \"Code\": \"111\",\n" +
                "  \"id\": 2000,\n" +
                "  \"Ccy\": \"ABC\",\n" +
                "  \"Rate\": \"150\"\n" +
                "}";

        System.out.println("json = " + json);
        Currency currency1 = gson.fromJson(json, Currency.class);
        System.out.println("currency1 = " + currency1);

    }
}
