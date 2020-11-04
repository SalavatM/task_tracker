package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CountingInRange {
    private static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> res = new ArrayList<>();
        for (int i = start; i < end; i++) {
            res.add(func.apply((double) i));
        }
         return res;
    }

    public static List<Double> function(int start, int end, Function<Double, Double> func) {
        return diapason(start, end, func);
    }

    public static List<Double> linearFunc(int start, int end) {
        Function<Double, Double> func = x -> 2 * x + 1;
        return diapason(start, end, func);
    }

    public static List<Double> quadraticFunc(int start, int end) {
        Function<Double, Double> func = x -> x * x;
        return diapason(start, end, func);
    }

    public static List<Double> exponentialFunc(int start, int end) {
        Function<Double, Double> func = x -> Math.pow(2, x);
        return diapason(start, end, func);
    }

    public static void main(String[] args) {
        System.out.println(linearFunc(5, 8));
        System.out.println(quadraticFunc(5, 8));
        System.out.println(exponentialFunc(5, 8));
        System.out.println(function(5, 8, x -> 2 * x + 1));
    }
}
