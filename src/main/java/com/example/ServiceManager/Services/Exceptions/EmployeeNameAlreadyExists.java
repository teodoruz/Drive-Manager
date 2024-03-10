package com.example.ServiceManager.Services.Exceptions;

public class EmployeeNameAlreadyExists extends RuntimeException{

    public EmployeeNameAlreadyExists(String msg){
        super(msg);
    }
}
