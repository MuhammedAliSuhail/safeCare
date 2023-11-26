package com.example.SafeCare.Controller;


import com.example.SafeCare.Services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Category")
public class CategoryController {


@Autowired
    CategoryServices categoryServices;
    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@RequestParam String category) throws Exception {

        try {
            String result=categoryServices.addCategory(category);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/edit")
    public ResponseEntity<String> editCategory(@RequestParam Integer id ,@RequestParam String NewName){
        try{
            return new ResponseEntity<>(categoryServices.editCategory(id,NewName),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>( e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> DeleteCategory(@RequestParam Integer id){
        try{
            return new ResponseEntity<>(categoryServices.DeleteCategory(id),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("all")
    public ResponseEntity<List<String>> allCategory(){
        try{
           return new ResponseEntity<>(categoryServices.allCategory(),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
