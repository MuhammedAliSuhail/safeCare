package com.example.SafeCare.CustomException;

public class CategoryExeption extends Exception{

    public CategoryExeption(){
        super("category Already in use");
    }
}
