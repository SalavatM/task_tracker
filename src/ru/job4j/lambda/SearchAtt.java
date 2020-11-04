package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> func = new Predicate<>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 50;
            }
        };
        //Anonymous new Predicate<>() can be replaced with lambda
        //Predicate<Attachment> func = attachment -> attachment.getSize() > 50;
        return filter(list, func);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> func = new Predicate<>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        //Anonymous new Predicate<>() can be replaced with lambda
        //Predicate<Attachment> func = attachment -> attachment.getName().contains("bug");
        return filter(list, func);
    }

    private static List<Attachment> filter(List<Attachment> attachments, Predicate<Attachment> func) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment attachment : attachments) {
            if (func.test(attachment)) {
                rsl.add(attachment);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("bug", 13)
        );
        System.out.println(filterSize(attachments));
        System.out.println(filterName(attachments));
    }
}
