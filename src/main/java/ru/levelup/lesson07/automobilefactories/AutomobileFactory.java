package ru.levelup.lesson07.automobilefactories;

import ru.levelup.lesson07.automobiles.Automobile;

import java.util.Random;

public abstract class AutomobileFactory {
    public abstract Automobile generateAutomobile();

    private static final char[] ALLOWED_CHARS = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};

    protected static String generateRegNumber() {
        Random random = new Random();
        String regNumber = ALLOWED_CHARS[random.nextInt(ALLOWED_CHARS.length)]
                + (""
                    + random.nextInt(10)
                    + random.nextInt(10)
                    + random.nextInt(10)
                    ).replace("000", "001")
                + ALLOWED_CHARS[random.nextInt(ALLOWED_CHARS.length)]
                + ALLOWED_CHARS[random.nextInt(ALLOWED_CHARS.length)]
                + random.nextInt(200)
                + "RUS";
        return regNumber;
    }

}
