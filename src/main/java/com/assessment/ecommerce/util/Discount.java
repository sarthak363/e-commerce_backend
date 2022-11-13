package com.assessment.ecommerce.util;

public class Discount {
    public static double calculateDiscount(double price)
    {
        if (price>100&&price<300)
            return price-price*0.1;
        else if (price>300&&price<500)
            return price-price*0.12;
        else if (price>500&&price<700)
            return price-price*0.13;
        else if (price>700&&price<1000)
            return price-price*0.14;
        else if (price>1000&&price<1200)
            return price-price*0.15;
        else
            return price-price*0.16;
    }
}
