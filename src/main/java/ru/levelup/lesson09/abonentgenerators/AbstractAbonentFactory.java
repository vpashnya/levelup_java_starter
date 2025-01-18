package ru.levelup.lesson09.abonentgenerators;

import ru.levelup.lesson09.abonentclasses.Abonent;
import ru.levelup.lesson09.abonentclasses.Operator;

import java.util.Random;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class AbstractAbonentFactory<T extends Collection<Abonent>> {
    private Random randomizer;

    final private List<String> surNames;
    final private List<String> names;
    final private List<String> fatherNames;

    final TreeSet<String> uniqFullNames = new TreeSet<>();
    final TreeSet<String> uniqPhoneNumbers = new TreeSet<>();

    final T contactsPattern;

    public AbstractAbonentFactory(Random randomizer, List<String> surNames, List<String> names, List<String> fatherNames, T contactsPattern) {
        this.randomizer = randomizer;
        this.surNames = surNames;
        this.names = names;
        this.fatherNames = fatherNames;
        this.contactsPattern = contactsPattern;
    }

    private String generateFullName() {
        String fullname = surNames.get(randomizer.nextInt(surNames.size()))
                + " " + names.get(randomizer.nextInt(names.size()))
                + " " + fatherNames.get(randomizer.nextInt(fatherNames.size()));

        return fullname;
    }

    private String generateNumber(Operator operator) {
        String prefix = operator.getPrefixs()[randomizer.nextInt(operator.getPrefixs().length)];
        return prefix + Integer.toString(randomizer.nextInt(100000) + 100000).substring(1, 5);
    }

    public Abonent generateAbonent() {
        String fullname = null;
        do {
            if (fullname != null) {
                System.out.println("Повторная генерация ФИО " + fullname);
            }
            fullname = generateFullName();
        } while (uniqFullNames.contains(fullname));

        Operator operator = Operator.values()[randomizer.nextInt(Operator.values().length)];

        String phoneNumber = null;
        do {
            if (phoneNumber != null) {
                System.out.println("Повторная генерация ноиера " + phoneNumber);
            }
            phoneNumber = generateNumber(operator);
        } while (uniqPhoneNumbers.contains(phoneNumber));

        Collection<Abonent> contacts = null;
        if (contactsPattern instanceof LinkedList<?>) {
            contacts = new LinkedList<>();
        } else if (contactsPattern instanceof ArrayList<?>) {
            contacts = new ArrayList<>();
        } else if (contactsPattern instanceof TreeSet<?>) {
            contacts = new TreeSet<>();
        } else if (contactsPattern instanceof HashSet<?>) {
            contacts = new HashSet<>();
        }


        return new Abonent(fullname, phoneNumber, operator, contacts);

    }
}
