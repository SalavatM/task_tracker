package ru.job4j.tracker.item;

import ru.job4j.tracker.Item;

//вариант реализации шаблона singleton с помощью явного обращения к объекту: Lazy loading
//Ленивая загрузка (Lazy loading) происходит, когда мы явно обращаемся к объекту
public class TrackerSingle {
    private static TrackerSingle instance; //содержит экземпляр объекта

    private TrackerSingle() {
    }

    public static TrackerSingle getInstance() {
        if (instance == null) {
            instance = new TrackerSingle();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingle trackerSingle = new TrackerSingle();
    }
}
