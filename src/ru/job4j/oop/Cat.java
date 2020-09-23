package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat gav = new Cat();
        String say = peppy.sound();
        System.out.println("Peppy says " + say);
        gav.eat("kotleta");
        gav.giveNick("gav");
        gav.show();
    }

    protected String sound() {
        String voice = "may-may";
        return voice;
    }

    public void show() {
        System.out.println(this.name + " " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }
}
