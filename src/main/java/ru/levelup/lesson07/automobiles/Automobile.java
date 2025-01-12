package ru.levelup.lesson07.automobiles;

public abstract class Automobile {
    private double currentSpeed;
    private String regNumber;
    private double width;
    private double height;
    private double length;
    private double weight;

    private Automobile() {
    }

    public Automobile(String regNumber, double width, double height, double length, double weight, double currentSpeed) {
        this.regNumber = regNumber;
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.currentSpeed = currentSpeed;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return
                " рег. номер = '" + regNumber +
                        ", ширина = " + width + " м " +
                        ", высота = " + height + " м " +
                        ", длина = " + length + " м " +
                        ", вес = " + weight + " кг " +
                        ", скорость = " + currentSpeed + " км/ч"
                ;
    }
}
