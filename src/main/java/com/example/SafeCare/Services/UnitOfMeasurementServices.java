package com.example.SafeCare.Services;


import com.example.SafeCare.CustomException.UnitNotException;
import com.example.SafeCare.CustomException.UnitIsalreadyInUse;
import com.example.SafeCare.CustomException.customException;
import com.example.SafeCare.Entites.Product;
import com.example.SafeCare.Entites.UnitOfMeasurement;
import com.example.SafeCare.Repository.ProductRepo;
import com.example.SafeCare.Repository.UnitOfMeasurementRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UnitOfMeasurementServices {


    @Autowired
    UnitOfMeasurementRepo unitOfMeasurementRepo;


    @Autowired
    ProductRepo productRepo;
    public String addUnitOfMeasurement(String unit) throws Exception {
try{
    Optional<UnitOfMeasurement> unitOfMeasurementOptional=Optional.ofNullable(unitOfMeasurementRepo.findName(unit));
    if(!unitOfMeasurementOptional.isPresent()){

        UnitOfMeasurement unitOfMeasurement=UnitOfMeasurement.builder().UnitOfMeasurementName(unit).build();

        unitOfMeasurementRepo.save(unitOfMeasurement);
  log.info(unit+"is successfully saved");
        return "unit of Measurement is added";
    }else{
        log.warn(unit+"is already exist");
        throw new UnitIsalreadyInUse(unit);
    }
}catch (UnitIsalreadyInUse e){
    throw new UnitIsalreadyInUse(unit);
}catch (Exception e){

    log.error(String.valueOf(e));
    throw new customException("Something went wrong!");

}



    }


    public String editUnitOfMeasurement(Integer id, String newName) throws Exception {

        try{
            Optional<UnitOfMeasurement> unitOfMeasurementOptional=unitOfMeasurementRepo.findById(id);


            if(!unitOfMeasurementOptional.isPresent()){
                throw new UnitNotException();
            }
            UnitOfMeasurement unitOfMeasurement=unitOfMeasurementOptional.get();

            unitOfMeasurement.setUnitOfMeasurementName(newName);

            unitOfMeasurementRepo.save(unitOfMeasurement);

            return "updated";
        }catch (UnitNotException e){
            log.error(String.valueOf(e));
            throw new UnitNotException();
        }catch (Exception e){
            log.error(String.valueOf(e));
            throw new customException("Something went wrong!");
        }



    }


    public String DeleteUnitOfMeasurement(Integer id) throws Exception {
        try {
            Optional<UnitOfMeasurement> unitOfMeasurementOptional = unitOfMeasurementRepo.findById(id);
            if (!unitOfMeasurementOptional.isPresent()) {
              throw new UnitNotException();
            }
            UnitOfMeasurement unitOfMeasurement = unitOfMeasurementOptional.get();

            List<Product> productList = productRepo.findAll();

            for (Product product : productList) {
                if (unitOfMeasurement.equals(product.getUnitMasherment())) {
                    throw new UnitIsalreadyInUse(id);
                }
            }

            unitOfMeasurementRepo.delete(unitOfMeasurement);

            return "deleted";
        }
      catch(UnitNotException e){
          log.error(String.valueOf(e));
            throw new UnitNotException();
        }  catch (UnitIsalreadyInUse e){
            log.error(String.valueOf(e));
            throw new UnitIsalreadyInUse(id);
        }catch (Exception e){
            log.error(String.valueOf(e));
            throw new customException("something went wrong!");
        }

    }


    public List<String> allUnits() throws customException {
  try{
      List<UnitOfMeasurement> unitOfMeasurements=unitOfMeasurementRepo.findAll();
      List<String> unitList=new ArrayList<>();
      for(UnitOfMeasurement unitOfMeasurement:unitOfMeasurements){
          unitList.add(unitOfMeasurement.getUnitOfMeasurementName());
      }
      return unitList;
  }catch (Exception e){
      log.error(String.valueOf(e));
      throw new customException("Something went Wrong!");
  }

    }

}
