package ru.job4j.tracker.item;

import ru.job4j.tracker.Item;

//вариант реализации шаблона singleton с помощью явного обращения к объекту: Lazy loading
public class TrackerSingle3 {
    private TrackerSingle3() {
    }

    public static TrackerSingle3 getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    //объект класса находится в поле внутреннего класса
    private static final class Holder {
        private static final TrackerSingle3 INSTANCE = new TrackerSingle3();
    }

    public static void main(String[] args) {
        TrackerSingle3 tracker = TrackerSingle3.getInstance();
    }
}
