package com.example.SafeCare.Controller;


import com.example.SafeCare.CustomException.customException;
import com.example.SafeCare.Entites.Product;
import com.example.SafeCare.RequetsDTO.addProductDTO;
import com.example.SafeCare.ResponseDTO.ProductResponseDTO;
import com.example.SafeCare.Services.ProductServices;
import org.hibernate.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {



    @Autowired
    ProductServices productServices;
    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody addProductDTO productDTO)  {

  try{
      return new ResponseEntity<>(productServices.addProduct(productDTO),HttpStatus.CREATED);
  }catch (Exception e){
      return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
  }




    }

    @PutMapping("/editProduct")
    public ResponseEntity<String> editProduct(@RequestParam Integer id, @RequestBody addProductDTO productDTO){

        try{
            return new ResponseEntity<>(productServices.editProduct(id,productDTO), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }


    @DeleteMapping("/DeleteProduct")
    public ResponseEntity<String> deleteProduct(Integer id)  {
        try{
            return new ResponseEntity<>(productServices.deleteProduct(id),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/allProducts")
    public ResponseEntity<List<ProductResponseDTO>> allProduct(){

  try{
      return new ResponseEntity<>(productServices.allproducts(),HttpStatus.CREATED);
  }catch(Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
    }



}
