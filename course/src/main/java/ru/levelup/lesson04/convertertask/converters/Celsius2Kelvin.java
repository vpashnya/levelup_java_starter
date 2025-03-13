package ru.levelup.lesson04.convertertask.converters;

public class Celsius2Kelvin implements Converter {
    @Override
    public double convert(double temp) {
        return temp + 273.15;
    }

    @Override
    public double unConvert(double temp) {
        return temp - 273.15;
    }
}
