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
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class CategoryControllerTest {

//    @Mock
//    private CategoryServices categoryServices;
//
//    @Mock
//    private GenerateGlobalResponse generateGlobalResponse;
//
//    @InjectMocks
//    private CategoryController categoryController;
//
//    public CategoryControllerTest() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void testAddCategorySuccess() throws Exception {
//        // Mocking successful category addition
//        @Mock
//        CategoryServices categoryServices;
//
//        @Mock
//        GenerateGlobalResponse generateGlobalResponse;
//
//        @InjectMocks
//        CategoryController categoryController;
//
//    public CategoryControllerTest() {
//            MockitoAnnotations.initMocks(this);
//        }
//
//        @Test
//        void testAddCategorySuccess() throws Exception {
//            // Mocking successful category addition
//            when(categoryServices.addCategory(anyString())).thenReturn(/* Mocked category response */);
//
//            // Mocking generateGlobalResponse behavior for success scenario
//            when(generateGlobalResponse.generateGlobalResponse(
//                    any(), eq("2"), eq("200"), eq("Category added successfully")))
//                    .thenReturn(/* Mocked success response */);
//
//            // Perform the controller action
//            ResponseEntity response = categoryController.addCategory("TestCategory");
//
//            // Verify the response
//            assertEquals(HttpStatus.OK, response.getStatusCode());
//            // Add more assertions as needed for the response body
//        }
//
//    }
//
//
//
//
//    @Test
//    void testAddCategoryValidationException() throws Exception{
//        // Mocking ValidationException scenario
//        when(categoryServices.addCategory(anyString())).thenThrow(new ValidationException("200","is already is present","0"));
//        when(generateGlobalResponse.generateGlobalResponse(eq(null), anyString(), anyString(), anyString()))
//                .thenReturn(null);
//
//        // Perform the controller action
//        ResponseEntity response = categoryController.addCategory("InvalidCategory");
//
//        // Verify the response
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        // Add more assertions as needed for the response body
//        // For example, verify the content of the response body
//        assertEquals("ErrorResponse", response.getBody());
//    }

    // Add more test cases for IoExceptionCustom, other exceptions, etc.
}
