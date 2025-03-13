package ru.levelup.lesson04.convertertask.converters;

public class Celsius2Fahrenheit implements Converter {
    @Override
    public double convert(double temp) {
        return (temp*9d/5d)+32d;
    }

    @Override
    public double unConvert(double temp) {
        return (temp-32d)*5d/9d;
    }
}
