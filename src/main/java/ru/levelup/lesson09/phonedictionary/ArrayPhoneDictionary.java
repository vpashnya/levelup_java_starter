package ru.levelup.lesson09.phonedictionary;

import ru.levelup.lesson09.abonentclasses.Abonent;
import ru.levelup.lesson09.abonentgenerators.AbstractAbonentFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;


public class ArrayPhoneDictionary<T> extends AbstractPhoneDictionary<T> {

    public ArrayPhoneDictionary(Collection<Abonent> source) {
        super(source);
        Abonent[] arrayAbonents = new Abonent[source.size()];
        int idx = 0;

        Iterator<Abonent> iterator = source.iterator();
        while (iterator.hasNext()) {
            arrayAbonents[idx++] = iterator.next();
        }
        abonents = (T) arrayAbonents;

    }

    public ArrayPhoneDictionary(int count, Random randomizer, AbstractAbonentFactory... abonentFactories) {
        super(null, count, randomizer, abonentFactories);

        long startTime = System.currentTimeMillis();

        Abonent[] arrayAbonents = new Abonent[count];
        for (int i = 0; i < count; i++) {
            arrayAbonents[i] = (abonentFactories[randomizer.nextInt(abonentFactories.length)].generateAbonent());
        }

        for (Abonent abonent : arrayAbonents) {
            for (Abonent contact : arrayAbonents) {
                if ((abonent != contact) && (randomizer.nextInt(100) == 0)) {
                    abonent.getContacts().add(contact);
                }
            }
        }
        abonents = (T) arrayAbonents;
        System.out.println(String.format("Наполнение справочника из %-10s абонентов на основе %-20s %-5s м.сек.",
                count, abonents.getClass().getSimpleName(), (System.currentTimeMillis() - startTime)));
    }

    @Override
    public void printMostPopularAbonents() {
        long startTime = System.currentTimeMillis();
        HashMap<Abonent, Integer> popularAbonents = new HashMap<>();
        for (Abonent abonent : (Abonent[]) abonents) {
            for (Abonent contact : abonent.getContacts()) {
                Integer cnt = popularAbonents.get(contact);
                if (cnt == null) {
                    cnt = 0;
                }
                popularAbonents.put(contact, cnt + 1);
            }
        }

        Integer max = 0;
        for (Integer val : popularAbonents.values()) {
            if (val > max) {
                max = val;
            }
        }

        System.out.println(String.format("Самый популярыне контакт встречаются %-5s раз, время поиска %-5s м.сек в справочнике на основе %s",
                max, (System.currentTimeMillis() - startTime), abonents.getClass().getSimpleName()));


    }
}

