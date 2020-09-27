package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Kashtanka", 100);
        Book book2 = new Book("Bezhin lug", 200);
        Book book3 = new Book("Voina i mir", 500);
        Book book4 = new Book("Clean code", 700);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int index = 0; index < books.length; index++) {
            Book b = books[index];
            System.out.println(b.getName() + " - " + b.getPages());
        }

        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int index = 0; index < books.length; index++) {
            Book b = books[index];
            System.out.println(b.getName() + " - " + b.getPages());
        }

        System.out.println("Shown only book with name 'Clean code'");
        for (int index = 0; index < books.length; index++) {
            Book b = books[index];
            if (b.getName().equals("Clean code")) {
                System.out.println(b.getName() + " - " + b.getPages());
            }
        }
    }
}
