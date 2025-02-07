package lesson04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelup.lesson04.convertertask.converters.Temperature;

@DisplayName("Занятие 4. Конвертация  в кельвины всегда положительное число")
public class TempConverterTest {

    @Test
    @DisplayName(" цельсия -> кельвины")
    public void convertCelsius2KelvinIsTest() {
        Assertions.assertTrue((Temperature.convert(0, Temperature.CELSIUS, Temperature.KELVIN) > 0));

    }

    @Test
    @DisplayName(" фарингейт -> кельвины")
    public void convertFahrenheit2KelvinIsTest() {
        Assertions.assertTrue((Temperature.convert(0, Temperature.FAHRENHEIT, Temperature.KELVIN) > 0));
    }
}
