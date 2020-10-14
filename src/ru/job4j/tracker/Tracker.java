package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    public Item findById_old(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
            if (item != null) {
                itemsWithoutNull[size] = item;
                size++;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
        return itemsWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] itemsMatchName = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
             if (item != null && item.getName().equals(key)) {
                itemsMatchName[size] = item;
                size++;
            }
        }
        itemsMatchName = Arrays.copyOf(itemsMatchName, size);
        return itemsMatchName;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        } else {
            return false;
        }
    }
}
