package com.example.SafeCare;

import com.example.SafeCare.Controller.UnitOfMeasurementController;
import com.example.SafeCare.Exception.ValidationException;
import com.example.SafeCare.Response.GenerateGlobalResponse;
import com.example.SafeCare.Response.GlobalResponse;
import com.example.SafeCare.ResponseDTO.UnitOfMeasurementResponseDTO;
import com.example.SafeCare.Services.UnitOfMeasurementServices;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

//public class UnitOfMeasurmentTest {
//
//
//    @Mock
//    UnitOfMeasurementServices unitOfMeasurementServices;
//
//    @Mock
//    GenerateGlobalResponse generateGlobalResponse;
//
//    @InjectMocks
//    UnitOfMeasurementController unitOfMeasurementController;
//
//    @Test
//    void testAddUnitOfMeasurement_Success() throws Exception {

//
//
//            // Mocking a successful scenario
//            UnitOfMeasurementResponseDTO unitOfMeasurementResponseDTO = new UnitOfMeasurementResponseDTO("newUnit");
//            GlobalResponse globalResponse=new GlobalResponse();
//            globalResponse.setResponseMessage("newMessage");
//            globalResponse.setStatusCode("200");
//            globalResponse.setResponseIndicator("2");
//            globalResponse.setResponse(unitOfMeasurementResponseDTO);
//            when(unitOfMeasurementServices.addUnitOfMeasurement("newUnit")).thenReturn(unitOfMeasurementResponseDTO);
//            when(generateGlobalResponse.generateGlobalResponse(unitOfMeasurementResponseDTO, "2", "200", "Unit added successfully"))
////                    .thenReturn(ResponseEntity.ok().body("SuccessResponse"));
//                    .thenReturn();
//            ResponseEntity response = unitOfMeasurementController.addUnitOfmeasurment("ValidUnit");
//
//            assertEquals(HttpStatus.OK, response.getStatusCode());
//            assertEquals("SuccessResponse", response.getBody());
//        }
//    @Test
//    void testEditUnitOfMeasurement_ValidationException() throws Exception {
//        int id = 1;
//        String newName = "InvalidUnitName";
//
//        doThrow(new ValidationException("Validation error", "1", "400"))
//                .when(unitOfMeasurementServices).editUnitOfMeasurement(id, newName);
//        when(generateGlobalResponse.generateGlobalResponse(null, "1", "400", "Validation error"))
//                .thenReturn(ResponseEntity.badRequest().body("ValidationError"));
//
//        ResponseEntity response = unitOfMeasurementController.editunitofmeasurment(id, newName);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals("ValidationError", response.getBody());
//    }


//        @Test
//        void testAddUnitOfMeasurement_ValidationException () throws Exception {
//            // Mocking a ValidationException scenario
//            doThrow(new ValidationException("Validation error", "1", "400"))
//                    .when(unitOfMeasurementServices).addUnitOfMeasurement(anyString());
//            when(generateGlobalResponse.generateGlobalResponse(null, "1", "400", "Validation error"))
//                    .thenReturn(ResponseEntity.badRequest().body("ValidationError"));
//
//            ResponseEntity response = unitOfMeasurementController.addUnitOfmeasurment("InvalidUnit");
//
//            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//            assertEquals("ValidationError", response.getBody());
//        }
//
//    }









