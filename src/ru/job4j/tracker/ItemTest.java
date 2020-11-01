package ru.job4j.tracker;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ItemTest {
    @Test
    public void whenItemsSorting() {
        List<Item> items = Arrays.asList(
                new Item(4, "Fix bugs"),
                new Item(1, "Impl task"),
                new Item(2, "Reboot server")
        );

        Item result = items.get(1);
        Collections.sort(items);
        assertThat(result, is(items.get(0)));
    }

    @Test
    public void whenItemsSortingReverse() {
        List<Item> items = Arrays.asList(
                new Item(4, "Fix bugs"),
                new Item(1, "Impl task"),
                new Item(2, "Reboot server")
        );

        Item result = items.get(0);
        Collections.sort(items, Collections.reverseOrder());
        assertThat(result, is(items.get(0)));
    }
}