package com.example.SafeCare;

import com.example.SafeCare.Entites.Category;
import com.example.SafeCare.Entites.Product;
import com.example.SafeCare.Entites.UnitOfMeasurement;
import com.example.SafeCare.Exception.IoExceptionCustom;
import com.example.SafeCare.Repository.CategoryRepo;
import com.example.SafeCare.Repository.ProductRepo;
import com.example.SafeCare.Repository.UnitOfMeasurementRepo;
import com.example.SafeCare.RequetsDTO.addProductDTO;
import com.example.SafeCare.ResponseDTO.ProductResponseDTO;
import com.example.SafeCare.Services.ProductServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceTest {

    @Mock
    private ProductRepo productRepo;

    @Mock
    private CategoryRepo categoryRepo;

    @Mock
    private UnitOfMeasurementRepo unitOfMeasurementRepo;

    @InjectMocks
    private ProductServices productService; // Assuming ProductService contains editProduct method

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEditProduct_Success() throws Exception {
        int productId = 1;

        addProductDTO productDTO = new addProductDTO();
        // Set necessary attributes for productDTO
        productDTO.setProductName("Test Product");
        productDTO.setCategory("Dairy");
        productDTO.setSellingPrice(10.5);
        productDTO.setMaxOrderLevel(10);
        productDTO.setPurchasePrice(5);
        productDTO.setReOrderLevel(10);
        Category category=new Category();
        category.setCategoryId(1);
        category.setCategoryName("Dairy");
        UnitOfMeasurement unit=new UnitOfMeasurement();
        unit.setUnitOfMeasurementId(1);
        unit.setUnitOfMeasurementName("newUnit");

        Product product=new Product();
        Product product1=new Product();
        // Set necessary attributes for product
         product.setProductId(1);
        product.setProductName("Test Product");
        product.setSellingPrice(10.5);

        category.setCategoryId(1);
        category.setCategoryName("Dairy");
               product.setCategory(category);
        product.setMaxOrderLevel(10);
        product.setPurchasePrice(5);
        product.setReOrderLevel(10);

        unit.setUnitOfMeasurementId(1);
        unit.setUnitOfMeasurementName("newUnit");
        product.setUnitMasherment(unit);
        ProductResponseDTO productResponseDTO=new ProductResponseDTO();
        productResponseDTO.setProductName("Test Product");
        productResponseDTO.setUnitMeasurement("newUnit");
        productResponseDTO.setCategory("Dairy");
        productResponseDTO.setSellingPrice(10.5);
        productResponseDTO.setMaxOrderLevel(10);
        productResponseDTO.setPurchasePrice(5);
        productResponseDTO.setReOrderLevel(10);
        Optional<Product> mockedProduct = Optional.of(product);
        Optional<Category> mockedCategory = Optional.of(category);
        Optional<UnitOfMeasurement> mockedUnitOfMeasurement = Optional.of(unit);

        Mockito.when(productRepo.findById(1)).thenReturn(mockedProduct);
        Mockito.when(categoryRepo.findName(productDTO.getCategory())).thenReturn(mockedCategory.get());
        Mockito.when(unitOfMeasurementRepo.findName(productDTO.getUnitMasherment())).thenReturn(mockedUnitOfMeasurement.get());


//        Mockito.when(productRepo.save(product));

        ProductResponseDTO result = productService.editProduct(1, productDTO);
//        ProductResponseDTO result1 = productService.editProduct(productId, productDTO);


        // Add assertions to validate the result based on expected values
        Assertions.assertEquals(productResponseDTO, result);


    }
    @Test
    public void testAddProduct_Success() throws Exception {
        addProductDTO productDTO = new addProductDTO();
        // Set necessary attributes for productDTO
  Product product=new Product();

        productDTO.setProductName("Test Product");
        productDTO.setCategory("Dairy");
        productDTO.setSellingPrice(10.5);
        productDTO.setMaxOrderLevel(10);
        productDTO.setPurchasePrice(5);
        productDTO.setReOrderLevel(10);
        Category category=new Category();
        category.setCategoryId(1);
        category.setCategoryName("Dairy");
        UnitOfMeasurement unit=new UnitOfMeasurement();
        unit.setUnitOfMeasurementId(1);
        unit.setUnitOfMeasurementName("newUnit");

product.setProductId(1);
        product.setProductName("Test Product");
        product.setCategory(category);
        product.setUnitMasherment(unit);
        product.setSellingPrice(10.5);
        product.setMaxOrderLevel(10);
        product.setPurchasePrice(5);
        product.setReOrderLevel(10);

        category.setCategoryId(1);
        category.setCategoryName("Dairy");

        unit.setUnitOfMeasurementId(1);
        unit.setUnitOfMeasurementName("newUnit");
        Optional<Category> mockedCategory = Optional.of(category);
        Optional<UnitOfMeasurement> mockedUnitOfMeasurement = Optional.of(unit);
        Optional<Product> mockedExistingProduct = Optional.empty();

        Mockito.when(categoryRepo.findName(productDTO.getCategory())).thenReturn(mockedCategory.get());
        Mockito.when(unitOfMeasurementRepo.findName(productDTO.getUnitMasherment())).thenReturn(mockedUnitOfMeasurement.get());
//        Mockito.when(productRepo.findName(productDTO.getProductName())).thenReturn(mockedExistingProduct.get());
//        Mockito.when(productRepo.save(product)).thenReturn(product);



        ProductResponseDTO result = productService.addProduct(productDTO);
        ProductResponseDTO productResponseDTO=new ProductResponseDTO();
        productResponseDTO.setProductName("Test Product");
        productResponseDTO.setCategory("Dairy");
        productResponseDTO.setSellingPrice(10.5);
        productResponseDTO.setMaxOrderLevel(10);
        productResponseDTO.setPurchasePrice(5);
        productResponseDTO.setReOrderLevel(10);
        productResponseDTO.setUnitMeasurement("newUnit");
        // Add assertions to validate the result based on expected values
        Assertions.assertEquals(productResponseDTO, result);

    }
    @Test
    public void testDeleteProduct_Success() throws Exception {
        int productId = 1;

        Product product = new Product();
        // Set necessary attributes for product


        // Set necessary attributes for product
        product.setProductId(1);
        product.setProductName("Test Product");
        product.setSellingPrice(10.5);
  Category category=new Category();
        category.setCategoryId(1);
        category.setCategoryName("Dairy");
        product.setCategory(category);
        product.setMaxOrderLevel(10);
        product.setPurchasePrice(5);
        product.setReOrderLevel(10);
  UnitOfMeasurement unit=new UnitOfMeasurement();
        unit.setUnitOfMeasurementId(1);
        unit.setUnitOfMeasurementName("newUnit");
        product.setUnitMasherment(unit);
        Optional<Product> mockedProduct = Optional.of(product);
        Optional<Category> mockedCategory = Optional.of(category);
        Optional<UnitOfMeasurement> mockedUnitOfMeasurement = Optional.of(unit);
        Mockito.when(categoryRepo.findName(product.getCategory().getCategoryName())).thenReturn(mockedCategory.get());
        Mockito.when(unitOfMeasurementRepo.findName(product.getUnitMasherment().getUnitOfMeasurementName())).thenReturn(mockedUnitOfMeasurement.get());
        Mockito.when(productRepo.findById(productId)).thenReturn(mockedProduct);

        ProductResponseDTO result = productService.deleteProduct(productId);

       Assertions. assertEquals(product.getProductName(), result.getProductName());



    }

    @Test
    public void testDeleteProduct_ProductNotFound() {
        int productId = 1;

        Mockito.when(productRepo.findById(productId)).thenReturn(Optional.empty());

        Assertions. assertThrows(IoExceptionCustom.class, () -> {
            productService.deleteProduct(productId);
        });

        Mockito.verify(productRepo, Mockito.times(1)).findById(productId);
        Mockito.verify(productRepo, Mockito.never()).save(Mockito.any());
        Mockito.verify(productRepo, Mockito.never()).delete(Mockito.any());
    }

    @Test
    public void testAllProducts_Success() throws Exception {
        List<Product> mockedProducts = new ArrayList<>();
        mockedProducts.add(createMockProduct("Product1", 10.0, 20.0, 5, 100, "Category1", "Unit1"));
        mockedProducts.add(createMockProduct("Product2", 15.0, 25.0, 7, 150, "Category2", "Unit2"));

        Mockito.when(productRepo.findAll()).thenReturn(mockedProducts);

        List<ProductResponseDTO> result = productService.allproducts();

        Assertions.assertEquals(mockedProducts.size(), result.size());
        // Add assertions to validate the result based on expected values
        // Example: assertEquals(expectedValue, result.get(0).getSomeValue());

        Mockito.verify(productRepo, Mockito.times(1)).findAll();
    }

    // Helper method to create a mock Product object
    private Product createMockProduct(String productName, double purchasePrice, double sellingPrice, int reOrderLevel, int maxOrderLevel, String categoryName, String unitName) {
        Product product = new Product();
        product.setProductName(productName);
        product.setPurchasePrice(purchasePrice);
        product.setSellingPrice(sellingPrice);
        product.setReOrderLevel(reOrderLevel);
        product.setMaxOrderLevel(maxOrderLevel);

        Category category = new Category();
        category.setCategoryName(categoryName);
        product.setCategory(category);

        UnitOfMeasurement unitOfMeasurement = new UnitOfMeasurement();
        unitOfMeasurement.setUnitOfMeasurementName(unitName);
        product.setUnitMasherment(unitOfMeasurement);

        return product;
    }

}
