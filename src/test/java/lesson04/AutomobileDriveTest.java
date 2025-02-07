package lesson04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelup.lesson04.cartask.automobiles.Car;
import ru.levelup.lesson04.cartask.automobiles.Truck;

@DisplayName("Занятие 4. Машины не могут проехать больше положеного")
public class AutomobileDriveTest {

    @Test
    @DisplayName("легковая")
    public void carDriveTest(){
        Assertions.assertTrue(new Car().move(400));
    }

    @Test
    @DisplayName("грузовая")
    public void truckDriveTest(){
        Assertions.assertTrue(new Truck().move(4000));
    }
}
