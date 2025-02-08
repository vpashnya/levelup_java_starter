package lesson12;

import org.junit.jupiter.api.*;
import ru.levelup.lesson12.clients.CorparateClient;
import ru.levelup.lesson12.clients.PersonClient;
import ru.levelup.lesson12.reflectiongenerators.AccountGenerator;
import ru.levelup.lesson12.reflectiongenerators.ClientGenerator;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Занятие 12. Создание объектов через рефликсию")
public class ReflectionTest {
    static CorparateClient corparateClient1 = null;
    static PersonClient personClient1 = null;
    static PersonClient personClient2 = null;

    @Order(1)
    @Test
    @DisplayName("Создание клиентов через рефлексию")
    public void generateClientsTest() {
        Assertions.assertDoesNotThrow(() -> {
            corparateClient1 = ClientGenerator.generateCorp("OOO Рога и Копыта", "100011112", "123456789123");
            personClient1 = ClientGenerator.generatePerson1("Петров Афанасий Рэмович", "100011113", "НеПетров", "НеАфанасий", "НеРэмович");
            personClient2 = ClientGenerator.generatePerson2("100011114", "Болтов", "Томас", "Грызлович");
        });
    }

    @Order(2)
    @Test
    @DisplayName("Открытие счетов через рефлексию")
    public void generateAccountsTest() {
        Assertions.assertDoesNotThrow(() -> {
            AccountGenerator.generateCorparateAccount(corparateClient1);
            AccountGenerator.generatePersonAccount( personClient1);
            AccountGenerator.generatePersonAccount( personClient2);
        });
    }
}
