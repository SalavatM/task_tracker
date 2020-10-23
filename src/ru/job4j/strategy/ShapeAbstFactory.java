package ru.job4j.strategy;

//Абстрактная фабрика
public interface ShapeAbstFactory {
    Triangle createTriangle();

    Square createRectangle();

    Empty createEmpty();
}
