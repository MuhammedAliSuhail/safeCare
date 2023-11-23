package com.example.SafeCare.Controller;


import com.example.SafeCare.Services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Category")
public class CategoryController {


@Autowired
    CategoryServices categoryServices;
    @PostMapping("/add")
    public String addCategory(@RequestParam String category) throws Exception {
        return categoryServices.addCategory(category);
    }
}
