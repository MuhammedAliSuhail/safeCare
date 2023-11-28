package com.example.SafeCare.Response;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {
    private Object response = new Object();
    private String responseIndicator;
    private String statusCode;
    private String responseMessage;
}
