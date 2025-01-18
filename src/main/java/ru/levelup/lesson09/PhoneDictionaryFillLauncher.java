package ru.levelup.lesson09;

import ru.levelup.lesson09.abonentclasses.Abonent;
import ru.levelup.lesson09.abonentgenerators.FemaleAbonentFactrory;
import ru.levelup.lesson09.abonentgenerators.MaleAbonentFactory;
import ru.levelup.lesson09.phonedictionary.ArrayPhoneDictionary;
import ru.levelup.lesson09.phonedictionary.CollectionPhoneDictionary;
import ru.levelup.lesson09.phonedictionary.MapPhoneDictionary;

import java.util.*;

public class PhoneDictionaryFillLauncher {
    public static void main(String[] args) {
        int count = 10000;
        Random randomizer = new Random();
        FemaleAbonentFactrory femaleAbonentFactrory = new FemaleAbonentFactrory(randomizer, new TreeSet<Abonent>());
        MaleAbonentFactory maleAbonentFactory = new MaleAbonentFactory(randomizer, new TreeSet<Abonent>());

        System.out.println(">>>> Проверим время наполнения справочника на основе различных коллекций");

        new CollectionPhoneDictionary<>(new ArrayList<>(), count, randomizer, femaleAbonentFactrory, maleAbonentFactory);
        new CollectionPhoneDictionary<>(new LinkedList<>(), count, randomizer, femaleAbonentFactrory, maleAbonentFactory);
        new CollectionPhoneDictionary<>(new TreeSet<>(), count, randomizer, femaleAbonentFactrory, maleAbonentFactory);
        new CollectionPhoneDictionary<>(new ArrayDeque<>(), count, randomizer, femaleAbonentFactrory, maleAbonentFactory);

        new MapPhoneDictionary<>(new HashMap<>(), count, randomizer, femaleAbonentFactrory, maleAbonentFactory);
        new MapPhoneDictionary<>(new TreeMap<>(), count, randomizer, femaleAbonentFactrory, maleAbonentFactory);

        new ArrayPhoneDictionary(count, randomizer, femaleAbonentFactrory, maleAbonentFactory);



    }
}
