package ru.levelup.lesson12.accounts;

import ru.levelup.lesson13.annotations.Blocked;

import java.math.BigDecimal;

public interface Account {
    void debet(BigDecimal amount);

    @Blocked
    void credit(BigDecimal amount);
}
