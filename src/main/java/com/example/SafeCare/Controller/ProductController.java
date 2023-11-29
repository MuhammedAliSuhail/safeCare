package com.example.SafeCare.Controller;



import com.example.SafeCare.Entites.Product;
import com.example.SafeCare.Exception.IoExceptionCustom;
import com.example.SafeCare.Exception.ValidationException;
import com.example.SafeCare.RequetsDTO.addProductDTO;
import com.example.SafeCare.Response.GenerateGlobalResponse;
import com.example.SafeCare.ResponseDTO.ProductResponseDTO;
import com.example.SafeCare.Services.ProductServices;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
@Slf4j
public class ProductController {

     @Autowired
    GenerateGlobalResponse generateGlobalResponse;


    @Autowired
    ProductServices productServices;
    @PostMapping("/addProduct")
    public ResponseEntity addProduct(@RequestBody addProductDTO productDTO)  {

        try {
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(productServices.addProduct(productDTO), "2"
                    ,"200","Product added successfully "),HttpStatus.OK);
        }catch (ValidationException vx){
            log.info("ProductController->ProductService->ValidationException");
            log.info(vx.getMessage());
            log.info(vx.toString());
            log.info(vx.getErrorResponse().getResponseIndicator());
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(null,vx.getErrorResponse().getResponseIndicator(),
                    vx.getErrorResponse().getStatusCode(),vx.getErrorResponse().getResponseMessage()),HttpStatus.OK);
        }catch (IoExceptionCustom ex){
            log.info("ProductController->ProductService->IoException");
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

    @PutMapping("/editProduct")
    public ResponseEntity editProduct(@RequestParam Integer id, @RequestBody addProductDTO productDTO){

        try {
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(productServices.editProduct(id,productDTO), "2"
                    ,"200","Product updated successfully "),HttpStatus.OK);
        }catch (ValidationException vx){
            log.info("ProductController->ProductService->ValidationException");
            log.info(vx.getMessage());
            log.info(vx.toString());
            log.info(vx.getErrorResponse().getResponseIndicator());
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(null,vx.getErrorResponse().getResponseIndicator(),
                    vx.getErrorResponse().getStatusCode(),vx.getErrorResponse().getResponseMessage()),HttpStatus.OK);
        }catch (IoExceptionCustom ex){
            log.info("ProductController->ProductService->IoException");
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


    @DeleteMapping("/DeleteProduct")
    public ResponseEntity deleteProduct(Integer id)  {
        try {
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(productServices.deleteProduct(id), "2"
                    ,"200","Product added successfully "),HttpStatus.OK);
        }catch (ValidationException vx){
            log.info("ProductController->ProductService->ValidationException");
            log.info(vx.getMessage());
            log.info(vx.toString());
            log.info(vx.getErrorResponse().getResponseIndicator());
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(null,vx.getErrorResponse().getResponseIndicator(),
                    vx.getErrorResponse().getStatusCode(),vx.getErrorResponse().getResponseMessage()),HttpStatus.OK);
        }catch (IoExceptionCustom ex){
            log.info("ProductController->ProductService->IoException");
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
    @GetMapping("/allProducts")
    public ResponseEntity allProduct(){

        try {
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(productServices.allproducts(), "2"
                    ,"200","all products "),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(
                    null, "constants.getRESPONSE_INDICATOR_ERROR_0()", "constants.getSUCCESSFULL_RESPONSE_CODE_200()",
                    "propertiesUtil.getApplicationMessages().getProperty"), HttpStatus.OK);
        }
    }



}
