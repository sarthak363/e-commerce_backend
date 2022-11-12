package com.assessment.ecommerce.Expection;

public class CustomerNotExistException extends IllegalArgumentException{
    public CustomerNotExistException(String s) {
        super(s);
    }
}
