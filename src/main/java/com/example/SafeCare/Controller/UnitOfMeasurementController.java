package com.example.SafeCare.Controller;


import com.example.SafeCare.Exception.IoExceptionCustom;
import com.example.SafeCare.Exception.ValidationException;
import com.example.SafeCare.Response.GenerateGlobalResponse;
import com.example.SafeCare.Services.UnitOfMeasurementServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/UnitOfMeasurement")
@Slf4j
public class UnitOfMeasurementController {


    @Autowired
    UnitOfMeasurementServices unitOfMeasurementServices;

  @Autowired
    GenerateGlobalResponse generateGlobalResponse;

    @PostMapping("/add")
    public ResponseEntity addUnitOfmeasurment(@RequestParam String UnitOfMeaseurement) throws Exception {
        try {
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(unitOfMeasurementServices.addUnitOfMeasurement(UnitOfMeaseurement), "2"
                    ,"200","Unit added successfully"),HttpStatus.OK);
        }catch (ValidationException vx){
            log.info("UnitOfMeasurementController->UnitOfMeasurementService->ValidationException");
            log.info(vx.getMessage());
            log.info(vx.toString());
            log.info(vx.getErrorResponse().getResponseIndicator());
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(null,vx.getErrorResponse().getResponseIndicator(),
                    vx.getErrorResponse().getStatusCode(),vx.getErrorResponse().getResponseMessage()),HttpStatus.OK);
        }catch (IoExceptionCustom ex){
            log.info("unitController->unitService->IoException");
            log.info(ex.getMessage());
            log.info(ex.toString());
            log.info(ex.getErrorResponse().getResponseIndicator());
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(null,ex.getErrorResponse().getResponseIndicator(),
                    ex.getErrorResponse().getStatusCode(),ex.getErrorResponse().getResponseMessage()),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(
                    null, "constants.getRESPONSE_INDICATOR_ERROR_0()", "constants.getSUCCESSFULL_RESPONSE_CODE_200()",
                    "propertiesUtil.getApplicationMessages().getProperty"), HttpStatus.OK);
        }


    }


    @PutMapping("/edit")
    public ResponseEntity editunitofmeasurment(@RequestParam Integer id, @RequestParam String newName){
        try {
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(unitOfMeasurementServices.editUnitOfMeasurement(id,newName), "2"
                    ,"200","Unit updated"),HttpStatus.OK);
        }catch (ValidationException vx){
            log.info("categoryController->categoryService->ValidationException");
            log.info(vx.getMessage());
            log.info(vx.toString());
            log.info(vx.getErrorResponse().getResponseIndicator());
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(null,vx.getErrorResponse().getResponseIndicator(),
                    vx.getErrorResponse().getStatusCode(),vx.getErrorResponse().getResponseMessage()),HttpStatus.OK);
        }catch (IoExceptionCustom ex){
            log.info("unitController->unitService->IoException");
            log.info(ex.getMessage());
            log.info(ex.toString());
            log.info(ex.getErrorResponse().getResponseIndicator());
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(null,ex.getErrorResponse().getResponseIndicator(),
                    ex.getErrorResponse().getStatusCode(),ex.getErrorResponse().getResponseMessage()),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(
                    null, "constants.getRESPONSE_INDICATOR_ERROR_0()", "constants.getSUCCESSFULL_RESPONSE_CODE_200()",
                    "propertiesUtil.getApplicationMessages().getProperty"), HttpStatus.OK);
        }

    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteUnitOfMeasurement(@RequestParam Integer id){

        try {
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(unitOfMeasurementServices.DeleteUnitOfMeasurement(id), "2"
                    ,"200","Category deleted"),HttpStatus.OK);
        }catch (ValidationException vx){
            log.info("categoryController->categoryService->ValidationException");
            log.info(vx.getMessage());
            log.info(vx.toString());
            log.info(vx.getErrorResponse().getResponseIndicator());
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(null,vx.getErrorResponse().getResponseIndicator(),
                    vx.getErrorResponse().getStatusCode(),vx.getErrorResponse().getResponseMessage()),HttpStatus.OK);
        }catch (IoExceptionCustom ex){
            log.info("unitController->unitService->IoException");
            log.info(ex.getMessage());
            log.info(ex.toString());
            log.info(ex.getErrorResponse().getResponseIndicator());
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(null,ex.getErrorResponse().getResponseIndicator(),
                    ex.getErrorResponse().getStatusCode(),ex.getErrorResponse().getResponseMessage()),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(
                    null, "constants.getRESPONSE_INDICATOR_ERROR_0()", "constants.getSUCCESSFULL_RESPONSE_CODE_200()",
                    "propertiesUtil.getApplicationMessages().getProperty"), HttpStatus.OK);
        }


    }

    @GetMapping("/all")
    public ResponseEntity allunits(){
        try {
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(unitOfMeasurementServices.allUnits(), "2"
                    ,"200","Category deleted"),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(
                    null, "constants.getRESPONSE_INDICATOR_ERROR_0()", "constants.getSUCCESSFULL_RESPONSE_CODE_200()",
                    "propertiesUtil.getApplicationMessages().getProperty"), HttpStatus.OK);
        }

    }
}
