package com.example.SafeCare;

import com.example.SafeCare.Controller.CategoryController;
import com.example.SafeCare.Controller.UnitOfMeasurementController;
import com.example.SafeCare.Exception.IoExceptionCustom;
import com.example.SafeCare.Exception.ValidationException;
import com.example.SafeCare.Response.GenerateGlobalResponse;
import com.example.SafeCare.Response.GlobalResponse;
import com.example.SafeCare.ResponseDTO.CategoryResponseDTO;
import com.example.SafeCare.ResponseDTO.UnitOfMeasurementResponseDTO;
import com.example.SafeCare.Services.UnitOfMeasurementServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class UnitOfMeasurmentTest {


    @Mock
    UnitOfMeasurementServices unitOfMeasurementServices;

    @Mock
    GenerateGlobalResponse generateGlobalResponse;

    @InjectMocks
    UnitOfMeasurementController unitOfMeasurementController;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testAddUnitOfMeasurement_Success() throws Exception {
        String unitName = "TestUnit";

        UnitOfMeasurementResponseDTO mockResponseDTO = new UnitOfMeasurementResponseDTO(unitName);
        Mockito.when(unitOfMeasurementServices.addUnitOfMeasurement(unitName)).thenReturn(mockResponseDTO);

        ResponseEntity responseEntity = unitOfMeasurementController.addUnitOfmeasurment(unitName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }

    @Test
    public void testAddUnitOfMeasurement_ValidationException() throws Exception {
        String unitName = "TestUnit";

        Mockito.when(unitOfMeasurementServices.addUnitOfMeasurement(unitName))
                .thenThrow(new ValidationException("400", "Validation error", "1"));

        ResponseEntity responseEntity = unitOfMeasurementController.addUnitOfmeasurment(unitName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }

    @Test
    public void testAddUnitOfMeasurement_IoException() throws Exception {
        String unitName = "TestUnit";

        Mockito.when(unitOfMeasurementServices.addUnitOfMeasurement(unitName))
                .thenThrow(new IoExceptionCustom("500", "IO Exception", "1"));

        ResponseEntity responseEntity = unitOfMeasurementController.addUnitOfmeasurment(unitName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }
    @Test
    public void testEditUnitOfMeasurement_Success() throws Exception {
        int id = 1;
        String newName = "NewUnitName";

        UnitOfMeasurementResponseDTO mockResponseDTO = new UnitOfMeasurementResponseDTO(newName);
        Mockito.when(unitOfMeasurementServices.editUnitOfMeasurement(id, newName)).thenReturn(mockResponseDTO);

        ResponseEntity responseEntity = unitOfMeasurementController.editunitofmeasurment(id, newName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }

    @Test
    public void testEditUnitOfMeasurement_ValidationException() throws Exception {
        int id = 1;
        String newName = "NewUnitName";

        Mockito.when(unitOfMeasurementServices.editUnitOfMeasurement(id, newName))
                .thenThrow(new ValidationException("400", "Validation error", "1"));

        ResponseEntity responseEntity = unitOfMeasurementController.editunitofmeasurment(id, newName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        // Add assertions to validate the response entity contents for ValidationException
    }

    @Test
    public void testEditUnitOfMeasurement_IoException() throws Exception {
        int id = 1;
        String newName = "NewUnitName";

        Mockito.when(unitOfMeasurementServices.editUnitOfMeasurement(id, newName))
                .thenThrow(new IoExceptionCustom("500", "IO Exception", "1"));

        ResponseEntity responseEntity = unitOfMeasurementController.editunitofmeasurment(id, newName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }
    @Test
    public void testDeleteUnitOfMeasurement_Success() throws Exception {
        int id = 1;

        UnitOfMeasurementResponseDTO mockResponseDTO = new UnitOfMeasurementResponseDTO("DeletedUnit");
        Mockito.when(unitOfMeasurementServices.DeleteUnitOfMeasurement(id)).thenReturn(mockResponseDTO);

        ResponseEntity responseEntity = unitOfMeasurementController.deleteUnitOfMeasurement(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }

    @Test
    public void testDeleteUnitOfMeasurement_ValidationException() throws Exception {
        int id = 1;

        Mockito.when(unitOfMeasurementServices.DeleteUnitOfMeasurement(id))
                .thenThrow(new ValidationException("400", "Validation error", "1"));

        ResponseEntity responseEntity = unitOfMeasurementController.deleteUnitOfMeasurement(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }

    @Test
    public void testDeleteUnitOfMeasurement_IoException() throws Exception {
        int id = 1;

        Mockito.when(unitOfMeasurementServices.DeleteUnitOfMeasurement(id))
                .thenThrow(new IoExceptionCustom("500", "IO Exception", "1"));

        ResponseEntity responseEntity = unitOfMeasurementController.deleteUnitOfMeasurement(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }
    @Test
    public void testAllUnits_Success() throws Exception {
        List<UnitOfMeasurementResponseDTO> mockUnitsList = new ArrayList<>();


        Mockito.when(unitOfMeasurementServices.allUnits()).thenReturn(mockUnitsList);

        ResponseEntity responseEntity = unitOfMeasurementController.allunits();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }




}









