package ru.levelup.lesson07.exceptions;

public class Over100SpeedException extends RuntimeException{
    public Over100SpeedException(){
        super("привышение скорости 100 км/ч");
    }
}
