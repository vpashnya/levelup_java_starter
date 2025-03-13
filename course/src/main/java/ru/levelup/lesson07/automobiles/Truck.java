package ru.levelup.lesson07.automobiles;

public class Truck extends Automobile {
    public Truck(String regNumber, double width, double height, double length, double weight, double currentSpeed) {
        super(regNumber, width, height, length, weight, currentSpeed);
    }

    @Override
    public String toString() {
        return "Грузовой автомобиль : " + super.toString();
    }
}
