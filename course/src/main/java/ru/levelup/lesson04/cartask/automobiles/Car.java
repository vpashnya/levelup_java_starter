package ru.levelup.lesson04.cartask.automobiles;

public final class Car extends Automobile {
    @Override
    public boolean move(int distance) {
        return distance <= 500;
    }
}
