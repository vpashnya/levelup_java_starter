package ru.levelup.lesson07.exceptions;

public class Over4mHeightException extends RuntimeException{
    public Over4mHeightException(){
        super(" превышение высоты 4 метра");
    }
}
