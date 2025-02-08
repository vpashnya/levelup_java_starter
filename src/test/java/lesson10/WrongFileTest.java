package lesson10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelup.lesson10.WordCountRunner;

import java.io.IOException;

@DisplayName("Занятие 10. Откртыие файла")
public class WrongFileTest {
    @Test
    @DisplayName("Исключение не гасится при неверном имени файла")
    public void throwIOExceptionTest(){
        Assertions.assertThrows(IOException.class, ()->{
            WordCountRunner.main(new String[]{"wrong file name"});
        });
    }
}
