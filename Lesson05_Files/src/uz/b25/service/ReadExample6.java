package uz.b25.service;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class ReadExample6 {
    public static void main(String[] args) {
        File file = new File("files/ratings.txt");

        TreeMap<Integer, List<String>> map = new TreeMap<>(Collections.reverseOrder());

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file));
             PrintWriter writer = new PrintWriter("files/sort_ratings2.txt");) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("=");

                int rating = Integer.parseInt(split[1].trim());
                String name = split[0].trim();

                map.merge(rating, new ArrayList<>(List.of(name)),
                        (oldList, newList) -> {
                            oldList.addAll(newList);
                            return oldList;
                        });

            }

            System.out.println("map = " + map);

            for (Integer key : map.keySet()) {
                Collections.sort(map.get(key));
            }
            System.out.println("map = " + map);

            // write to file
            for (Integer rating : map.keySet()) {

                List<String> nameList = map.get(rating);

                for (String name : nameList) {
                    writer.println(String.format("%s = %d", name, rating));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
