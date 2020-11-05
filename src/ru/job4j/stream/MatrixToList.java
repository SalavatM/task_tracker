package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class MatrixToList {
    public static List<Integer> convert(List<List<Integer>> matrix) {
        List<Integer> res = matrix.stream().flatMap(List::stream).collect(Collectors.toList());
        return  res;
    }
}
