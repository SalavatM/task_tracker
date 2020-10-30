package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");

        //возвращает коллекцию java.util.Set, состоящую только из ключей
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }

        //возвращает коллекцию java.util.Set, состоящую из объекта Map.Entry (ключ + значение)
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }

        map.remove("parsentev@yandex.ru");
        System.out.println(map.size());
    }
}
