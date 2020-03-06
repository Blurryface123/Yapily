package com.Andres.Yapily.handler;

import com.Andres.Yapily.entity.SimpleErrorException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class StatusExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public String handleDataLoadException(SimpleErrorException exception){
        String response = exception.getStatus()+"; Hint: "+exception.getMessage();
        return response;
    }
}
