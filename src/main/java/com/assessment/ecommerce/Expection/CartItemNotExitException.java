package com.assessment.ecommerce.Expection;

public class CartItemNotExitException extends IllegalArgumentException{
    public CartItemNotExitException(String s){
        super(s);
    }
}
