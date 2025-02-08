package lesson11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelup.lesson11.FileReadRunner;

import java.time.Duration;

@DisplayName("Занятие 11. Реверс файла ")
public class FileReaderReverseTest {
    @Test
    @DisplayName("Реверс укладывается в допустимое время")
    public void reverseTest() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(500), () -> {
            FileReadRunner.main(new String[]{"C:\\Users\\user\\Desktop\\pvn.log", "C:\\Users\\user\\Desktop\\xpvn.log"});
        });
    }

}
