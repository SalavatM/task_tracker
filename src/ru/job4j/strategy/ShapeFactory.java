package ru.job4j.strategy;

public class ShapeFactory {
    private final ShapeAbstFactory factory;

    public ShapeFactory(ShapeAbstFactory factory) {
        this.factory = factory;
    }

    public static Shape create(String name) {
        //Шаблон фабричный метод
        Shape shape = new Empty();
        if ("triangle".equals(name)) {
            shape = new Triangle();
        } else if ("square".equals(name)) {
            shape = new Square();
        }

        return shape;
    }

    public Shape createAbst(String name) {
        //Абстрактная фабрика
        Shape shape = factory.createEmpty();
        if ("triangle".equals(name)) {
            shape = factory.createTriangle();
        } else if ("rectangle".equals(name)) {
            shape = factory.createRectangle();
        }

        return shape;

    }

    public static void main(String[] args) {
        Shape shape = ShapeFactory.create("cycle");
    }
}
