package com.assessment.ecommerce.Service;

import com.assessment.ecommerce.Entity.Cart;
import com.assessment.ecommerce.Entity.Customer;
import com.assessment.ecommerce.Entity.Product;
import com.assessment.ecommerce.Expection.CartItemNotExitException;
import com.assessment.ecommerce.Repository.CartRepo;
import com.assessment.ecommerce.dto.AddToKart;
import com.assessment.ecommerce.dto.CartDto;
import com.assessment.ecommerce.dto.CartItemDto;
import com.assessment.ecommerce.util.Discount;
import com.assessment.ecommerce.util.ShippingCharges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Double totalProductCost=0.0;
        for(CartItemDto cartItemDto : cartItems ){
            totalProductCost += (cartItemDto.getProduct().getPrice()*cartItemDto.getQuantity());
            totalWeight +=(cartItemDto.getProduct().getWeight()*cartItemDto.getQuantity());
            Double distance= Math.sqrt(Math.abs((cartItemDto.getProduct().getPin()-customer.getPin())));
            totalShippingCharge+=ShippingCharges.calulatingShippingCharges(cartItemDto.getProduct().getWeight()*cartItemDto.getQuantity(),distance);}
        double totalPrice = Discount.calculateDiscount(totalProductCost)+totalShippingCharge;
        double discounted=(totalProductCost+totalShippingCharge)-totalPrice;
        return new CartDto(cartItems,totalProductCost,totalWeight,totalShippingCharge,discounted,totalPrice);
    }
    public Cart findByCartId(Integer cid){
        Optional<Cart> optionalCart=cartRepo.findById(cid);
        if(!optionalCart.isPresent())
            throw new CartItemNotExitException("Cart id is Invalid" + cid);
        return optionalCart.get();
    }

    public static CartItemDto getDtoFromCart(Cart cart){
        return new CartItemDto(cart);
    }

    public void updateCartItem(Integer cid,AddToKart addToKart){
             Cart cart = findByCartId(cid);
             cart.setQuantity(addToKart.getQuantity());
             cartRepo.save(cart);
    }


   public void deleteCartItem(int id,int cId) throws CartItemNotExitException {
        if(!cartRepo.existsById(id))
            throw new CartItemNotExitException("Cart id is invalid "+ id);
        cartRepo.deleteById(id);
   }

   public void deleteAllItems(Customer customer){
        cartRepo.deleteByCustomer(customer);
   }






}
