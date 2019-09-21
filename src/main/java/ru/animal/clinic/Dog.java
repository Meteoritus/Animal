package ru.animal.clinic;
/*Класс собак*/

public class Dog extends Client{
	@Override
        String getName(){
            return "dog " + name;
        }
}