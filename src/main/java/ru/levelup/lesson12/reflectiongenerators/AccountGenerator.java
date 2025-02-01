package ru.levelup.lesson12.reflectiongenerators;

import ru.levelup.lesson12.accounts.CorparateAccount;
import ru.levelup.lesson12.accounts.PersonAccount;
import ru.levelup.lesson12.clients.CorparateClient;
import ru.levelup.lesson12.clients.PersonClient;

import java.lang.reflect.InvocationTargetException;

public class AccountGenerator {
    public static PersonAccount generatePersonAccount(PersonClient client){
        try {
            return PersonAccount.class.getDeclaredConstructor(client.getClass()).newInstance(client);
        } catch (InstantiationException|IllegalAccessException|InvocationTargetException|NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }

    public static CorparateAccount generateCorparateAccount(CorparateClient client)  {
        try {
            return CorparateAccount.class.getDeclaredConstructor(client.getClass()).newInstance(client);
        } catch (InstantiationException|IllegalAccessException|InvocationTargetException|NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
}
