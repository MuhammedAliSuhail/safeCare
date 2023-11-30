package com.example.SafeCare;

import com.example.SafeCare.Controller.CategoryController;
import com.example.SafeCare.Exception.ValidationException;
import com.example.SafeCare.Response.GenerateGlobalResponse;
import com.example.SafeCare.Response.GlobalResponse;
import com.example.SafeCare.ResponseDTO.CategoryResponseDTO;
import com.example.SafeCare.Services.CategoryServices;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class CategoryControllerTest {

    @Mock
    private CategoryServices categoryServices;

    @Mock
    private GenerateGlobalResponse generateGlobalResponse;

    @InjectMocks
    private CategoryController categoryController;

    public CategoryControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddCategory_Success() throws Exception {
        String categoryName = "TestCategory";

        CategoryResponseDTO mockResponseDTO = new CategoryResponseDTO(categoryName);
        Mockito.when(categoryServices.addCategory(categoryName)).thenReturn(mockResponseDTO);

        ResponseEntity responseEntity = categoryController.addCategory(categoryName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        // Add more assertions to validate the response entity contents based on the mock responseDTO
    }
    @Test
    public void testAddCategory_ValidationException() throws Exception {
        String categoryName = "TestCategory";

        Mockito.when(categoryServices.addCategory(categoryName))
                .thenThrow(new ValidationException("400", "Validation error", "1"));

        ResponseEntity responseEntity = categoryController.addCategory(categoryName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        // Add assertions to validate the response entity contents for ValidationException
    }
    @Test
    public void testEditCategory_Success() throws Exception {
        int categoryId = 1;
        String newName = "NewCategoryName";

        CategoryResponseDTO mockResponseDTO = new CategoryResponseDTO(newName);
        Mockito.when(categoryServices.editCategory(categoryId, newName)).thenReturn(mockResponseDTO);

        ResponseEntity responseEntity = categoryController.editCategory(categoryId, newName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        // Add more assertions to validate the response entity contents based on the mock responseDTO
    }
    @Test
    public void testEditCategory_ValidationException() throws Exception {
        int categoryId = 1;
        String newName = "NewCategoryName";

        Mockito.when(categoryServices.editCategory(categoryId, newName))
                .thenThrow(new ValidationException("400", "Validation error", "1"));

        ResponseEntity responseEntity = categoryController.editCategory(categoryId, newName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        // Add assertions to validate the response entity contents for ValidationException
    }
    @Test
    public void testDeleteCategory_Success() throws Exception {
        int categoryId = 1;

        CategoryResponseDTO mockResponseDTO = new CategoryResponseDTO("DeletedCategory");
        Mockito.when(categoryServices.DeleteCategory(categoryId)).thenReturn(mockResponseDTO);

        ResponseEntity responseEntity = categoryController.DeleteCategory(categoryId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        // Add more assertions to validate the response entity contents based on the mock responseDTO
    }

    @Test
    public void testDeleteCategory_ValidationException() throws Exception {
        int categoryId = 1;

        Mockito.when(categoryServices.DeleteCategory(categoryId))
                .thenThrow(new ValidationException("400", "Validation error", "1"));

        ResponseEntity responseEntity = categoryController.DeleteCategory(categoryId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        // Add assertions to validate the response entity contents for ValidationException
    }
    @Test
    public void testAllCategory_Success() throws Exception {
        // Mock data or response that the service should return
        List<CategoryResponseDTO> mockCategories = Arrays.asList(
                new CategoryResponseDTO("Category1"),
                new CategoryResponseDTO("Category2")
        );

        Mockito.when(categoryServices.allCategory()).thenReturn(mockCategories);

        ResponseEntity responseEntity = categoryController.allCategory();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        // Add more assertions to validate the response entity contents based on the mockCategories
    }

    @Test
    public void testAllCategory_Exception() throws Exception {
        Mockito.when(categoryServices.allCategory()).thenThrow(new Exception("Some error occurred"));

        ResponseEntity responseEntity = categoryController.allCategory();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        // Add assertions to validate the response entity contents for Exception case
    }
}
