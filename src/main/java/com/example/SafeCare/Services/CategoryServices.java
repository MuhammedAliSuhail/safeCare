package com.example.SafeCare.Services;


import com.example.SafeCare.CustomException.CategoryExeption;
import com.example.SafeCare.CustomException.CategoryNotFound;
import com.example.SafeCare.CustomException.customException;
import com.example.SafeCare.Entites.Category;
import com.example.SafeCare.Entites.Product;
import com.example.SafeCare.Entites.UnitOfMeasurement;
import com.example.SafeCare.Repository.CategoryRepo;
import com.example.SafeCare.Repository.ProductRepo;
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

    public String addCategory(String CategoryName) throws Exception {
try{
    Optional<Category> category1=Optional.ofNullable(categoryRepo.findName(CategoryName));
    if(!category1.isPresent()){
        Category category=Category.builder().CategoryName(CategoryName).build();
        categoryRepo.save(category);

        log.info(CategoryName+"is successfully created");
        return "Category added successfully";

    }else{
        log.warn(CategoryName +"is already is present");
         return "Category name is already exist";

    }
}catch (Exception e){
log.error(String.valueOf(e));

throw new customException("something went wrong!");

}




    }


    public String editCategory(Integer id, String newName) throws Exception {
       try{
           Optional<Category> CategoryOptional=categoryRepo.findById(id);

           if(!CategoryOptional.isPresent()){
               throw new CategoryNotFound();
           }
           Category category=CategoryOptional.get();

           category.setCategoryName(newName);

           categoryRepo.save(category);

           return "updated";
       }catch (CategoryNotFound e){

           log.error(String.valueOf(e));
           throw new CategoryNotFound();
       }catch (Exception e){
           log.error(String.valueOf(e));
           throw new customException("something went wrong !");
       }






    }


    public String DeleteCategory(Integer id) throws Exception {
        try{
            Optional<Category> category=categoryRepo.findById(id);
            if(!category.isPresent()){
                log.warn(String.valueOf(id));
                return "id not present";
            }
            Category category1=category.get();

            List<Product> productList=productRepo.findAll();

            for(Product product:productList){
                if(category1.equals(product.getCategory())){
                   throw new CategoryExeption();
                }
            }

            categoryRepo.delete(category1);

            return "deleted";


        } catch (CategoryExeption e) {
            log.error(String.valueOf(e));
            throw new CategoryExeption();
        }catch (Exception e){
            log.error(String.valueOf(e));
            throw new customException("something went wrong !");
        }

    }


    public List<String> allCategory() throws customException {
  try {
      List<Category> categoryList=categoryRepo.findAll();
      List<String> catList=new ArrayList<>();
      for(Category category:categoryList){
          catList.add(category.getCategoryName());
      }
      return catList;
  }catch (Exception e){
      log.error(String.valueOf(e));
      throw new customException("something went wrong!");

  }

    }

}
