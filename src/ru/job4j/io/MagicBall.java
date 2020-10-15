package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        int num = new Random().nextInt(3);
        if (num == 0) {
            System.out.println("Да");
        } else if (num == 1) {
            System.out.println("Нет");
        } else {
            System.out.println("Может быть");
        }
    }
}
