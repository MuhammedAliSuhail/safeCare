package com.example.SafeCare.Controller;


import com.example.SafeCare.Entites.UnitOfMeasurement;
import com.example.SafeCare.Services.UnitOfMeasurementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UnitOfMeasurment")
public class UnitOfMeasurmentController {


    @Autowired
    UnitOfMeasurementServices unitOfMeasurementServices;



    @PostMapping("/add")
    public String addUnitOfmeasurment(@RequestParam String UnitOfMeasurment) throws Exception {

        return unitOfMeasurementServices.addUnitOfMeasurment(UnitOfMeasurment);

    }
}
