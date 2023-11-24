package com.example.SafeCare.Services;


import com.example.SafeCare.Entites.Category;
import com.example.SafeCare.Entites.Product;
import com.example.SafeCare.Entites.UnitOfMeasurement;
import com.example.SafeCare.Repository.CategoryRepo;
import com.example.SafeCare.Repository.ProductRepo;
import com.example.SafeCare.Repository.UnitOfMeasurementRepo;
import com.example.SafeCare.RequetsDTO.addProductDTO;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;

@Service
@Slf4j
public class ProductServices {

    private static final Logger logger = LoggerFactory.getLogger(ProductServices.class);
    @Autowired
    ProductRepo productRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    UnitOfMeasurementRepo unitOfMeasurementRepo;

    public String addProduct(addProductDTO product) throws Exception {

try{
    Optional<Category> category= Optional.ofNullable(categoryRepo.findName(product.getCategory()));

    if(!category.isPresent()){
        logger.error("the category not present");
        throw new Exception("the category is not present");

    }

    Optional<UnitOfMeasurement> unitOfMeasurement= Optional.ofNullable(unitOfMeasurementRepo.findName(product.getUnitMasherment()));
    if(!unitOfMeasurement.isPresent()){
        logger.error("the unit of measurement not present");
        throw new Exception("the unit of measurement is not present");
    }
    Optional<Product> product2= Optional.ofNullable(productRepo.findName(product.getProductName()));
    if(!product2.isPresent()){
        Category category1=category.get();
        UnitOfMeasurement unitOfMeasurement1=unitOfMeasurement.get();
        Product product1= Product.builder().productName(product.getProductName())
                .purchasePrice(product.getPurchasePrice()).SellingPrice(product.getSellingPrice())
                .reOrderLevel(product.getReOrderLevel()).MaxOrderLevel(product.getMaxOrderLevel()).category(category1)
                .unitMasherment(unitOfMeasurement1).build();

        System.out.println(product.getProductName());

        productRepo.save(product1);
        return "product Added";
    }else{
        logger.warn("the product name is already exist");
        return "product name is already present";
    }

}catch (Exception e){
    logger.error(String.valueOf(e));
    return "something went wrong!";
}



    }

}
