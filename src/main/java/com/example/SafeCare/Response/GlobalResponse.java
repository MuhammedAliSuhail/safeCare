package com.example.SafeCare.Response;


import lombok.Data;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;

@Data
@Component
public class GlobalResponse  {
    private Object response = new Object();
    private String responseIndicator;
    private String statusCode;
    private String responseMessage;
}
