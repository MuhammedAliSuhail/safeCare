package com.example.SafeCare.Services;



import com.example.SafeCare.Entites.Category;
import com.example.SafeCare.Entites.Product;
import com.example.SafeCare.Entites.UnitOfMeasurement;
import com.example.SafeCare.Exception.IoExceptionCustom;
import com.example.SafeCare.Exception.ValidationException;
import com.example.SafeCare.Repository.CategoryRepo;
import com.example.SafeCare.Repository.ProductRepo;
import com.example.SafeCare.ResponseDTO.CategoryResponseDTO;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@Slf4j
public class CategoryServices {


    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ProductRepo productRepo;

    public CategoryResponseDTO addCategory(String CategoryName) throws Exception {
try{
    Optional<Category> category1=Optional.ofNullable(categoryRepo.findName(CategoryName));
    if(!category1.isPresent()){
        Category category=Category.builder().CategoryName(CategoryName).build();
        categoryRepo.save(category);

        log.info(CategoryName+"is successfully created");
        CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO(CategoryName);
        return categoryResponseDTO;

    }else{
        log.warn(CategoryName +"is already is present");
        throw new ValidationException("400","is already is present","1");

    }
}catch (ValidationException vx){
    throw vx;
}catch (Exception e){
log.error(String.valueOf(e));

throw e;

}




    }


    public CategoryResponseDTO editCategory(Integer id, String newName) throws Exception {
       try{
           Optional<Category> CategoryOptional=categoryRepo.findById(id);

           if(!CategoryOptional.isPresent()){
               throw new IoExceptionCustom("200","id not present","0");
           }
           Optional<Category> category1=Optional.ofNullable(categoryRepo.findName(newName));
           if (category1.isPresent()){
               throw new ValidationException("400","product name is already present","1");
           }
           Category category=CategoryOptional.get();

           category.setCategoryName(newName);

           categoryRepo.save(category);
           CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO(newName);

           return categoryResponseDTO;
       }catch (IoExceptionCustom ex){
           throw ex;

       }catch (ValidationException vx){


           throw vx;
       }catch (Exception e){
         throw e;

       }






    }


    public CategoryResponseDTO DeleteCategory(Integer id) throws Exception {
        try{
            Optional<Category> category=categoryRepo.findById(id);
            if(!category.isPresent()){
                log.warn(String.valueOf(id));
                throw new ValidationException("400","id not present","1");
            }
            Category category1=category.get();

            List<Product> productList=productRepo.findAll();

            for(Product product:productList){
                if(category1.equals(product.getCategory())){
                   throw new ValidationException("400","Category is already in use","1");
                }
            }

            categoryRepo.delete(category1);
             CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO(category1.getCategoryName());
            return categoryResponseDTO;


        } catch (ValidationException vx) {
            log.error(String.valueOf(vx));
            throw vx;
        }catch (Exception e){
            log.error(String.valueOf(e));
            throw e;
        }

    }


    public List<CategoryResponseDTO> allCategory() throws Exception {
  try {
      List<Category> categoryList=categoryRepo.findAll();
      List<CategoryResponseDTO> catList=new ArrayList<>();
      for(Category category:categoryList){
          CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO(category.getCategoryName());
          catList.add(categoryResponseDTO);
      }
      return catList;
  }catch (Exception e){
      log.error(String.valueOf(e));
      throw e;

  }

    }

}
