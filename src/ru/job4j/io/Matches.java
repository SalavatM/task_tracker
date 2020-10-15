package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int matches = 11;
        System.out.println("Игра 11");
        while (run) {
            System.out.println("Введите число от 1 до 3:");
            int select = Integer.valueOf(input.nextLine());
            if (select == 1 || select == 2 || select == 3) {
                matches -= select;
                System.out.println("Осталось спичек: " + (matches < 0 ? 0 : matches));
                if (matches <= 0) {
                    System.out.println("Игра завершена!");
                    run = false;
                }
            } else {
                System.out.println("Введено неверное число");
            }
        }
    }
}
