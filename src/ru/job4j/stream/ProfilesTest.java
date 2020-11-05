package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    Address address1 = new Address("Moscow", "Kremlin", 1, 1);
    Address address2 = new Address("Washington", "White House", 5, 2);
    Address address3 = new Address("London", "Downing Street", 10, 0);
    Address address4 = new Address("Moscow", "Kremlin", 1, 1);

    @Test
    public void profilesList() {
        List<Profile> profiles = List.of(new Profile(address1), new Profile(address2), new Profile(address3));
        List<Address> result = Profiles.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(address1);
        expected.add(address2);
        expected.add(address3);
        assertThat(result, is(expected));
    }

    @Test
    public void profilesDistinctList() {
        List<Profile> profiles = List.of(new Profile(address1), new Profile(address2),
                new Profile(address3), new Profile(address4));
        List<Address> result = Profiles.collectDistinct(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(address3);
        expected.add(address1);
        expected.add(address2);
        assertThat(result, is(expected));
    }
}