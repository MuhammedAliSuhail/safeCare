package com.example.SafeCare.Exception;

public class IoExceptionCustom extends SystemException{
    public IoExceptionCustom(String statusCode, String responseMessage, String responseIndicator) {
        super(statusCode, responseMessage, responseIndicator);
    }
}
