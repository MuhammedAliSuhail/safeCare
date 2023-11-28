package com.example.SafeCare.Exception;


import com.example.SafeCare.Response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@ResponseBody
public class GlobalException extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = ValidationException.class)
    public ErrorResponse validationException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                             ValidationException validationException) {
        httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return validationException.getErrorResponse();
    }
    @ExceptionHandler(value = IoExceptionCustom.class)
    public ErrorResponse IoExceptionCustom(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                           ValidationException validationException) {
        httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return validationException.getErrorResponse();
    }
}
