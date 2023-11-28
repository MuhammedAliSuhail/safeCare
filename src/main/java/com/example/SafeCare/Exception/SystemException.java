package com.example.SafeCare.Exception;

import com.example.SafeCare.Response.ErrorResponse;
import lombok.Data;


@Data
public class SystemException extends RuntimeException{

    ErrorResponse errorResponse;

    public SystemException(String statusCode, String responseMessage, String responseIndicator) {
        super(responseMessage);
        errorResponse = ErrorResponse.builder()
                .responseMessage(responseMessage).statusCode(statusCode).responseIndicator(responseIndicator).build();
    }
}
