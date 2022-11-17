package uz.b25.hw;

import java.util.*;

public class App1 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "bir");
        map.put(2, "ikki");
        map.put(3, "uch");
        map.put(4, "to'rt");

        System.out.println(map);

        ArrayList<String> list = new ArrayList<>(map.values());
        Collections.shuffle(list);

        int i = 0;
        for (Integer key : map.keySet()) {
            map.put(key, list.get(i++));
            //map.put(key, list.get(new Random().nextInt(list.size())));
        }

        System.out.println(map);
    }
}
