package com.indibu.indiBuserver.controller;

import com.indibu.indiBuserver.model.ErrorResponse;
import com.indibu.indiBuserver.model.IndibuException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity indibuExceptionHandler(IndibuException exception){
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()),exception.getHttpStatus());
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity defaultExceptionHandler(Exception exception){
        return new ResponseEntity<>(new ErrorResponse(exception.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity uniqueConstraintExceptionHandler(DataIntegrityViolationException exception){

        if(exception.getMessage().contains("PUBLIC.USER(EMAIL)")){
            return new ResponseEntity<>(new ErrorResponse("Bu emaile bağlı başka bir hesap bulunmaktadır."), HttpStatus.BAD_REQUEST);
        }

        if(exception.getMessage().contains("PUBLIC.USER(NICK_NAME)")){
            return new ResponseEntity<>(new ErrorResponse("Bu nickname kullanılmaktadır."), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity notNullConstraintExceptionHandler(ConstraintViolationException exception){

        if(exception.getMessage().contains("javax.validation.constraints.NotNull")){
            return new ResponseEntity<>(new ErrorResponse("Zorunlu alanlar boş bırakılmamalıdır."), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(new ErrorResponse(exception.getMessage()),HttpStatus.BAD_REQUEST);
    }

}
