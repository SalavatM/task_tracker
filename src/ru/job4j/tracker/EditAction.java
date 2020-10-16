package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
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
        return true;
    }
}
