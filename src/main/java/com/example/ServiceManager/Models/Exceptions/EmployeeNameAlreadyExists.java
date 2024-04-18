package com.example.ServiceManager.Models.Exceptions;

import java.io.Serial;

public class EmployeeNameAlreadyExists extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public EmployeeNameAlreadyExists(String msg){
        super(msg);
    }
}

