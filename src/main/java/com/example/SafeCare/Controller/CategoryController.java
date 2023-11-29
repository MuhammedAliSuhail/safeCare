package com.example.SafeCare.Controller;


import com.example.SafeCare.Exception.IoExceptionCustom;
import com.example.SafeCare.Exception.ValidationException;
import com.example.SafeCare.Response.GenerateGlobalResponse;
import com.example.SafeCare.ResponseDTO.CategoryResponseDTO;
import com.example.SafeCare.Services.CategoryServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Category")
@Slf4j
public class CategoryController {

@Autowired
GenerateGlobalResponse generateGlobalResponse;
@Autowired
    CategoryServices categoryServices;
    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestParam String category) throws Exception {

        try {
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(categoryServices.addCategory(category), "2"
            ,"200","Category added successfully"),HttpStatus.OK);
        }catch (ValidationException vx){
            log.info("categoryController->categoryService->ValidationException");
            log.info(vx.getMessage());
            log.info(vx.toString());
            log.info(vx.getErrorResponse().getResponseIndicator());
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(null,vx.getErrorResponse().getResponseIndicator(),
                    vx.getErrorResponse().getStatusCode(),vx.getErrorResponse().getResponseMessage()),HttpStatus.OK);
        }catch (IoExceptionCustom ex){
            log.info("categoryController->categoryService->IoException");
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
    public ResponseEntity editCategory(@RequestParam Integer id ,@RequestParam String NewName){
        try {
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(categoryServices.editCategory(id,NewName), "2"
                    ,"200","Category updated"),HttpStatus.OK);
        }catch (ValidationException vx){
            log.info("categoryController->categoryService->ValidationException");
            log.info(vx.getMessage());
            log.info(vx.toString());
            log.info(vx.getErrorResponse().getResponseIndicator());
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(null,vx.getErrorResponse().getResponseIndicator(),
                    vx.getErrorResponse().getStatusCode(),vx.getErrorResponse().getResponseMessage()),HttpStatus.OK);
        }catch (IoExceptionCustom ex){
            log.info("categoryController->categoryService->IoException");
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
    public ResponseEntity DeleteCategory(@RequestParam Integer id){
        try {
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(categoryServices.DeleteCategory(id), "2"
                    ,"200","Category deleted"),HttpStatus.OK);
        }catch (ValidationException vx){
            log.info("categoryController->categoryService->ValidationException");
            log.info(vx.getMessage());
            log.info(vx.toString());
            log.info(vx.getErrorResponse().getResponseIndicator());
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(null,vx.getErrorResponse().getResponseIndicator(),
                    vx.getErrorResponse().getStatusCode(),vx.getErrorResponse().getResponseMessage()),HttpStatus.OK);
        }catch (IoExceptionCustom ex){
            log.info("categoryController->categoryService->IoException");
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
    public ResponseEntity allCategory(){
        try {
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(categoryServices.allCategory(), "2"
                    ,"200","Category deleted"),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(
                    null, "constants.getRESPONSE_INDICATOR_ERROR_0()", "constants.getSUCCESSFULL_RESPONSE_CODE_200()",
                    "propertiesUtil.getApplicationMessages().getProperty"), HttpStatus.OK);
        }
    }
}
