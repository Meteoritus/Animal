package ru.animal.clinic;
/*Класс кошек*/

public class Cat extends Client{
    @Override
	String getName(){
            return "cat " + name;
        }
}