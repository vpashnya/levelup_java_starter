package ru.levelup.lesson12.accounts;

import ru.levelup.lesson12.clients.AbstractClient;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class AbstractAccount implements Serializable {
    private static long numCounter = 0;
    private String accNum;
    private BigDecimal balance = BigDecimal.ZERO;
    private AbstractClient client;

    public AbstractAccount() {
        this.accNum = getBalanceNum() + (Long.toString(++numCounter) + "000000000000000").substring(0, 12);
    }

    public AbstractAccount(AbstractClient client){
        this();
        this.client = client;
    }
    abstract protected String getBalanceNum();

    public void debet(BigDecimal amount) {
        balance= balance.add(amount);
    }

    public void credit(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    public String getAccNum() {
        return accNum;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public AbstractClient getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "AbstractAccount{" +
                "accNum='" + accNum + '\'' +
                ", client='" + client + '\'' +
                ", balance=" + balance +
                '}';
    }
}
