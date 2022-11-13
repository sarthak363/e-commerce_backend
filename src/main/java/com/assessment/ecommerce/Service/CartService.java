package com.assessment.ecommerce.Service;

import com.assessment.ecommerce.Entity.Cart;
import com.assessment.ecommerce.Entity.Customer;
import com.assessment.ecommerce.Entity.Product;
import com.assessment.ecommerce.Repository.CartRepo;
import com.assessment.ecommerce.dto.AddToKart;
import com.assessment.ecommerce.dto.CartDto;
import com.assessment.ecommerce.dto.CartItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartService {
    @Autowired
    private CartRepo cartRepo;

    public CartService(){}

    public CartService(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    public void addToCart(AddToKart addToKart, Product product, Customer customer){
        Cart cart=new Cart(product,addToKart.getQuantity(),customer);
        cartRepo.save(cart);
    }

    public CartDto listCartItems(Customer customer){
        List<Cart> cartList=cartRepo.findAllByCustomer(customer);
        List<CartItemDto> cartItems = new ArrayList<>();

        for(Cart cart : cartList){
            CartItemDto cartItemDto = getDtoFromCart(cart);
            cartItems.add(cartItemDto);
        }
        int totalShippingCharge=0;
        Double totalWeight=0.0;
        Double totalCost=0.0;
        for(CartItemDto cartItemDto : cartItems ){
            totalCost += (cartItemDto.getProduct().getPrice()*cartItemDto.getQuantity());
            totalWeight +=(cartItemDto.getProduct().getWeight()*cartItemDto.getQuantity());
            Double distance= Math.sqrt(Math.abs((cartItemDto.getProduct().getPin()-customer.getPin())));
            totalShippingCharge+=calculate_shipping_cost(cartItemDto.getProduct().getWeight()*cartItemDto.getQuantity(),distance);        }
        //System.out.println(totalShippingCharge);
        return new CartDto(cartItems,totalCost,totalWeight,totalShippingCharge);
    }

    public static CartItemDto getDtoFromCart(Cart cart){
        return new CartItemDto(cart);
    }

    public static int calculate_shipping_cost(Double weight,Double distance)
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
