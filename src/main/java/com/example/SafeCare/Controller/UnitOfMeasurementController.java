package com.example.SafeCare.Controller;


import com.example.SafeCare.Services.UnitOfMeasurementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/UnitOfMeasurement")
public class UnitOfMeasurementController {


    @Autowired
    UnitOfMeasurementServices unitOfMeasurementServices;



    @PostMapping("/add")
    public ResponseEntity<String> addUnitOfmeasurment(@RequestParam String UnitOfMeaseurement) throws Exception {
try{
    return new ResponseEntity<>(unitOfMeasurementServices.addUnitOfMeasurement(UnitOfMeaseurement),HttpStatus.CREATED);
}catch (Exception e){
    return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
}


    }


    @PutMapping("/edit")
    public ResponseEntity<String> editunitofmeasurment(@RequestParam Integer id, @RequestParam String newName){
        try{
            return new ResponseEntity<>(unitOfMeasurementServices.editUnitOfMeasurement(id,newName), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUnitOfMeasurement(@RequestParam Integer id){

        try {
            return new ResponseEntity<>(unitOfMeasurementServices.DeleteUnitOfMeasurement(id),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<List<String>> allunits(){
     try{
         return new ResponseEntity<>(unitOfMeasurementServices.allUnits(),HttpStatus.CREATED);
     }catch (Exception e){
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     }

    }
}
