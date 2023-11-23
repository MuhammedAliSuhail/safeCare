package com.example.SafeCare.Controller;


import com.example.SafeCare.Entites.Product;
import com.example.SafeCare.RequetsDTO.addProductDTO;
import com.example.SafeCare.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Product")
public class ProductController {



    @Autowired
    ProductServices productServices;
    @PostMapping("/addProduct")
    public String addProduct(@RequestBody addProductDTO productDTO) throws Exception {
        System.out.println(productDTO.getProductName());
        System.out.println(productDTO.getSellingPrice());
          try{
              return productServices.addProduct(productDTO);
          }catch (Exception e){
              throw new Exception(e);
          }



    }



}
