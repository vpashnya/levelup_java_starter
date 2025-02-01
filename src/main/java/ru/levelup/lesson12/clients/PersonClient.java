package ru.levelup.lesson12.clients;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper=true)
public class PersonClient extends AbstractClient {
    private String surName;
    private String name;
    private String fatherName;

    public PersonClient() {
        super(null, null);
    }

    private PersonClient(String fullName, String inn) {
        super(fullName, inn);
    }

    public PersonClient(String surName, String name, String fatherName, String inn) {
        super(surName + " " + name + " " + fatherName, inn);
        this.surName = surName;
        this.name = name;
        this.fatherName = fatherName;
    }


}
