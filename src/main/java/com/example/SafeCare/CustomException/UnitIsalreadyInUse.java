package com.example.SafeCare.CustomException;

public class UnitIsalreadyInUse extends Exception{

    public UnitIsalreadyInUse(Integer id){
        super(id+"is already in use");
    }
    public UnitIsalreadyInUse(String unit){
        super(unit+"is already in use");
    }
}
