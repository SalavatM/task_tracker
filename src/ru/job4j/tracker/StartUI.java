package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime currentDateTime = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = currentDateTime.format(formatter);
        item.setName("ТекущаяДата");
        System.out.println("Текущие дата, день недели и время: " + currentDateTimeFormat);

        Tracker tracker = new Tracker();
        tracker.add(item);
        System.out.println("Созданное задание: " + item);

        Item itemFoundById = tracker.findById(1);
        System.out.println("Найденное по Id задание: " + itemFoundById);
    }
}
