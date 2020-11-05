package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public static Map<String, Student> listToMap(List<Student> students) {
        Map<String, Student> studentMap =
                students.stream().distinct()
                .collect(Collectors.toMap(e -> e.getSurname(), e -> e));
        return studentMap;
    }
}
