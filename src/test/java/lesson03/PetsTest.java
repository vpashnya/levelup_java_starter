package lesson03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelup.lesson03.pets.Cat;
import ru.levelup.lesson03.pets.Dog;
import ru.levelup.lesson03.pets.Parrot;

@DisplayName("Занятие 3. Домашние животные")
public class PetsTest {
    @Test
    @DisplayName("Невозможность создание очень старой кошки")
    public void createVeryOldCatTest() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            new Cat("Мурка", 100);

        });
    }

    @Test
    @DisplayName("Создание нормальной собаки")
    public void createNormalDogTest() {
        Assertions.assertDoesNotThrow(() -> {
            new Dog("Бобик", 1);
        });
    }

    @Test
    @DisplayName("Создание нормального попугая")
    public void createNormalParrot() {
        Assertions.assertDoesNotThrow(() -> {
            new Parrot("Кеша", 10, "Хочу в Африку");
        });
    }
}
