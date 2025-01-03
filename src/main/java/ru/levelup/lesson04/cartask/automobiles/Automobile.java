package ru.levelup.lesson04.cartask.automobiles;

public abstract class Automobile {
    public abstract boolean move(int distance);

    public String toString() {
        return this.getClass().getSimpleName();
    }
}
