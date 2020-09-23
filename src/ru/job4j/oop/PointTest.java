package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

class PointTest {

    @Test
    void when025Then5() {
        Point a3 = new Point(0, 0, 0);
        Point b3 = new Point(0, 2, 5);
        double result = a3.distance3d(b3);
        assertThat(result, closeTo(5, 0.5));
    }
}