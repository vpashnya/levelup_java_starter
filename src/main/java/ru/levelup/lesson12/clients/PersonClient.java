package ru.levelup.lesson12.clients;

public class PersonClient extends AbstractClient{
    private String surName;
    private String name;
    private String fatherName;

    public PersonClient(){
        super(null,null);
    }
    private PersonClient(String fullName, String inn){
        super(fullName,inn);
    }

    public PersonClient(String surName, String name, String fatherName, String inn) {
        super(surName + " " + name + " " + fatherName, inn);
        this.surName = surName;
        this.name = name;
        this.fatherName = fatherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    @Override
    public String toString() {
        return "PersonClient{" +
                "surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", inn='" + getInn() + '\'' +
                '}';
    }
}
