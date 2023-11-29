package com.example.SafeCare.Services;



import com.example.SafeCare.Entites.Product;
import com.example.SafeCare.Entites.UnitOfMeasurement;
import com.example.SafeCare.Exception.IoExceptionCustom;
import com.example.SafeCare.Exception.ValidationException;
import com.example.SafeCare.Repository.ProductRepo;
import com.example.SafeCare.Repository.UnitOfMeasurementRepo;
import com.example.SafeCare.ResponseDTO.UnitOfMeasurementResponseDTO;
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
    public UnitOfMeasurementResponseDTO addUnitOfMeasurement(String unit) throws Exception {
try{
    Optional<UnitOfMeasurement> unitOfMeasurementOptional=Optional.ofNullable(unitOfMeasurementRepo.findName(unit));
    if(!unitOfMeasurementOptional.isPresent()){

        UnitOfMeasurement unitOfMeasurement=UnitOfMeasurement.builder().UnitOfMeasurementName(unit).build();

        unitOfMeasurementRepo.save(unitOfMeasurement);
  log.info(unit+"is successfully saved");
        UnitOfMeasurementResponseDTO  unitOfMeasurementResponseDTO=new UnitOfMeasurementResponseDTO(unit);
        return unitOfMeasurementResponseDTO;
    }else{
        log.warn(unit+"is already exist");
        throw new ValidationException("400","unit is already exist","1");
    }
}catch (ValidationException vx){
    throw vx;
}catch (Exception e){

    log.error(String.valueOf(e));
    throw e;

}



    }


    public UnitOfMeasurementResponseDTO editUnitOfMeasurement(Integer id, String newName) throws Exception {

        try{
            Optional<UnitOfMeasurement> unitOfMeasurementOptional=unitOfMeasurementRepo.findById(id);


            if(!unitOfMeasurementOptional.isPresent()){
                throw new IoExceptionCustom("200","id not present","0");
            }
            UnitOfMeasurement unitOfMeasurement=unitOfMeasurementOptional.get();
            Optional<UnitOfMeasurement> unitOfMeasurementOptional1=Optional.ofNullable(unitOfMeasurementRepo.findName(newName));
            if(unitOfMeasurementOptional1.isPresent()){
                throw new ValidationException("400","unit name is already present","1");
            }

            unitOfMeasurement.setUnitOfMeasurementName(newName);

            unitOfMeasurementRepo.save(unitOfMeasurement);
               UnitOfMeasurementResponseDTO unitOfMeasurementResponseDTO=new UnitOfMeasurementResponseDTO(newName);
            return unitOfMeasurementResponseDTO;
        }catch (IoExceptionCustom ex){
            throw ex;
        }catch (ValidationException vx){
            log.error(String.valueOf(vx));
            throw vx;
        }catch (Exception e){
            log.error(String.valueOf(e));
            throw e;
        }



    }


    public UnitOfMeasurementResponseDTO DeleteUnitOfMeasurement(Integer id) throws Exception {
        try {
            Optional<UnitOfMeasurement> unitOfMeasurementOptional = unitOfMeasurementRepo.findById(id);
            if (!unitOfMeasurementOptional.isPresent()) {
              throw new IoExceptionCustom("200","id not present","0");
            }
            UnitOfMeasurement unitOfMeasurement = unitOfMeasurementOptional.get();

            List<Product> productList = productRepo.findAll();

            for (Product product : productList) {
                if (unitOfMeasurement.equals(product.getUnitMasherment())) {
                    throw new ValidationException("400","unit is already in use","1");
                }
            }

            unitOfMeasurementRepo.delete(unitOfMeasurement);
            UnitOfMeasurementResponseDTO unitOfMeasurementResponseDTO=new UnitOfMeasurementResponseDTO(unitOfMeasurement.getUnitOfMeasurementName());

            return unitOfMeasurementResponseDTO;
        }
      catch(ValidationException vx){
          log.error(String.valueOf(vx));
            throw vx;
        }catch (IoExceptionCustom ex){
            throw ex;
        }
        catch (Exception e){
            log.error(String.valueOf(e));
            throw e;
        }

    }


    public List<UnitOfMeasurementResponseDTO> allUnits() throws Exception {
  try{
      List<UnitOfMeasurement> unitOfMeasurements=unitOfMeasurementRepo.findAll();
      List<UnitOfMeasurementResponseDTO> unitList=new ArrayList<>();
      for(UnitOfMeasurement unitOfMeasurement:unitOfMeasurements){
          UnitOfMeasurementResponseDTO unitOfMeasurementResponseDTO=new UnitOfMeasurementResponseDTO(unitOfMeasurement.getUnitOfMeasurementName());
          unitList.add(unitOfMeasurementResponseDTO);
      }
      return unitList;
  }catch (Exception e){
      log.error(String.valueOf(e));
      throw e;
  }

    }

}
