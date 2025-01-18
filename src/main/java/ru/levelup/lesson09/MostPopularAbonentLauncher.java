package ru.levelup.lesson09;

import ru.levelup.lesson09.abonentclasses.Abonent;
import ru.levelup.lesson09.abonentgenerators.FemaleAbonentFactrory;
import ru.levelup.lesson09.abonentgenerators.MaleAbonentFactory;
import ru.levelup.lesson09.phonedictionary.ArrayPhoneDictionary;
import ru.levelup.lesson09.phonedictionary.CollectionPhoneDictionary;
import ru.levelup.lesson09.phonedictionary.MapPhoneDictionary;

import java.util.*;


public class MostPopularAbonentLauncher {
    public static void main(String[] args) {

        testFindMostPopularAbonents(new TreeSet<Abonent>());
        testFindMostPopularAbonents(new HashSet<Abonent>());
        testFindMostPopularAbonents(new ArrayList<Abonent>());
        testFindMostPopularAbonents(new LinkedList<Abonent>());
    }

    public static void testFindMostPopularAbonents(Collection<Abonent> contactPattern ){
        int count = 25000;
        Random randomizer = new Random();
        FemaleAbonentFactrory femaleAbonentFactrory = new FemaleAbonentFactrory(randomizer, contactPattern);
        MaleAbonentFactory maleAbonentFactory = new MaleAbonentFactory(randomizer, contactPattern);

        CollectionPhoneDictionary<Collection<Abonent>> source = new CollectionPhoneDictionary<>(new ArrayList<>(), count, randomizer, femaleAbonentFactrory, maleAbonentFactory);

        System.out.println(">>>> Проверим время нахождение самых популярных абонентов в различных коллекциях");
        System.out.println("    контакты храняться  " + contactPattern.getClass().getSimpleName());
        new CollectionPhoneDictionary<>(new LinkedList<>(), source.getAbonents()).printMostPopularAbonents();
        new CollectionPhoneDictionary<>(new TreeSet<>(), source.getAbonents()).printMostPopularAbonents();
        new CollectionPhoneDictionary<>(new ArrayDeque<>(), source.getAbonents()).printMostPopularAbonents();

        new MapPhoneDictionary<>(new HashMap<>(), source.getAbonents()).printMostPopularAbonents();
        new MapPhoneDictionary<>(new TreeMap<>(), source.getAbonents()).printMostPopularAbonents();

        new ArrayPhoneDictionary(source.getAbonents()).printMostPopularAbonents();
    }
}
