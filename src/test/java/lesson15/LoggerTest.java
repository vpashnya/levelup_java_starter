package lesson15;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.levelup.lesson15.loggerutils.LogType;
import ru.levelup.lesson15.loggerutils.Logger;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

@DisplayName("Занятие 15. Проверим логирование")
public class LoggerTest {

    static AtomicBoolean runFlag;
    static Random random;
    static Appendable writer;
    static Logger logger;

    @BeforeAll
    public static void createLogger() {
        runFlag = new AtomicBoolean(true);
        random = new Random();
        writer = Mockito.mock(Appendable.class);
        logger = new Logger(random, runFlag, writer);
    }

    @SneakyThrows
    @Test
    @DisplayName("Количество обращений к врайтеру (внутри логгера) равно количество обращений к логгеру, после 5 секунд когда отработают потоки")
    public void countLogCallsWriterTest() {


        final int CALLS_COUNT = random.nextInt(100);
        for (int i = 0; i < CALLS_COUNT; i++) {
            logger.putMessage(LogType.values()[i % 5], Integer.toString(i % 10));
        }
        Thread.sleep(5000);

        Mockito.verify(writer, Mockito.times(CALLS_COUNT)).append(Mockito.any(String.class));
    }

    @SneakyThrows
    @Test
    @DisplayName("Количество обращений к переопределенному методу равно 3")
    public void countLogCallsTest() {

        Logger spyLogger = Mockito.spy(logger);
        Mockito.doNothing().when(spyLogger).putMessage(Mockito.any(LogType.class), Mockito.any(String.class));

        spyLogger.putMessage(LogType.DEBUG,"");
        spyLogger.putMessage(LogType.DEBUG,"");
        spyLogger.putMessage(LogType.DEBUG,"");


        Mockito.verify(spyLogger, Mockito.times(3)).putMessage(Mockito.any(LogType.class), Mockito.any(String.class));
    }

    @AfterAll
    public static void closeLogger(){
        runFlag.set(false);
        logger.close();
    }
}
