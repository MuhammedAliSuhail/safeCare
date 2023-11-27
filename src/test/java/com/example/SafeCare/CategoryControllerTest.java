package com.example.SafeCare;

import com.example.SafeCare.Controller.CategoryController;
import com.example.SafeCare.Services.CategoryServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CategoryControllerTest {
    @Mock
    private CategoryServices categoryServices;

    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddCategory_Success() throws Exception {
        // Mocking behavior of categoryServices.addCategory
        String categoryName = "TestCategory";
        when(categoryServices.addCategory(categoryName)).thenReturn("Category added successfully");

        // Testing addCategory method
        ResponseEntity<String> response = categoryController.addCategory(categoryName);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Category added successfully", response.getBody());
    }

    @Test
    public void testAddCategory_Exception() throws Exception {
        // Mocking behavior of categoryServices.addCategory to throw an exception
        String categoryName = "TestCategory";
        when(categoryServices.addCategory(categoryName)).thenThrow(new Exception("Failed to add category"));

        // Testing addCategory method for exception scenario
        ResponseEntity<String> response = categoryController.addCategory(categoryName);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Failed to add category", response.getBody());
    }
    @Test
    public void testEditCategory_Success() throws Exception {
        // Mocking behavior of categoryServices.editCategory
        int categoryId = 1;
        String newName = "NewCategoryName";
        when(categoryServices.editCategory(categoryId, newName)).thenReturn("Category updated successfully");

        // Testing editCategory method
        ResponseEntity<String> response = categoryController.editCategory(categoryId, newName);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Category updated successfully", response.getBody());
    }

    @Test
    public void testEditCategory_Exception() throws Exception{
        // Mocking behavior of categoryServices.editCategory to throw an exception
        int categoryId = 1;
        String newName = "NewCategoryName";
        when(categoryServices.editCategory(categoryId, newName)).thenThrow(new Exception("Failed to edit category"));

        // Testing editCategory method for exception scenario
        ResponseEntity<String> response = categoryController.editCategory(categoryId, newName);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Failed to edit category", response.getBody());
    }
    @Test
    public void testDeleteCategory_Success() throws Exception {
        // Mocking behavior of categoryServices.DeleteCategory
        int categoryId = 1;
        when(categoryServices.DeleteCategory(categoryId)).thenReturn("Category deleted successfully");

        // Testing DeleteCategory method
        ResponseEntity<String> response = categoryController.DeleteCategory(categoryId);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Category deleted successfully", response.getBody());
    }

    @Test
    public void testDeleteCategory_Exception() throws Exception {
        // Mocking behavior of categoryServices.DeleteCategory to throw an exception
        int categoryId = 1;
        when(categoryServices.DeleteCategory(categoryId)).thenThrow(new Exception("Failed to delete category"));

        // Testing DeleteCategory method for exception scenario
        ResponseEntity<String> response = categoryController.DeleteCategory(categoryId);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Failed to delete category", response.getBody());
    }
    @Test
    public void testAllCategory_Success() throws Exception {
        // Mocking behavior of categoryServices.allCategory
        List<String> categories = Arrays.asList("Category1", "Category2", "Category3");
        when(categoryServices.allCategory()).thenReturn(categories);

        // Testing allCategory method
        ResponseEntity<List<String>> response = categoryController.allCategory();

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(categories, response.getBody());
    }



}
