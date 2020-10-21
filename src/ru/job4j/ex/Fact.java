package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        int n = -5;
        System.out.println("Факториал " + n + " равен " + calc(n));
    }

    public static int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument must be > 0");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
