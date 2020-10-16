package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Replace item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String idStr = input.askStr("Enter id:");
        String name = input.askStr("Enter a new name of item: ");
        Item item = new Item(name);
        int id = Integer.parseInt(idStr);
        item.setId(id);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка " + id + " заменена");
        } else {
            System.out.println("Неудачная попытка замены");
        }
        return true;
    }
}
