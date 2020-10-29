package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    //private final Item[] items = new Item[100];
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            //if (items[index].getId() == id) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        //items[size++] = item;
        items.add(item);
        size++;
        return item;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items.get(index) : null;
    }

    public Item findByIdOld(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items.get(index);
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.size()];
        int size = 0;
        for (int index = 0; index < items.size(); index++) {
            Item item = items.get(index);
            if (item != null) {
                itemsWithoutNull[size] = item;
                size++;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
        return itemsWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] itemsMatchName = new Item[items.size()];
        int size = 0;
        for (int index = 0; index < items.size(); index++) {
            Item item = items.get(index);
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
            items.set(index, item);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
//            int start = index + 1;
//            int distPos = index;
//            int length = size - index;
//            System.arraycopy(items, start, items, distPos, length);
//            Item item = items.get(size - 1);
//            item = null;
            size--;
            return true;
        } else {
            return false;
        }
    }
}
