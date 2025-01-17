package ru.levelup.lesson08.employees;

import java.util.Date;

public class Employee {
    private String fullName;
    private int tableNumber;
    private int experienceInYear;
    private Gender gender;

    private Employee() {
    }

    public Employee(String fullName, int tableNumber, int experienceInYear, Gender gender) {
        this.fullName = fullName;
        this.tableNumber = tableNumber;
        this.experienceInYear = experienceInYear;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getExperienceInYear() {
        return experienceInYear;
    }

    public Gender getGender() {
        return gender;
    }

    public enum Gender {
        Male, Famale;

        @Override
        public String toString() {
            return switch (this) {
                case Male -> "муж";
                case Famale -> "жен";
                default -> null;
            };
        }
    }

    @Override
    public String toString() {
        return String.format(" (%-3s) %-40s  таб. номер : %-5s, стаж : %-4s ", gender, fullName, tableNumber, experienceInYear);
    }
}
