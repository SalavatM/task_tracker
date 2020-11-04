package ru.job4j.search;

import ru.job4j.lambda.Attachment;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /* Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подошедших пользователей. */
    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = person -> person.getAddress().contains(key)
                || person.getName().contains(key)
                || person.getPhone().contains(key)
                || person.getSurname().contains(key);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
