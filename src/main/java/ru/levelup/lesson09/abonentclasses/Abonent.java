package ru.levelup.lesson09.abonentclasses;

import java.util.Collection;
import java.util.TreeSet;

public class Abonent implements Comparable {
    final private String fullname;
    final private String phoneNumber;
    final private Operator operator;
    final private Collection<Abonent> contacts;

    public Abonent(String fullname, String phoneNumber, Operator operator, Collection<Abonent> contacts) {
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.operator = operator;
        this.contacts = contacts;
    }

    public Operator getOperator() {
        return operator;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Collection<Abonent> getContacts() {
        return contacts;
    }

    @Override
    public String toString() {
        return String.format("%-40s   %-5s %-10s  %s контактов", fullname, phoneNumber, operator, contacts.size());
    }

    @Override
    public int compareTo(Object o) {
        Abonent abonent = (Abonent) o;
        return (this.fullname + this.phoneNumber).compareTo(abonent.fullname + abonent.phoneNumber);
    }
}
