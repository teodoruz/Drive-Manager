package com.example.ServiceManager.Controllers.exceptions;

import com.example.ServiceManager.Models.Exceptions.EmployeeNameAlreadyExists;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EmployeeNameAlreadyExists.class)
    public ResponseEntity<StandardError> employeeNameAlreadyExists(EmployeeNameAlreadyExists e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        String error = "database error";
        StandardError standardError = new StandardError(Instant.now(), error, e.getMessage(), request.getRequestURI(), status.value());
        return ResponseEntity.status(status).body(standardError);
    }

}
