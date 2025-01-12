package ru.levelup.lesson07.automobiles;

public class Car extends Automobile {
    public Car(String regNumber, double width, double height, double length, double weight, double currentSpeed) {
        super(regNumber, width, height, length, weight, currentSpeed);
    }

    @Override
    public String toString() {
        return "Легковой автомобиль : " + super.toString();
    }
}
