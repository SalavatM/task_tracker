package ru.job4j.stream;

import java.util.Comparator;

public class AddressAscByCity implements Comparator<Address> {
    public int compare(Address o1, Address o2) {
        return o1.getCity().compareTo(o2.getCity());
    }
}
