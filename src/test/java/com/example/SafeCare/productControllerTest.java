package com.example.SafeCare;

import com.example.SafeCare.Controller.ProductController;
import com.example.SafeCare.RequetsDTO.addProductDTO;
import com.example.SafeCare.Services.ProductServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class productControllerTest {
    @Mock
    private ProductServices productServices;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProduct_Success() throws Exception {
        // Mock the behavior of productServices.addProduct() to return a success message
        doReturn("Product added successfully").when(productServices).addProduct(any(addProductDTO.class));

        // Create a sample addProductDTO
        addProductDTO mockProductDTO = new addProductDTO();
        mockProductDTO.setProductName("Test Product");
        mockProductDTO.setSellingPrice(10.5);
        mockProductDTO.setCategory("Dairy");
        mockProductDTO.setMaxOrderLevel(10);
        mockProductDTO.setPurchasePrice(5);
        mockProductDTO.setReOrderLevel(10);
        mockProductDTO.setUnitMasherment("cm"); // Set other necessary fields

        // Perform the test by invoking the controller method
        String result = productController.addProduct(mockProductDTO);

        // Verify the result
        assertEquals("Product added successfully", result);
    }

    @Test
    public void testAddProduct_Exception() throws Exception {
        // Mock the behavior of productServices.addProduct() to throw an exception
        doThrow(new RuntimeException("Error adding product")).when(productServices).addProduct(any(addProductDTO.class));

        // Create a sample addProductDTO
        addProductDTO mockProductDTO = new addProductDTO();
        mockProductDTO.setProductName("Test Product");
        mockProductDTO.setSellingPrice(10.5);
        mockProductDTO.setCategory("Dairy");
        mockProductDTO.setMaxOrderLevel(10);
        mockProductDTO.setPurchasePrice(5);
        mockProductDTO.setReOrderLevel(10);
        mockProductDTO.setUnitMasherment("cm"); // Set other necessary fields

        // Perform the test and expect an exception
        try {
            productController.addProduct(mockProductDTO);
        } catch (Exception e) {
            assertEquals("java.lang.RuntimeException: Error adding product", e.getMessage());
        }
    }
}
