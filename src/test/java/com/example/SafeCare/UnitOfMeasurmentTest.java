package com.example.SafeCare;

import com.example.SafeCare.Controller.UnitOfMeasurementController;
import com.example.SafeCare.Services.UnitOfMeasurementServices;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class UnitOfMeasurmentTest {


    @Mock
    private UnitOfMeasurementServices unitOfMeasurementServices;

    @InjectMocks
    private UnitOfMeasurementController unitOfMeasurementController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUnitOfmeasurment_Success() throws Exception {
        // Mocking behavior of unitOfMeasurementServices.addUnitOfMeasurement
        String unitOfMeasurement = "TestUnit";
        when(unitOfMeasurementServices.addUnitOfMeasurement(unitOfMeasurement)).thenReturn("Unit added successfully");

        // Testing addUnitOfmeasurment method
        ResponseEntity<String> response = unitOfMeasurementController.addUnitOfmeasurment(unitOfMeasurement);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Unit added successfully", response.getBody());
    }

    @Test
    public void testAddUnitOfmeasurment_Exception() throws Exception {
        // Mocking behavior of unitOfMeasurementServices.addUnitOfMeasurement to throw an exception
        String unitOfMeasurement = "TestUnit";
        when(unitOfMeasurementServices.addUnitOfMeasurement(unitOfMeasurement)).thenThrow(new Exception("Failed to add unit"));

        // Testing addUnitOfmeasurment method for exception scenario
        ResponseEntity<String> response = unitOfMeasurementController.addUnitOfmeasurment(unitOfMeasurement);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Failed to add unit", response.getBody());
    }
    @Test
    public void testEditUnitOfMeasurement_Success()  throws Exception{
        // Mocking behavior of unitOfMeasurementServices.editUnitOfMeasurement
        int unitId = 1;
        String newName = "NewUnitName";
        when(unitOfMeasurementServices.editUnitOfMeasurement(unitId, newName)).thenReturn("Unit edited successfully");

        // Testing editunitofmeasurment method
        ResponseEntity<String> response = unitOfMeasurementController.editunitofmeasurment(unitId, newName);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Unit edited successfully", response.getBody());
    }

    @Test
    public void testEditUnitOfMeasurement_Exception() throws Exception{
        // Mocking behavior of unitOfMeasurementServices.editUnitOfMeasurement to throw an exception
        int unitId = 1;
        String newName = "NewUnitName";
        when(unitOfMeasurementServices.editUnitOfMeasurement(unitId, newName)).thenThrow(new Exception("Failed to edit unit"));

        // Testing editunitofmeasurment method for exception scenario
        ResponseEntity<String> response = unitOfMeasurementController.editunitofmeasurment(unitId, newName);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Failed to edit unit", response.getBody());
    }
    @Test
    public void testDeleteUnitOfMeasurement_Success() throws Exception{
        // Mocking behavior of unitOfMeasurementServices.DeleteUnitOfMeasurement
        int unitId = 1;
        when(unitOfMeasurementServices.DeleteUnitOfMeasurement(unitId)).thenReturn("Unit deleted successfully");

        // Testing deleteUnitOfMeasurement method
        ResponseEntity<String> response = unitOfMeasurementController.deleteUnitOfMeasurement(unitId);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Unit deleted successfully", response.getBody());
    }

    @Test
    public void testDeleteUnitOfMeasurement_Exception() throws Exception{
        // Mocking behavior of unitOfMeasurementServices.DeleteUnitOfMeasurement to throw an exception
        int unitId = 1;
        when(unitOfMeasurementServices.DeleteUnitOfMeasurement(unitId)).thenThrow(new Exception("Failed to delete unit"));

        // Testing deleteUnitOfMeasurement method for exception scenario
        ResponseEntity<String> response = unitOfMeasurementController.deleteUnitOfMeasurement(unitId);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Failed to delete unit", response.getBody());
    }
    @Test
    public void testAllUnits_Success() throws Exception {
        // Mocking behavior of unitOfMeasurementServices.allUnits
        List<String> units = new ArrayList<>();

        units.add("unit1");
        units.add("unit2");
        units.add("unit3");

        when(unitOfMeasurementServices.allUnits()).thenReturn(units);

        // Testing allunits method
        ResponseEntity<List<String>> response = unitOfMeasurementController.allunits();

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(units, response.getBody());
    }


}
