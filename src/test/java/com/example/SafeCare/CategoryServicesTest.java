package com.example.SafeCare;

import com.example.SafeCare.Entites.Category;
import com.example.SafeCare.Entites.Product;
import com.example.SafeCare.Exception.IoExceptionCustom;
import com.example.SafeCare.Exception.ValidationException;
import com.example.SafeCare.Repository.CategoryRepo;
import com.example.SafeCare.Repository.ProductRepo;
import com.example.SafeCare.ResponseDTO.CategoryResponseDTO;
import com.example.SafeCare.Services.CategoryServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class CategoryServicesTest {



    @Mock
    private CategoryRepo categoryRepo;

    @InjectMocks
    private CategoryServices categoryService;
    @Mock
    private ProductRepo productRepo;

    // Assuming CategoryService contains addCategory method
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Initialize annotated mocks
    }
    @Test
    public void testAddCategory() throws Exception {
        String categoryName = "TestCategory";



        CategoryResponseDTO result = categoryService.addCategory(categoryName);
        System.out.println(result.getCategory());


      assertEquals("TestCategory",result.getCategory());

    }

    @Test
    public void testEditCategory_Success() throws Exception {
        int categoryId = 1;
        String newCategoryName = "NewCategoryName";

        Category existingCategory = new Category();
        existingCategory.setCategoryId(categoryId);
        existingCategory.setCategoryName("OldCategoryName");

        Mockito.when(categoryRepo.findById(categoryId)).thenReturn(Optional.of(existingCategory));
        Mockito.when(categoryRepo.findName(newCategoryName)).thenReturn(null);

        CategoryResponseDTO result = categoryService.editCategory(categoryId, newCategoryName);

        assertEquals(newCategoryName, result.getCategory());
        assertEquals(existingCategory.getCategoryName(), newCategoryName);
        Mockito.verify(categoryRepo, Mockito.times(1)).findById(categoryId);
        Mockito.verify(categoryRepo, Mockito.times(1)).findName(newCategoryName);
        Mockito.verify(categoryRepo, Mockito.times(1)).save(existingCategory);
    }
    @Test
    public void testEditCategory_CategoryNotFound() {
        int categoryId = 1;
        String newCategoryName = "NewCategoryName";

        Mockito.when(categoryRepo.findById(categoryId)).thenReturn(Optional.empty());

        assertThrows(IoExceptionCustom.class, () -> {
            categoryService.editCategory(categoryId, newCategoryName);
        });

        Mockito.verify(categoryRepo, Mockito.times(1)).findById(categoryId);
        Mockito.verify(categoryRepo, Mockito.never()).findName(Mockito.anyString());
        Mockito.verify(categoryRepo, Mockito.never()).save(Mockito.any(Category.class));
    }
    @Test
    public void testEditCategory_DuplicateCategoryName() {
        int categoryId = 1;
        String newCategoryName = "NewCategoryName";

        Category existingCategory = new Category();
        existingCategory.setCategoryId(2); // Another category with different ID

        Mockito.when(categoryRepo.findById(categoryId)).thenReturn(Optional.of(existingCategory));


        Mockito.when(categoryRepo.findName(newCategoryName)).thenReturn(Optional.of(existingCategory).get());

        assertThrows(ValidationException.class, () -> {
            categoryService.editCategory(categoryId, newCategoryName);
        });

        Mockito.verify(categoryRepo, Mockito.times(1)).findById(categoryId);
        Mockito.verify(categoryRepo, Mockito.times(1)).findName(newCategoryName);
        Mockito.verify(categoryRepo, Mockito.never()).save(Mockito.any(Category.class));
    }

    @Test
    public void testDeleteCategory_Success() throws Exception {
        int categoryId = 1;

        Category category = new Category();
        category.setCategoryId(categoryId);
        category.setCategoryName("TestCategory");

        Mockito.when(categoryRepo.findById(categoryId)).thenReturn(Optional.of(category));
        Mockito.when(productRepo.findAll()).thenReturn(new ArrayList<>());

        CategoryResponseDTO result = categoryService.DeleteCategory(categoryId);

        assertEquals(category.getCategoryName(), result.getCategory());
        Mockito.verify(categoryRepo, Mockito.times(1)).findById(categoryId);
        Mockito.verify(productRepo, Mockito.times(1)).findAll();
        Mockito.verify(categoryRepo, Mockito.times(1)).delete(category);
    }

    @Test
    public void testDeleteCategory_CategoryNotFound() {
        int categoryId = 1;

        Mockito.when(categoryRepo.findById(categoryId)).thenReturn(Optional.empty());

        assertThrows(ValidationException.class, () -> {
            categoryService.DeleteCategory(categoryId);
        });

        Mockito.verify(categoryRepo, Mockito.times(1)).findById(categoryId);
        Mockito.verify(productRepo, Mockito.never()).findAll();
        Mockito.verify(categoryRepo, Mockito.never()).delete(Mockito.any(Category.class));
    }

    }



