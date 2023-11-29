package com.example.SafeCare.Services;



import com.example.SafeCare.Entites.Category;
import com.example.SafeCare.Entites.Product;
import com.example.SafeCare.Entites.UnitOfMeasurement;
import com.example.SafeCare.Exception.IoExceptionCustom;
import com.example.SafeCare.Exception.ValidationException;
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

import java.io.IOException;
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

    public  ProductResponseDTO addProduct(addProductDTO product) throws Exception {

try{
    Optional<Category> category= Optional.ofNullable(categoryRepo.findName(product.getCategory()));

    if(!category.isPresent()){
        logger.error("the category not present");
        throw new IoExceptionCustom("200","Category present","0");

    }

    Optional<UnitOfMeasurement> unitOfMeasurement= Optional.ofNullable(unitOfMeasurementRepo.findName(product.getUnitMasherment()));
    if(!unitOfMeasurement.isPresent()){
        logger.error("the unit of measurement not present");
        throw new IoExceptionCustom("200","Unit is not present","0");
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
        ProductResponseDTO productResponseDTO= ProductResponseDTO.builder().productName(product.getProductName())
                .purchasePrice(product.getPurchasePrice()).SellingPrice(product.getSellingPrice())
                .reOrderLevel(product.getReOrderLevel()).MaxOrderLevel(product.getMaxOrderLevel()).category(category1.getCategoryName())
                .unitMeasurement(unitOfMeasurement1.getUnitOfMeasurementName()).build();
        return productResponseDTO;
    }else{
        logger.warn("the product name is already exist");
        throw new ValidationException("400","The product name is already exist","1");
    }

}catch (IoExceptionCustom ex){
    logger.error(String.valueOf(ex));
    throw ex;
}catch (ValidationException vx){
    logger.error(String.valueOf(vx));
    throw vx;
}catch (Exception e){
    logger.error(String.valueOf(e));
    throw e;
}



    }


    public ProductResponseDTO editProduct(Integer id,addProductDTO productDTO) throws Exception {

        try{
            Optional<Product> product=productRepo.findById(id);
            if(!product.isPresent()){
                throw new IoExceptionCustom("200","id is not present","0");
            }
            Product product1=product.get();

            Optional<Product> product2= Optional.ofNullable(productRepo.findName(productDTO.getProductName()));

            if(product2.isPresent()){
                throw new ValidationException("400","product name is already present","1");
            }
            Optional<Category> category= Optional.ofNullable(categoryRepo.findName(productDTO.getCategory()));
            if(!category.isPresent()){
                throw new IoExceptionCustom("200","Category is not present","0");
            }
            Optional<UnitOfMeasurement> unitOfMeasurement= Optional.ofNullable(unitOfMeasurementRepo.findName(productDTO.getUnitMasherment()));
            if(!unitOfMeasurement.isPresent()){
                throw new IoExceptionCustom("200","unit is not present","0");
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
            ProductResponseDTO productResponseDTO= ProductResponseDTO.builder().productName(product1.getProductName())
                    .purchasePrice(product1.getPurchasePrice()).SellingPrice(product1.getSellingPrice())
                    .reOrderLevel(product1.getReOrderLevel()).MaxOrderLevel(product1.getMaxOrderLevel()).category(category1.getCategoryName())
                    .unitMeasurement(unitOfMeasurement1.getUnitOfMeasurementName()).build();
            return productResponseDTO;
        }catch (ValidationException vx){
            logger.error(String.valueOf(vx));
            throw vx;
        }catch (IoExceptionCustom ex){
            logger.error(String.valueOf(ex));
            throw ex;
        }catch (Exception e){
            logger.error(String.valueOf(e));
          throw e;
        }



    }


    public ProductResponseDTO deleteProduct(Integer id) throws Exception{
        try{
            Optional<Product> product=productRepo.findById(id);
            if(!product.isPresent()){
                throw new IoExceptionCustom("200","id is not present","0");
            }
            Product product1=product.get();
            ProductResponseDTO productResponseDTO= ProductResponseDTO.builder().productName(product1.getProductName())
                    .purchasePrice(product1.getPurchasePrice()).SellingPrice(product1.getSellingPrice())
                    .reOrderLevel(product1.getReOrderLevel()).MaxOrderLevel(product1.getMaxOrderLevel()).category(product1.getCategory().getCategoryName())
                    .unitMeasurement(product1.getUnitMasherment().getUnitOfMeasurementName()).build();
            product1.setCategory(null);
            product1.setUnitMasherment(null);
            productRepo.save(product1);
            productRepo.delete(product1);

            return productResponseDTO;
        }catch (IoExceptionCustom ex){
            logger.error(String.valueOf(ex));
            throw ex;
        }catch (Exception e){
            logger.error(String.valueOf(e));
            throw e;
        }

    }

    public List<ProductResponseDTO> allproducts() throws Exception {

        try{
            List<Product> products=productRepo.findAll();
            List<ProductResponseDTO> productResponseDTOS=new ArrayList<>();

            for(Product product:products){
                ProductResponseDTO productResponseDTO= ProductResponseDTO.builder().productName(product.getProductName())
                        .purchasePrice(product.getPurchasePrice()).SellingPrice(product.getSellingPrice())
                        .reOrderLevel(product.getReOrderLevel()).MaxOrderLevel(product.getMaxOrderLevel()).category(product.getCategory().getCategoryName())
                        .unitMeasurement(product.getUnitMasherment().getUnitOfMeasurementName()).build();
                productResponseDTOS.add(productResponseDTO);
            }
            return productResponseDTOS;
        }catch (Exception e){
            log.error(String.valueOf(e));

            throw e;
        }

    }

}
