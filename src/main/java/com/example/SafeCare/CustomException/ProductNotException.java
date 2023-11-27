package com.example.SafeCare.CustomException;

public class ProductNotException extends Exception{

    public ProductNotException()   {
        super("product not found");
    }


}
