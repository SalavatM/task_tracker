package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ItemSorter {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(4, "Fix bugs"),
                new Item(1, "Impl task"),
                new Item(2, "Reboot server")
        );
        System.out.println(items);
        Collections.sort(items);
        System.out.println(items);
        Collections.sort(items, Collections.reverseOrder());
        System.out.println(items);
        Collections.sort(items, new ItemSortByName());
        System.out.println(items);
        Collections.sort(items, new ItemSortByName().reversed());
        System.out.println(items);
    }
}
