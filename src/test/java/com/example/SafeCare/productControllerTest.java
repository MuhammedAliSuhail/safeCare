package com.example.SafeCare;

import com.example.SafeCare.Controller.ProductController;
import com.example.SafeCare.Entites.Category;
import com.example.SafeCare.Entites.UnitOfMeasurement;
import com.example.SafeCare.Exception.IoExceptionCustom;
import com.example.SafeCare.Exception.ValidationException;
import com.example.SafeCare.RequetsDTO.addProductDTO;
import com.example.SafeCare.Response.GenerateGlobalResponse;
import com.example.SafeCare.ResponseDTO.ProductResponseDTO;
import com.example.SafeCare.Services.ProductServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        MockitoAnnotations.openMocks(this);
    }
        @Test
        public void testAddProduct_Success () throws Exception {
            addProductDTO mockProductDTO = new addProductDTO();

            mockProductDTO .setProductName("Test Product");
            mockProductDTO .setCategory("Dairy");
            mockProductDTO .setSellingPrice(10.5);
            mockProductDTO .setMaxOrderLevel(10);
            mockProductDTO .setPurchasePrice(5);
            mockProductDTO .setReOrderLevel(10);
            mockProductDTO.setUnitMasherment("newUnit");







            ProductResponseDTO productResponseDTO=new ProductResponseDTO();
            productResponseDTO.setProductName("Test Product");
            productResponseDTO.setCategory("Dairy");
            productResponseDTO.setSellingPrice(10.5);
            productResponseDTO.setMaxOrderLevel(10);
            productResponseDTO.setPurchasePrice(5);
            productResponseDTO.setReOrderLevel(10);
            productResponseDTO.setUnitMeasurement("newUnit");
            Mockito.when(productServices.addProduct(mockProductDTO)).thenReturn(productResponseDTO);

            ProductResponseDTO productResponseDTO1=productServices.addProduct(mockProductDTO);

            assertEquals("Test Product", productResponseDTO1.getProductName());

        }



    @Test
    public void testDeleteProduct_Success() throws Exception {
        Integer productId = 1; // Provide a mock product ID for deletion

        ProductResponseDTO mockResponseDTO = new ProductResponseDTO();
        mockResponseDTO.setProductName("Test Product");
        mockResponseDTO.setCategory("Dairy");
        mockResponseDTO.setSellingPrice(10.5);
        mockResponseDTO.setMaxOrderLevel(10);
        mockResponseDTO.setPurchasePrice(5);
        mockResponseDTO.setReOrderLevel(10);
        mockResponseDTO.setUnitMeasurement("newUnit");

        Mockito.when(productServices.deleteProduct(productId)).thenReturn(mockResponseDTO);

        ProductResponseDTO product  = productServices.deleteProduct(productId);

        assertEquals("Test Product",product.getProductName());

    }



    @Test
    public void testEditProduct_Success() throws Exception {
        Integer productId = 1; // Provide a mock product ID for editing
        addProductDTO productDTO = new addProductDTO();
        addProductDTO mockProductDTO = new addProductDTO();

        mockProductDTO .setProductName("Tes Product");
        mockProductDTO .setCategory("Dairy");
        mockProductDTO .setSellingPrice(10.5);
        mockProductDTO .setMaxOrderLevel(10);
        mockProductDTO .setPurchasePrice(5);
        mockProductDTO .setReOrderLevel(10);
        mockProductDTO.setUnitMasherment("newUnit");


        ProductResponseDTO mockResponseDTO = new ProductResponseDTO();
        mockResponseDTO.setProductName("Test Product");
        mockResponseDTO.setCategory("Dairy");
        mockResponseDTO.setSellingPrice(10.5);
        mockResponseDTO.setMaxOrderLevel(10);
        mockResponseDTO.setPurchasePrice(5);
        mockResponseDTO.setReOrderLevel(10);
        mockResponseDTO.setUnitMeasurement("newUnit");

        Mockito.when(productServices.editProduct(productId, productDTO)).thenReturn(mockResponseDTO);

        ProductResponseDTO responseEntity = productServices.editProduct(productId, productDTO);

        assertEquals("Test Product", responseEntity.getProductName());

    }




    }
