package com.assessment.ecommerce.util;


public class ShippingCharges {
    public static int calulatingShippingCharges(Double weight,Double distance)
    {
        if(weight<2&&distance<5)
            return 12;
        else if(weight<2 && distance<20)
            return 15;
        else if(weight<2 && distance<25)
            return 20;
        else if(weight<2 && distance<500)
            return 50;
        else if(weight<2 && distance<800)
            return 100;
        else if(weight<2 && distance>800)
            return 220;
        else if(weight<5&&distance<5)
            return 14;
        else if(weight<5 && distance<20)
            return 18;
        else if(weight<5 && distance<25)
            return 24;
        else if(weight<5 && distance<500)
            return 55;
        else if(weight<5 && distance<800)
            return 110;
        else if(weight<5 && distance>800)
            return 250;
        else if(weight<20&&distance<5)
            return 16;
        else if(weight<20 && distance<20)
            return 25;
        else if(weight<20 && distance<25)
            return 30;
        else if(weight<20 && distance<500)
            return 80;
        else if(weight<20 && distance<800)
            return 130;
        else if(weight<20 && distance>800)
            return 270;
        if(weight>20&&distance<5)
            return 21;
        else if(weight>20 && distance<20)
            return 35;
        else if(weight>20 && distance<25)
            return 50;
        else if(weight>20 && distance<500)
            return 90;
        else if(weight>20 && distance<800)
            return 150;
        else return 300;
    }

}
