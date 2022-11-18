package com.company.database;

import com.company.entity.Currency;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface Database {
    static List<Currency> getCurrencies() {
        try {
            URL url = new URL("https://cbu.uz/oz/arkhiv-kursov-valyut/json/");

            URLConnection urlConnection = url.openConnection();

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()))) {

                Gson gson = new Gson();

                Type type = new TypeToken<List<Currency>>() {
                }.getType();

                List<Currency> currencies = gson.fromJson(reader, type);

                return currencies;

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
