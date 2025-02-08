package lesson06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ru.levelup.lesson06.generics.GenericExample;
import ru.levelup.lesson06.taskclasses.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Занятие 6. Проверяем что удачно создается дженерик с разными классами")
public class GenericTest {

    @Test
    @DisplayName("Создаем пса")
    @Order(1)
    public void createDogTest() {
        Assertions.assertDoesNotThrow(() -> {
            GenericExample<String, Animal, Integer> dogInfo = new GenericExample<>("Пес", new Dog(), 12);
        });
    }

    @Test
    @DisplayName("Создаем коня")
    @Order(2)
    public void createHourseTest() {
        Assertions.assertDoesNotThrow(() -> {
            GenericExample<String, Animal, Long> hourseInfo = new GenericExample<>("Конь", new Horse(), 34L);
        });
    }

    @Test
    @DisplayName("Создаем кота")
    @Order(3)
    public void createCatTest() {
        Assertions.assertDoesNotThrow(() -> {
            GenericExample<StringBuffer, Animal, Float> catInfo = new GenericExample<>(new StringBuffer("Кошка"), new Cat(), 56.78F);
        });
    }

    @Test
    @DisplayName("Создаем хомяка")
    @Order(4)
    public void createHumsterTest() {
        Assertions.assertDoesNotThrow(() -> {
            GenericExample<StringBuilder, Animal, Double> hamsterInfo = new GenericExample<>(new StringBuilder("Хомяк"), new Hamster(), 90.12D);
        });
    }

}
