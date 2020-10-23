package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.item.TrackerSingle3;

import java.util.Arrays;

//Lazy loading
public class Tracker3 {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private Tracker3() {
    }

    public static Tracker3 getInstance() {
        return Tracker3.Holder.INSTANCE;
    }

    //объект класса находится в поле внутреннего класса
    private static final class Holder {
        private static final Tracker3 INSTANCE = new Tracker3();
    }

    public static void main(String[] args) {
        Tracker3 tracker = Tracker3.getInstance();
    }

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

    public Item findByIdOld(int id) {
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

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            int start = index + 1;
            int distPos = index;
            int length = size - index;
            System.arraycopy(items, start, items, distPos, length);
            items[size - 1] = null;
            size--;
            return true;
        } else {
            return false;
        }
    }
}
