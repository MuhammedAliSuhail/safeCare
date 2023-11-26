package com.example.SafeCare;

import com.example.SafeCare.Controller.UnitOfMeasurementController;
import com.example.SafeCare.Services.UnitOfMeasurementServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddUnit() throws Exception {
        // Mock the behavior of categoryServices.addCategory()
        when(unitOfMeasurementServices.addUnitOfMeasurement(anyString())).thenReturn("unit of Measurement is added");

        // Perform the test by invoking the controller method
        String result = unitOfMeasurementController.addUnitOfmeasurment("mac");

        // Verify the result
        assertEquals("unit of Measurement is added", result);
        when(unitOfMeasurementServices.addUnitOfMeasurement(anyString())).thenReturn("unit is already exist");

        // Perform the test by invoking the controller method
        String result2 = unitOfMeasurementController.addUnitOfmeasurment("mac");
        assertEquals("unit is already exist", result2);
    }

}
