package lesson09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelup.lesson09.abonentclasses.Abonent;
import ru.levelup.lesson09.abonentgenerators.FemaleAbonentFactrory;
import ru.levelup.lesson09.abonentgenerators.MaleAbonentFactory;
import ru.levelup.lesson09.phonedictionary.CollectionPhoneDictionary;
import ru.levelup.lesson09.phonedictionary.MapPhoneDictionary;

import java.time.Duration;
import java.util.*;

@DisplayName("Занятие 9. Поиск самого популярного абонента")
public class FindPopularAbonentTest {

    static int count = 25000;
    static Random randomizer = new Random();
    static CollectionPhoneDictionary<Collection<Abonent>> source = null;

    @BeforeAll
    public static void initSourceCollection() {
        FemaleAbonentFactrory femaleAbonentFactrory = new FemaleAbonentFactrory(randomizer, new LinkedList<Abonent>());
        MaleAbonentFactory maleAbonentFactory = new MaleAbonentFactory(randomizer, new LinkedList<Abonent>());

        source = new CollectionPhoneDictionary<>(new ArrayList<>(), count, randomizer, femaleAbonentFactrory, maleAbonentFactory);
    }

    @Test
    @DisplayName("поиск в LinkedList")
    public void findInLinkedListTest() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(500), () -> {
            new CollectionPhoneDictionary<>(new LinkedList<>(), source.getAbonents()).printMostPopularAbonents();
        });
    }

    @Test
    @DisplayName("поиск в TreeSet")
    public void findInTreeSetTest() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(500), () -> {
            new CollectionPhoneDictionary<>(new TreeSet<>(), source.getAbonents()).printMostPopularAbonents();
        });
    }

    @Test
    @DisplayName("поиск в HashMap")
    public void findInHashMapTest() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(500), () -> {
            new MapPhoneDictionary<>(new HashMap<>(), source.getAbonents()).printMostPopularAbonents();
        });
    }

    @Test
    @DisplayName("поиск в TreeMap")
    public void findInTreeMapTest() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(500), () -> {
            new MapPhoneDictionary<>(new TreeMap<>(), source.getAbonents()).printMostPopularAbonents();
        });
    }

}
