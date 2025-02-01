package ru.levelup.lesson12.accounts;


import ru.levelup.lesson12.clients.CorparateClient;

public class CorparateAccount extends AbstractAccount {

    public CorparateAccount(CorparateClient client) {
        super(client);
    }

    @Override
    protected String getBalanceNum() {
        return "40702810";
    }
}
