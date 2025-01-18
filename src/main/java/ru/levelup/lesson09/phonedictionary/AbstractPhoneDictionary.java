package ru.levelup.lesson09.phonedictionary;

import ru.levelup.lesson09.abonentclasses.Abonent;
import ru.levelup.lesson09.abonentgenerators.AbstractAbonentFactory;

import java.util.Collection;
import java.util.Random;

public abstract class AbstractPhoneDictionary<T> {
    protected T abonents;

    public AbstractPhoneDictionary(T abonents, int count, Random randomizer, AbstractAbonentFactory... abonentFactories) {
        this.abonents = abonents;
    }

    public <T> AbstractPhoneDictionary(T abonents, Collection<Abonent> source) {
    }

    public AbstractPhoneDictionary(Collection<Abonent> source) {
    }

    public T getAbonents() {
        return abonents;
    }

    abstract public void printMostPopularAbonents();

}
