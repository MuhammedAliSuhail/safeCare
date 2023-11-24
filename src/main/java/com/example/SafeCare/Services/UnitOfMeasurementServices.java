package com.example.SafeCare.Services;


import com.example.SafeCare.Entites.UnitOfMeasurement;
import com.example.SafeCare.Repository.UnitOfMeasurementRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UnitOfMeasurementServices {


    @Autowired
    UnitOfMeasurementRepo unitOfMeasurementRepo;
    public String addUnitOfMeasurment(String unit) throws Exception {
try{
    Optional<UnitOfMeasurement> unitOfMeasurementOptional=Optional.ofNullable(unitOfMeasurementRepo.findName(unit));
    if(!unitOfMeasurementOptional.isPresent()){

        UnitOfMeasurement unitOfMeasurement=UnitOfMeasurement.builder().UnitOfMeasurementName(unit).build();

        unitOfMeasurementRepo.save(unitOfMeasurement);
  log.info(unit+"is successfully saved");
        return "unit of Measurement is added";
    }else{
        log.warn(unit+"is already exist");
        return "unit is already exist";
    }
}catch (Exception e){

    log.error(String.valueOf(e));
    throw new Exception("Something went wrong!");

}



    }
}
