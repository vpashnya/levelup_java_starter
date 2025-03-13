package ru.levelup.lesson04.cartask.automobiles;

public final class Truck extends Automobile {
    @Override
    public boolean move(int distance) {
        return distance <= 1200;
    }
}
