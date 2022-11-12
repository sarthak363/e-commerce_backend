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
        Double totalWeight=0.0;
        Double totalCost=0.0;
        for(CartItemDto cartItemDto : cartItems ){
            totalCost += (cartItemDto.getProduct().getPrice()*cartItemDto.getQuantity());
            totalWeight +=(cartItemDto.getProduct().getWeight()*cartItemDto.getQuantity());
        }
        return new CartDto(cartItems,totalCost,totalWeight);
    }

    public static CartItemDto getDtoFromCart(Cart cart){
        return new CartItemDto(cart);
    }

}
