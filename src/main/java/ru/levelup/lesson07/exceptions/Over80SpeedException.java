package ru.levelup.lesson07.exceptions;

public class Over80SpeedException extends RuntimeException{
    public Over80SpeedException(){
        super("привышение скорости 80 км/ч");
    }
}
