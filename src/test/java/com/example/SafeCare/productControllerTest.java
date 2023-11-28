package com.example.SafeCare;

import com.example.SafeCare.Controller.ProductController;
import com.example.SafeCare.RequetsDTO.addProductDTO;
import com.example.SafeCare.ResponseDTO.ProductResponseDTO;
import com.example.SafeCare.Services.ProductServices;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class productControllerTest {
//    @Mock
//    private ProductServices productServices;
//
//    @InjectMocks
//    private ProductController productController;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testAddProduct_Success() throws Exception {
//        // Mock the behavior of productServices.addProduct() to return a success message
//        doReturn("Product added successfully").when(productServices).addProduct(any(addProductDTO.class));
//
//        // Create a sample addProductDTO
//        addProductDTO mockProductDTO = new addProductDTO();
//        mockProductDTO.setProductName("Test Product");
//        mockProductDTO.setSellingPrice(10.5);
//        mockProductDTO.setCategory("Dairy");
//        mockProductDTO.setMaxOrderLevel(10);
//        mockProductDTO.setPurchasePrice(5);
//        mockProductDTO.setReOrderLevel(10);
//        mockProductDTO.setUnitMasherment("cm"); // Set other necessary fields
//
//        // Perform the test by invoking the controller method
//        String result = String.valueOf(productController.addProduct(mockProductDTO));
//
//        // Verify the result
//        assertEquals("<201 CREATED Created,Product added successfully,[]>", result);
//    }
//
//    @Test
//    public void testAddProduct_Exception() throws Exception {
//        // Mock the behavior of productServices.addProduct() to throw an exception
//        doThrow(new RuntimeException("Error adding product")).when(productServices).addProduct(any(addProductDTO.class));
//
//        // Create a sample addProductDTO
//        addProductDTO mockProductDTO = new addProductDTO();
//        mockProductDTO.setProductName("Test Product");
//        mockProductDTO.setSellingPrice(10.5);
//        mockProductDTO.setCategory("Dairy");
//        mockProductDTO.setMaxOrderLevel(10);
//        mockProductDTO.setPurchasePrice(5);
//        mockProductDTO.setReOrderLevel(10);
//        mockProductDTO.setUnitMasherment("cm"); // Set other necessary fields
//
//        // Perform the test and expect an exception
//        try {
//            productController.addProduct(mockProductDTO);
//        } catch (Exception e) {
//            assertEquals("Error adding product", e.getMessage());
//        }
//    }
//    @Test
//    public void testEditProduct_Success() throws Exception {
//        // Mocking behavior of productServices.editProduct
//        int productId = 1;
//        addProductDTO productDTO = new addProductDTO(/* Fill in necessary details */);
//        when(productServices.editProduct(productId, productDTO)).thenReturn("Product edited successfully");
//
//        // Testing editProduct method
//        ResponseEntity<String> response = productController.editProduct(productId, productDTO);
//
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals("Product edited successfully", response.getBody());
//    }
//
//    @Test
//    public void testEditProduct_Exception() throws Exception{
//        // Mocking behavior of productServices.editProduct to throw an exception
//        int productId = 1;
//        addProductDTO productDTO = new addProductDTO(/* Fill in necessary details */);
//        when(productServices.editProduct(productId, productDTO)).thenThrow(new Exception("Failed to edit product"));
//
//        // Testing editProduct method for exception scenario
//        ResponseEntity<String> response = productController.editProduct(productId, productDTO);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals("Failed to edit product", response.getBody());
//    }
//    @Test
//    public void testDeleteProduct_Success() throws Exception {
//        // Mocking behavior of productServices.deleteProduct
//        int productId = 1;
//        when(productServices.deleteProduct(productId)).thenReturn("Product deleted successfully");
//
//        // Testing deleteProduct method
//        ResponseEntity<String> response = productController.deleteProduct(productId);
//
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals("Product deleted successfully", response.getBody());
//    }
//
//    @Test
//    public void testDeleteProduct_Exception() throws Exception{
//        // Mocking behavior of productServices.deleteProduct to throw an exception
//        int productId = 1;
//        when(productServices.deleteProduct(productId)).thenThrow(new Exception("Failed to delete product"));
//
//        // Testing deleteProduct method for exception scenario
//        ResponseEntity<String> response = productController.deleteProduct(productId);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals("Failed to delete product", response.getBody());
//    }
//    @Test
//    public void testAllProduct_Success()throws Exception {
//        // Mocking behavior of productServices.allproducts
//        List<ProductResponseDTO> products = Arrays.asList(
//                new ProductResponseDTO(/* Fill in necessary details */),
//                new ProductResponseDTO(/* Fill in necessary details */)
//                // Add more mock data as needed
//        );
//        when(productServices.allproducts()).thenReturn(products);
//
//        // Testing allProduct method
//        ResponseEntity<List<ProductResponseDTO>> response = productController.allProduct();
//
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(products, response.getBody());
//    }
//
//    @Test
//    public void testAllProduct_Exception() throws Exception {
//        // Mocking behavior of productServices.allproducts to throw an exception
//        when(productServices.allproducts()).thenThrow(new Exception("Failed to fetch products"));
//
//        // Testing allProduct method for exception scenario
//        ResponseEntity<List<ProductResponseDTO>> response = productController.allProduct();
//
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
//        assertEquals(null, response.getBody());
//    }
}
