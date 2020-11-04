package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        //сортировать по полю size
        Comparator<Attachment> comparator = new Comparator<>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getSize() - right.getSize();
            }
        };
        Arrays.sort(atts, comparator);
        System.out.println(Arrays.toString(atts));

        //сортировать строки по имени
        Comparator<Attachment> comparator2 = (left, right) -> (left.getName().compareTo(right.getName()));
        //Comparator<Attachment> comparator2 = Comparator.comparing(Attachment::getName);
        Arrays.sort(atts, comparator2);
        System.out.println(Arrays.asList(atts));

        //сортировать строки по убыванию длины
        Comparator<Attachment> comparator3 = (left, right) -> (right.getSize() - left.getSize());
        Arrays.sort(atts, comparator3);
        System.out.println(Arrays.asList(atts));

        //сортировать строки по имени по убыванию
        Comparator<Attachment> comparator4 = (left, right) -> {
            System.out.println("compare - " + right.getName() + " : " + left.getName());
            return right.getName().compareTo(left.getName());
        };
        Arrays.sort(atts, comparator4);
        System.out.println(Arrays.asList(atts));
    }
}