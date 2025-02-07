package lesson08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelup.lesson08.employees.Employee;
import ru.levelup.lesson08.employeeutils.EmployeeUtils;

import java.time.Duration;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

@DisplayName("Занятие 8. Наполнение коллекций")
public class CollectionLauncherTest {
    @Test
    @DisplayName("Проверим скорость наполнения коллекции")
    public void collectionFillTest() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(5), () -> {
            Random randomizer = new Random();
            Collection<Employee> employees = new LinkedList<>();
            EmployeeUtils.fillEmployeeCollection(employees, 100, randomizer);
        });
    }

}
