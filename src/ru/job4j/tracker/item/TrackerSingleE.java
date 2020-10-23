package ru.job4j.tracker.item;

import ru.job4j.tracker.Item;

//вариант реализации шаблона singleton с помощью перечисления: Eager loading
//Энергичная загрузка (Eager loading) - загружает объект сразу после старта виртуальной машины
public enum TrackerSingleE {
    INSTANCE;

    // Конструкторы и методы.
    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        //Чтобы получить экземпляр класса нужно напрямую обратиться к полю INSTANCE
        TrackerSingleE trackerSingleE = TrackerSingleE.INSTANCE;
    }
}
