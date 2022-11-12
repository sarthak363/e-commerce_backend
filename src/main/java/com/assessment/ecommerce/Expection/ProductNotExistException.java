package com.assessment.ecommerce.Expection;

public class ProductNotExistException extends IllegalArgumentException{
    public ProductNotExistException(String s) {
        super(s);
    }
}
