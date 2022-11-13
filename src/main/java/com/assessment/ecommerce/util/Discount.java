package com.assessment.ecommerce.util;

public class Discount {
    public static double calculateDiscount(double price)
    {
        if (price>100&&price<300)
            return price-price*0.1;
        else if (price>300&&price<500)
            return price-price*0.2;
        else if (price>500&&price<700)
            return price-price*0.3;
        else if (price>700&&price<1000)
            return price-price*0.4;
        else if (price>1000&&price<1200)
            return price-price*0.5;
        else
            return price-price*0.6;
    }
}
