package com.example.SafeCare;

import com.example.SafeCare.Entites.Category;
import com.example.SafeCare.Entites.Product;
import com.example.SafeCare.Entites.UnitOfMeasurement;
import com.example.SafeCare.Exception.IoExceptionCustom;
import com.example.SafeCare.Exception.ValidationException;
import com.example.SafeCare.Repository.ProductRepo;
import com.example.SafeCare.Repository.UnitOfMeasurementRepo;
import com.example.SafeCare.ResponseDTO.CategoryResponseDTO;
import com.example.SafeCare.ResponseDTO.UnitOfMeasurementResponseDTO;
import com.example.SafeCare.Services.UnitOfMeasurementServices;
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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class UnitServiceTest {

    @Mock
    private UnitOfMeasurementRepo unitOfMeasurementRepo;

    @InjectMocks
    private UnitOfMeasurementServices unitOfMeasurementService; // Assuming UnitOfMeasurementService contains addUnitOfMeasurement method
    @Mock
    private ProductRepo productRepo;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUnitOfMeasurement_Success() throws Exception {
        String categoryName = "TestCategory";



        UnitOfMeasurementResponseDTO result = unitOfMeasurementService.addUnitOfMeasurement(categoryName);
        System.out.println(result.getUnitOfMeasurement());


        Assertions.assertEquals("TestCategory",result.getUnitOfMeasurement());
    }

    @Test
    public void testEditUnitOfMeasurement_Success() throws Exception {
        int categoryId = 1;
        String newCategoryName = "NewUnitName";

        UnitOfMeasurement existingCategory = new UnitOfMeasurement();
        existingCategory.setUnitOfMeasurementId(categoryId);
        existingCategory.setUnitOfMeasurementName("OldUnitName");

        Mockito.when(unitOfMeasurementRepo.findById(categoryId)).thenReturn(Optional.of(existingCategory));
        Mockito.when(unitOfMeasurementRepo.findName(newCategoryName)).thenReturn(null);

        UnitOfMeasurementResponseDTO result = unitOfMeasurementService.editUnitOfMeasurement(categoryId, newCategoryName);

        Assertions.assertEquals(newCategoryName, result.getUnitOfMeasurement());
        Assertions.assertEquals(existingCategory.getUnitOfMeasurementName(), newCategoryName);
        Mockito.verify(unitOfMeasurementRepo, Mockito.times(1)).findById(categoryId);
        Mockito.verify(unitOfMeasurementRepo, Mockito.times(1)).findName(newCategoryName);
        Mockito.verify(unitOfMeasurementRepo, Mockito.times(1)).save(existingCategory);
    }

    @Test
    public void testEditUnitOfMeasurement_UnitNotFound() {
        int unitId = 1;
        String newName = "NewMeter";

        Mockito.when(unitOfMeasurementRepo.findById(unitId)).thenReturn(Optional.empty());

        assertThrows(IoExceptionCustom.class, () -> {
            unitOfMeasurementService.editUnitOfMeasurement(unitId, newName);
        });

        Mockito.verify(unitOfMeasurementRepo, Mockito.times(1)).findById(unitId);
        Mockito.verify(unitOfMeasurementRepo, Mockito.never()).findName(Mockito.anyString());
        Mockito.verify(unitOfMeasurementRepo, Mockito.never()).save(Mockito.any(UnitOfMeasurement.class));
    }

    @Test
    public void testEditUnitOfMeasurement_DuplicateUnitName() {
        int unitId = 1;
        String newName = "NewMeter";

        UnitOfMeasurement existingUnit = new UnitOfMeasurement();
        existingUnit.setUnitOfMeasurementId(2); // Another unit with different ID but same name

        Mockito.when(unitOfMeasurementRepo.findById(unitId)).thenReturn(Optional.of(existingUnit));
        Mockito.when(unitOfMeasurementRepo.findName(newName)).thenReturn(Optional.of(existingUnit).get());

        assertThrows(ValidationException.class, () -> {
            unitOfMeasurementService.editUnitOfMeasurement(unitId, newName);
        });

        Mockito.verify(unitOfMeasurementRepo, Mockito.times(1)).findById(unitId);
        Mockito.verify(unitOfMeasurementRepo, Mockito.times(1)).findName(newName);
        Mockito.verify(unitOfMeasurementRepo, Mockito.never()).save(Mockito.any(UnitOfMeasurement.class));
    }


    @Test
    public void testDeleteUnitOfMeasurement_Success() throws Exception {
        int unitId = 1;
        String unitName = "Meter";

        UnitOfMeasurement unitOfMeasurement = new UnitOfMeasurement();
        unitOfMeasurement.setUnitOfMeasurementId(unitId);
        unitOfMeasurement.setUnitOfMeasurementName(unitName);

        Mockito.when(unitOfMeasurementRepo.findById(unitId)).thenReturn(Optional.of(unitOfMeasurement));
        Mockito.when(productRepo.findAll()).thenReturn(new ArrayList<>());

        UnitOfMeasurementResponseDTO result = unitOfMeasurementService.DeleteUnitOfMeasurement(unitId);

        Assertions.assertEquals(unitName, result.getUnitOfMeasurement());
        Mockito.verify(unitOfMeasurementRepo, Mockito.times(1)).findById(unitId);
        Mockito.verify(productRepo, Mockito.times(1)).findAll();
        Mockito.verify(unitOfMeasurementRepo, Mockito.times(1)).delete(unitOfMeasurement);
    }

    @Test
    public void testDeleteUnitOfMeasurement_UnitInUse() {
        int unitId = 1;
        String unitName = "Meter";

        UnitOfMeasurement unitOfMeasurement = new UnitOfMeasurement();
        unitOfMeasurement.setUnitOfMeasurementId(unitId);
        unitOfMeasurement.setUnitOfMeasurementName(unitName);

        List<Product> productList = new ArrayList<>();
               Product Product1 = new Product();
               Product1.setProductName("Test Product");
               Product1.setSellingPrice(10.5);
//               ProductDTO.setCategory("Dairy");
               Product1.setMaxOrderLevel(10);
               Product1.setPurchasePrice(5);
               Product1.setReOrderLevel(10);
               Product1.setUnitMasherment(unitOfMeasurement);
        productList.add(Product1);

        Mockito.when(unitOfMeasurementRepo.findById(unitId)).thenReturn(Optional.of(unitOfMeasurement));
        Mockito.when(productRepo.findAll()).thenReturn(productList);

        assertThrows(ValidationException.class, () -> {
            unitOfMeasurementService.DeleteUnitOfMeasurement(unitId);
        });

        Mockito.verify(unitOfMeasurementRepo, Mockito.times(1)).findById(unitId);
        Mockito.verify(productRepo, Mockito.times(1)).findAll();
        Mockito.verify(unitOfMeasurementRepo, Mockito.never()).delete(Mockito.any(UnitOfMeasurement.class));
    }

    @Test
    public void testDeleteUnitOfMeasurement_UnitNotFound() {
        int unitId = 1;

        Mockito.when(unitOfMeasurementRepo.findById(unitId)).thenReturn(Optional.empty());

        assertThrows(IoExceptionCustom.class, () -> {
            unitOfMeasurementService.DeleteUnitOfMeasurement(unitId);
        });

        Mockito.verify(unitOfMeasurementRepo, Mockito.times(1)).findById(unitId);
        Mockito.verify(productRepo, Mockito.never()).findAll();
        Mockito.verify(unitOfMeasurementRepo, Mockito.never()).delete(Mockito.any(UnitOfMeasurement.class));
    }

    @Test
    public void testAllUnits_Success() throws Exception {
        List<UnitOfMeasurement> mockedUnits = new ArrayList<>();
        UnitOfMeasurement unit=new UnitOfMeasurement();
        unit.setUnitOfMeasurementName("cm");
        mockedUnits.add(unit);
        UnitOfMeasurement unit1=new UnitOfMeasurement();
        unit1.setUnitOfMeasurementName("Kilogram");
        mockedUnits.add(unit1);

        Mockito.when(unitOfMeasurementRepo.findAll()).thenReturn(mockedUnits);

        List<UnitOfMeasurementResponseDTO> result = unitOfMeasurementService.allUnits();

        Assertions.assertEquals(mockedUnits.size(), result.size());
        for (int i = 0; i < mockedUnits.size(); i++) {
            Assertions.assertEquals(mockedUnits.get(i).getUnitOfMeasurementName(), result.get(i).getUnitOfMeasurement());
        }

        Mockito.verify(unitOfMeasurementRepo, Mockito.times(1)).findAll();
    }

}
