package ru.levelup.lesson13.proxyclasses;

import lombok.AllArgsConstructor;
import ru.levelup.lesson12.accounts.Account;
import ru.levelup.lesson13.annotations.Blocked;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@AllArgsConstructor
public class AccountProxyHandler implements InvocationHandler {
    private Account account;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Blocked.class)) {
            System.out.println("Method %s is blocked".formatted(method.getName()));
            return null;
        } else {
            return method.invoke(account, args);
        }
    }
}
