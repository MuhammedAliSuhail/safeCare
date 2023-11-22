package com.example.SafeCare.Services;


import com.example.SafeCare.Entites.Product;
import com.example.SafeCare.Repository.ProductRepo;
import com.example.SafeCare.RequetsDTO.addProductDTO;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {


    @Autowired
    ProductRepo productRepo;

    public String addProduct(addProductDTO product){


        Product product1= Product.builder().productName(product.getProductName())
                .purchasePrice(product.getSellingPrice()).SellingPrice(product.getSellingPrice()).build();

        System.out.println(product.getProductName());

        productRepo.save(product1);
        return "product Added";

    }

}
