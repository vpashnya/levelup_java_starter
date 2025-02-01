package ru.levelup.lesson12.clients;

public abstract class AbstractClient {
    private String fullName;
    private String inn;

    public AbstractClient(String fullName, String inn) {
        this.fullName = fullName;
        this.inn = inn;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInn() {
        return inn;
    }

    @Override
    public String toString() {
        return "AbstractClient{" +
                "fullName='" + fullName + '\'' +
                ", inn='" + inn + '\'' +
                '}';
    }
}
