package com.example.SafeCare.Exception;


import lombok.Data;
import org.springframework.stereotype.Component;


public class ValidationException extends SystemException{
    public ValidationException(String statusCode, String responseMessage, String responseIndicator) {
        super(statusCode, responseMessage, responseIndicator);
    }
}
