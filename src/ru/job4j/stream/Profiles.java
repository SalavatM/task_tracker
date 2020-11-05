package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        List<Address> addresses = profiles.stream()
                .map(profile -> profile.getAddress())
                .collect(Collectors.toList()
                );
        addresses.forEach(System.out::println);
        return addresses;
    }

    public static List<Address> collectDistinct(List<Profile> profiles) {
        List<Address> addresses = profiles.stream()
                .map(profile -> profile.getAddress())
                .sorted(new AddressAscByCity())
                .distinct()
                .collect(Collectors.toList()
                );
        addresses.forEach(System.out::println);
        return addresses;
    }
}
