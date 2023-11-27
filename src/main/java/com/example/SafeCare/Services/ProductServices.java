package com.example.SafeCare.Services;


import com.example.SafeCare.CustomException.CategoryNotFound;
import com.example.SafeCare.CustomException.ProductNotException;
import com.example.SafeCare.CustomException.UnitNotException;
import com.example.SafeCare.CustomException.customException;
import com.example.SafeCare.Entites.Category;
import com.example.SafeCare.Entites.Product;
import com.example.SafeCare.Entites.UnitOfMeasurement;
import com.example.SafeCare.Repository.CategoryRepo;
import com.example.SafeCare.Repository.ProductRepo;
import com.example.SafeCare.Repository.UnitOfMeasurementRepo;
import com.example.SafeCare.RequetsDTO.addProductDTO;
import com.example.SafeCare.ResponseDTO.ProductResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        throw new CategoryNotFound();

    }

    Optional<UnitOfMeasurement> unitOfMeasurement= Optional.ofNullable(unitOfMeasurementRepo.findName(product.getUnitMasherment()));
    if(!unitOfMeasurement.isPresent()){
        logger.error("the unit of measurement not present");
        throw new UnitNotException();
    }
    Optional<Product> product2= Optional.ofNullable(productRepo.findName(product.getProductName()));
    if(!product2.isPresent()){
        Category category1=category.get();
        UnitOfMeasurement unitOfMeasurement1=unitOfMeasurement.get();
        Product product1= Product.builder().productName(product.getProductName())
                .purchasePrice(product.getPurchasePrice()).SellingPrice(product.getSellingPrice())
                .reOrderLevel(product.getReOrderLevel()).MaxOrderLevel(product.getMaxOrderLevel()).category(category1)
                .unitMasherment(unitOfMeasurement1).build();

      logger.info(product1+"product saved");

        productRepo.save(product1);
        return "product Added";
    }else{
        logger.warn("the product name is already exist");
        return "product name is already present";
    }

}catch (CategoryNotFound e){
    logger.error(String.valueOf(e));
    throw new CategoryNotFound();
}catch (UnitNotException e){
    logger.error(String.valueOf(e));
    throw new UnitNotException();


}catch (Exception e){
    logger.error(String.valueOf(e));
    throw new customException("Something went wrong!");
}



    }


    public String editProduct(Integer id,addProductDTO productDTO) throws Exception {

        try{
            Optional<Product> product=productRepo.findById(id);
            if(!product.isPresent()){
               throw new ProductNotException();
            }
            Product product1=product.get();

            Optional<Category> category= Optional.ofNullable(categoryRepo.findName(productDTO.getCategory()));
            if(!category.isPresent()){
               throw new CategoryNotFound();
            }
            Optional<UnitOfMeasurement> unitOfMeasurement= Optional.ofNullable(unitOfMeasurementRepo.findName(productDTO.getUnitMasherment()));
            if(!unitOfMeasurement.isPresent()){
                throw new UnitNotException();
            }
            Category category1=category.get();

            UnitOfMeasurement unitOfMeasurement1=unitOfMeasurement.get();

            product1.setProductName(productDTO.getProductName());
            product1.setCategory(category1);
            product1.setMaxOrderLevel(productDTO.getMaxOrderLevel());
            product1.setPurchasePrice(productDTO.getPurchasePrice());
            product1.setReOrderLevel(productDTO.getReOrderLevel());
            product1.setUnitMasherment(unitOfMeasurement1);
            product1.setSellingPrice(productDTO.getSellingPrice());


            productRepo.save(product1);
            logger.info(product+"updated");
            return "Updated";
        }catch (CategoryNotFound e){
            logger.error(String.valueOf(e));
            throw new CategoryNotFound();
        }catch (UnitNotException e){
            logger.error(String.valueOf(e));
            throw new UnitNotException();

        }catch (ProductNotException e){
            logger.error(String.valueOf(e));
            throw new ProductNotException();
        }catch (Exception e){
            logger.error(String.valueOf(e));
          throw new customException("Something went wrong!");
        }



    }


    public String deleteProduct(Integer id) throws Exception{
        try{
            Optional<Product> product=productRepo.findById(id);
            if(!product.isPresent()){
                throw new ProductNotException();
            }
            Product product1=product.get();
            product1.setCategory(null);
            product1.setUnitMasherment(null);
            productRepo.save(product1);
            productRepo.delete(product1);

            return "deleted successfully";
        }catch (ProductNotException e){
            logger.error(String.valueOf(e));
            throw new ProductNotException();
        }catch (Exception e){
            logger.error(String.valueOf(e));
            throw new customException("Something went wrong !");
        }

    }

    public List<ProductResponseDTO> allproducts() throws Exception {

        try{
            List<Product> products=productRepo.findAll();
            List<ProductResponseDTO> productResponseDTOS=new ArrayList<>();

            for(Product product:products){
                ProductResponseDTO productResponseDTO= ProductResponseDTO.builder().productName(product.getProductName())
                        .unitMasherment(product.getUnitMasherment().getUnitOfMeasurementName())
                        .purchasePrice(product.getPurchasePrice()).SellingPrice(product.getSellingPrice())
                        .category(product.getCategory().getCategoryName()).build();
            }
            return productResponseDTOS;
        }catch (Exception e){
            log.error(String.valueOf(e));

            throw new customException("something went wrong!");
        }

    }

}
