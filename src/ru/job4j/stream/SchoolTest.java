package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    List<Student> students = List.of(new Student("Trump", 75),
            new Student("Biden", 55),
            new Student("Clinton", 30));

    @Test
    public void whenScoreGreater70() {
        List<Student> result = School.collect(students, student -> student.getScore() >= 70);
        assertThat(result, is(List.of(new Student("Trump", 75))));
    }

    @Test
    public void whenScoreGreater50() {
        List<Student> result = School.collect(students, student -> student.getScore() >= 50 && student.getScore() < 70);
        assertThat(result, is(List.of(new Student("Biden", 55))));
    }

    @Test
    public void whenScoreGreater0() {
        List<Student> result = School.collect(students, student -> student.getScore() > 0 && student.getScore() < 50);
        assertThat(result, is(List.of(new Student("Clinton", 30))));
    }
}