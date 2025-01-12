package ru.levelup.lesson07.exceptions;

public class Over8000kgWeightException extends RuntimeException{
    public Over8000kgWeightException(){
        super("Привышение массы 8000кг");
    }
}
