package ru.job4j.tracker.item;

import ru.job4j.tracker.Item;

//вариант реализации шаблона singleton с помощью явного обращения к объекту: Eager loading
public class TrackerSingle2 {
    private static final TrackerSingle2 INSTANCE = new TrackerSingle2(); //сразу создаем и инициализируем объект

    private TrackerSingle2() {
    }

    public static TrackerSingle2 getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingle2 tracker = TrackerSingle2.getInstance();
    }
}
