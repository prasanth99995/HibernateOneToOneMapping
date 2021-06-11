package com.HibernateMapping.controller;


import com.HibernateMapping.exceptions.CustomErrorHandler;
import com.HibernateMapping.exceptions.LaptopNotFoundException;
import com.HibernateMapping.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LaptopNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorHandler handleLaptopNotFoundException(LaptopNotFoundException ex) {
        CustomErrorHandler errorHandler = new CustomErrorHandler(new Date(), "The Laptop with given Id does not exist", ex.getMessage());
        return errorHandler;
    }

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorHandler handleStudentNotFoundException(StudentNotFoundException ex) {
        CustomErrorHandler errorHandler = new CustomErrorHandler(new Date(), "The Laptop with given Id does not exist", ex.getMessage());
        return errorHandler;
    }
}
