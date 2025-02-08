package lesson07;

import org.junit.jupiter.api.*;
import ru.levelup.lesson07.automobiles.Car;
import ru.levelup.lesson07.automobiles.Truck;
import ru.levelup.lesson07.checkpoints.RoadCheckpoint;
import ru.levelup.lesson07.exceptions.Over2$5WidthException;


@DisplayName("Занятие 7. Отлов исключений")
public class ExceptionCatchTest {

    @Test
    @DisplayName("Ширина больше 2.5 метра")
    public void over2$5WidthTest() {
        Assertions.assertThrows(Over2$5WidthException.class, () -> {
            new RoadCheckpoint("").crossingCheckpoint(new Truck("000", 4d, 0, 0, 0, 0));
        });
    }

    @Test
    @DisplayName("Длина больше 4 метра")
    public void over4mHeightTest() {
        Assertions.assertThrows(Over2$5WidthException.class, () -> {
            new RoadCheckpoint("").crossingCheckpoint(new Truck("000", 4d, 3, 0, 0, 0));
        });
    }

    @Test
    @DisplayName("Скорость больше 100 км/ч")
    public void over100kmSpeedTest() {
        Assertions.assertThrows(Over2$5WidthException.class, () -> {
            new RoadCheckpoint("").crossingCheckpoint(new Car("000", 4d, 3, 0, 0, 111));
        });
    }


}
