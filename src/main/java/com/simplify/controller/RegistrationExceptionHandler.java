package com.simplify.controller;

import com.simplify.dto.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RegistrationExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseEntityExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ErrorDto invalidData(final IllegalArgumentException ex) {

        ErrorDto errorDto;
        errorDto = new ErrorDto(ex.getMessage(),"ILLEGAL_ARGUMENT");
        return errorDto;
    }


}
