package ru.levelup.lesson12.clients;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class AbstractClient {
    private String fullName;
    private String inn;

    public AbstractClient(String fullName, String inn) {
        this.fullName = fullName;
        this.inn = inn;
    }

}
