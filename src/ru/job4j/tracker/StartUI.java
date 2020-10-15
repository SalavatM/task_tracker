package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
//        Item item = new Item();
//        LocalDateTime currentDateTime = item.getCreated();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
//        String currentDateTimeFormat = currentDateTime.format(formatter);
//        item.setName("Заявка 1");
//        System.out.println("Текущие дата, день недели и время: " + currentDateTimeFormat);
//
//        Tracker tracker = new Tracker();
//        tracker.add(item);
//        System.out.println("Созданная заявка: " + item);
//
//        Item itemFoundById = tracker.findById(1);
//        System.out.println("Найденная по Id заявка: " + itemFoundById);
    }

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Нет заявок");
                    System.out.println();
                }

            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Enter id: ");
                String idStr = scanner.nextLine();
                int id = Integer.parseInt(idStr);
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item newItem = new Item(name);
                    if (tracker.replace(id, newItem)) {
                        System.out.println("Успешная замена");
                    } else {
                        System.out.println("Неудачная попытка замены");
                    }
                } else {
                    System.out.println("Не найдена заявка с индексом " + id);
                }

            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter id: ");
                String idStr = scanner.nextLine();
                int id = Integer.parseInt(idStr);
                Item item = tracker.findById(id);
                if (item != null) {
                    if (tracker.delete(id)) {
                        System.out.println("Заявка " + id + " удалена");
                    } else {
                        System.out.println("Неудачная попытка удаления");
                    }
                } else {
                    System.out.println("Не найдена заявка с индексом " + id);
                }

            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Enter id: ");
                String idStr = scanner.nextLine();
                int id = Integer.parseInt(idStr);
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Не найдена заявка с индексом " + id);
                }

            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items.length != 0) {
                    for (Item item: items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Не найдена заявка с именем " + name);
                }

            } else if (select == 6) {
                System.out.println("=== Exit Program ====");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        /* добавить остальные пункты меню. */
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }
}
