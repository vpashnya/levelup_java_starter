package ru.levelup.lesson04.convertertask.converters;

public enum Temperature {
    CELSIUS("цельсия"), KELVIN("кельвина"), FAHRENHEIT("фарингейта");

    Temperature(String rusCaption) {
        this.rusCaption = rusCaption;
    }

    String rusCaption;

    private static Converter cel2Kel = new Celsius2Kelvin();
    private static Converter cel2Fah = new Celsius2Fahrenheit();

    public static String convertDescription(double temp, Temperature t1, Temperature t2) {
        return temp + " градусов " + t1.rusCaption + " это " + convert(temp, t1, t2) + " градусов " + t2.rusCaption;
    }

    public static double convert(double temp, Temperature t1, Temperature t2) {
        if (t1 == t2) {
            return temp;
        }

        if ((t1 == CELSIUS) && (t2 == KELVIN)) {
            return cel2Kel.convert(temp);
        } else if ((t1 == CELSIUS) && (t2 == FAHRENHEIT)) {
            return cel2Fah.convert(temp);
        } else if ((t1 == FAHRENHEIT) && (t2 == CELSIUS)) {
            return cel2Fah.unConvert(temp);
        } else if ((t1 == FAHRENHEIT) && (t2 == KELVIN)) {
            return cel2Kel.convert(cel2Fah.unConvert(temp));
        } else if ((t1 == KELVIN) && (t2 == FAHRENHEIT)) {
            return cel2Fah.convert(cel2Kel.unConvert(temp));
        } else if ((t1 == KELVIN) && (t2 == CELSIUS)) {
            return cel2Kel.unConvert(temp);
        }

        return 0;
    }


}
