package com.example.SafeCare.Services;


import com.example.SafeCare.Entites.Category;
import com.example.SafeCare.Repository.CategoryRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
@Slf4j
public class CategoryServices {


    @Autowired
    CategoryRepo categoryRepo;

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
log.error("unexpected");

throw new Exception("something went wrong!");

}




    }
}
