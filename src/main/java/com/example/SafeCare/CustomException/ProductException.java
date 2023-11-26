package com.example.SafeCare.CustomException;

public class ProductException extends Exception{

    public ProductException(){
        super("product not found");
    }

    public ProductException(Integer id){
        super("product is already present !");
    }
}
