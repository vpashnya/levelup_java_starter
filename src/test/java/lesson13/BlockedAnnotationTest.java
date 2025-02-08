package lesson13;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelup.lesson12.accounts.Account;
import ru.levelup.lesson12.accounts.CorparateAccount;
import ru.levelup.lesson12.clients.CorparateClient;
import ru.levelup.lesson13.AnnotationRunner;
import ru.levelup.lesson13.proxyclasses.AccountProxyHandler;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;

@DisplayName("Занятие 13. Проверка аннотации Blocked")
public class BlockedAnnotationTest {
    @SneakyThrows
    @Test
    @DisplayName("Проверка блокировки дествий по счету")
    public void blockedTest() {
        CorparateAccount corpAcc = new CorparateAccount(new CorparateClient());

        Account proxy = (Account) Proxy.newProxyInstance(
                AnnotationRunner.class.getClassLoader()
                , new Class[]{Account.class}
                , new AccountProxyHandler(corpAcc)
        );

        proxy.credit(new BigDecimal(100));

        Assertions.assertEquals(BigDecimal.ZERO, corpAcc.getBalance());
    }

}
