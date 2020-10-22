package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output), new ShowAllAction(), new EditAction(), new DeleteAction(),
                new FindByIdAction(), new FindByNameAction(), new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
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

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public void initOld(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(input.askStr("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);

            } else if (select == 1) {
                StartUI.showAllItems(tracker);

            } else if (select == 2) {
                StartUI.editItem(input, tracker);

            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);

            } else if (select == 4) {
                StartUI.findItemById(input, tracker);

            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);

            } else if (select == 6) {
                StartUI.replaceItem(input, tracker);

            } else if (select == 7) {
                System.out.println("=== Exit Program ====");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Update item");
        System.out.println("7. Exit Program");
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Tracker tracker) {
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
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        String idStr = input.askStr("Enter id: ");
        int id = Integer.parseInt(idStr);
        Item item = tracker.findById(id);
        if (item != null) {
            String name = input.askStr("Enter name: ");
            Item newItem = new Item(name);
            if (tracker.replace(id, newItem)) {
                System.out.println("Успешная замена");
            } else {
                System.out.println("Неудачная попытка замены");
            }
        } else {
            System.out.println("Не найдена заявка с индексом " + id);
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        String idStr = input.askStr("Enter id: ");
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
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        String idStr = input.askStr("Enter id: ");
        int id = Integer.parseInt(idStr);
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Не найдена заявка с индексом " + id);
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Не найдена заявка с именем " + name);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println(" === Update item ====");
        String idStr = input.askStr("Enter id:");
        String name = input.askStr("Enter a new name of item: ");
        Item item = new Item(name);
        int id = Integer.parseInt(idStr);
        item.setId(id);
        tracker.replace(id, item);
    }
}
