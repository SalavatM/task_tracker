package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}
