package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String idStr = input.askStr("Enter id: ");
        int id = Integer.parseInt(idStr);
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Не найдена заявка с индексом " + id);
        }
        return true;
    }
}
