package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int capacity) {
        this.load = capacity;
    }

    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(2000);
        Battery second = new Battery(1000);
        System.out.println("first: " + first.load + ". second: " + second.load);
        first.exchange(second);
        System.out.println("first: " + first.load + ". second: " + second.load);
    }
}
