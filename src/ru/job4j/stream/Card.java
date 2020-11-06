package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        //заполнение в потоке
        List<Card> cards = Stream.of(Suit.values())
                        .flatMap(suits -> Stream.of(Value.values())
                        .map(values -> new Card(suits, values)))
                        .collect(Collectors.toList());
        cards.forEach(System.out::println);

        //заполнение в цикле
        List<Card> cards2 = new ArrayList<>(Suit.values().length * Value.values().length);
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                cards2.add(new Card(suit, value));
            }
        }
        cards2.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Card{" + "suit=" + suit + ", value=" + value + '}';
    }
}