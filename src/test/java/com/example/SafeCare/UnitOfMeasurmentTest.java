package com.example.SafeCare;

import com.example.SafeCare.Controller.CategoryController;
import com.example.SafeCare.Controller.UnitOfMeasurmentController;
import com.example.SafeCare.Services.CategoryServices;
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
    private UnitOfMeasurmentController unitOfMeasurmentController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddUnit() throws Exception {
        // Mock the behavior of categoryServices.addCategory()
        when(unitOfMeasurementServices.addUnitOfMeasurment(anyString())).thenReturn("unit of Measurement is added");

        // Perform the test by invoking the controller method
        String result = unitOfMeasurmentController.addUnitOfmeasurment("mac");

        // Verify the result
        assertEquals("unit of Measurement is added", result);
        when(unitOfMeasurementServices.addUnitOfMeasurment(anyString())).thenReturn("unit is already exist");

        // Perform the test by invoking the controller method
        String result2 = unitOfMeasurmentController.addUnitOfmeasurment("mac");
        assertEquals("unit is already exist", result2);
    }

}
