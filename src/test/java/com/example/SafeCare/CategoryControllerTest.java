package com.example.SafeCare;

import com.example.SafeCare.Controller.CategoryController;
import com.example.SafeCare.Services.CategoryServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CategoryControllerTest {
    @Mock
    private CategoryServices categoryServices;

    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCategory() throws Exception {
        // Mock the behavior of categoryServices.addCategory()
        when(categoryServices.addCategory(anyString())).thenReturn("Category added successfully");

        // Perform the test by invoking the controller method
        String result = String.valueOf(categoryController.addCategory("nano"));

        // Verify the result
        assertEquals("Category added successfully", result);
    }



}
