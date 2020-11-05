package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListToMapTest {
    public List<Student> students = List.of(new Student("Trump", 75),
            new Student("Biden", 55),
            new Student("Clinton", 30));

    @Test
    public void listToMap() {
        Map<String, Student> result = ListToMap.listToMap(students);
        Map<String, Student> expected = Map.of(
                "Trump", new Student("Trump", 75),
                "Biden", new Student("Biden", 55),
                "Clinton", new Student("Clinton", 30)
        );
        assertThat(result, is(expected));
    }
}