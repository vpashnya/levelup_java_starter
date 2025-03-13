package ru.levelup.lesson04.convertertask;

import ru.levelup.lesson04.convertertask.converters.Temperature;

public class ConverterLauncher {
    public static void main(String[] args) {
        System.out.println(Temperature.convertDescription(0, Temperature.CELSIUS, Temperature.KELVIN));
        System.out.println(Temperature.convertDescription(0, Temperature.CELSIUS, Temperature.FAHRENHEIT));
        System.out.println(Temperature.convertDescription(0, Temperature.FAHRENHEIT, Temperature.CELSIUS));
        System.out.println(Temperature.convertDescription(0, Temperature.FAHRENHEIT, Temperature.KELVIN));
        System.out.println(Temperature.convertDescription(0, Temperature.KELVIN, Temperature.CELSIUS));
        System.out.println(Temperature.convertDescription(0, Temperature.KELVIN, Temperature.FAHRENHEIT));

        System.out.println(Temperature.convertDescription(50, Temperature.CELSIUS, Temperature.KELVIN));
        System.out.println(Temperature.convertDescription(50, Temperature.CELSIUS, Temperature.FAHRENHEIT));
        System.out.println(Temperature.convertDescription(50, Temperature.FAHRENHEIT, Temperature.CELSIUS));
        System.out.println(Temperature.convertDescription(50, Temperature.FAHRENHEIT, Temperature.KELVIN));
        System.out.println(Temperature.convertDescription(50, Temperature.KELVIN, Temperature.CELSIUS));
        System.out.println(Temperature.convertDescription(50, Temperature.KELVIN, Temperature.FAHRENHEIT));

        System.out.println(Temperature.convertDescription(100, Temperature.CELSIUS, Temperature.KELVIN));
        System.out.println(Temperature.convertDescription(100, Temperature.CELSIUS, Temperature.FAHRENHEIT));
        System.out.println(Temperature.convertDescription(100, Temperature.FAHRENHEIT, Temperature.CELSIUS));
        System.out.println(Temperature.convertDescription(100, Temperature.FAHRENHEIT, Temperature.KELVIN));
        System.out.println(Temperature.convertDescription(100, Temperature.KELVIN, Temperature.CELSIUS));
        System.out.println(Temperature.convertDescription(100, Temperature.KELVIN, Temperature.FAHRENHEIT));

    }
}
