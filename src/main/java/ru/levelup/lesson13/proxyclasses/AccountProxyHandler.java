package ru.levelup.lesson13.proxyclasses;

import ru.levelup.lesson12.accounts.Account;
import ru.levelup.lesson13.annotations.Blocked;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class AccountProxyHandler implements InvocationHandler {
    Account account;

    public AccountProxyHandler(Account account) {
        this.account = account;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(Stream.of(method.getAnnotations()).map(a->a.annotationType()).toList().contains(Blocked.class)){
            System.out.println("Method %s is blocked".formatted(method.getName()));
            return null;
        }else{
            return method.invoke(account, args);
        }
    }
}
