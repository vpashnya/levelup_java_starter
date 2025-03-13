package ru.levelup.lesson12.accounts;

import ru.levelup.lesson12.clients.PersonClient;

public class PersonAccount extends AbstractAccount {

    public PersonAccount(PersonClient client) {
        super(client);
    }

    @Override
    protected String getBalanceNum() {
        return "40802810";
    }
}
