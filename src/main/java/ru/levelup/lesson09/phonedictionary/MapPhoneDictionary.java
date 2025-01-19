package ru.levelup.lesson09.phonedictionary;

import ru.levelup.lesson09.abonentclasses.Abonent;
import ru.levelup.lesson09.abonentgenerators.AbstractAbonentFactory;

import java.util.Map;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.HashMap;

public class MapPhoneDictionary<T extends Map<String, Abonent>> extends AbstractPhoneDictionary<T> {

    public MapPhoneDictionary(T abonents, Collection<Abonent> source) {
        super(abonents, source);
        this.abonents = abonents;
        Iterator<Abonent> iterator = source.iterator();
        while (iterator.hasNext()) {
            Abonent abonent = iterator.next();
            abonents.put(abonent.getPhoneNumber(), abonent);
        }

    }

    public MapPhoneDictionary(T abonents, int count, Random randomizer, AbstractAbonentFactory... abonentFactories) {
        super(abonents, count, randomizer, abonentFactories);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            Abonent abonent = abonentFactories[randomizer.nextInt(abonentFactories.length)].generateAbonent();
            abonents.put(abonent.getPhoneNumber(), abonent);
        }

        for (Abonent abonent : abonents.values()) {
            for (Abonent contact : abonents.values()) {
                if ((abonent != contact) && (randomizer.nextInt(100) == 0)) {
                    abonent.getContacts().add(contact);
                }
            }
        }
        System.out.println(String.format("Наполнение справочника из %-10s абонентов на основе %-20s %-5s м.сек.", count, abonents.getClass().getSimpleName(), (System.currentTimeMillis() - startTime)));
    }

    @Override
    public void printMostPopularAbonents() {
        long startTime = System.currentTimeMillis();
        HashMap<Abonent, Integer> popularAbonents = new HashMap<>();
        for (Abonent abonent : abonents.values()) {
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

