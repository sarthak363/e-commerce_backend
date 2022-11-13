package com.assessment.ecommerce.Controller;

import com.assessment.ecommerce.Comman.Message;
import com.assessment.ecommerce.Entity.Customer;
import com.assessment.ecommerce.Entity.Product;
import com.assessment.ecommerce.Service.CartService;
import com.assessment.ecommerce.Service.CustomerService;
import com.assessment.ecommerce.Service.ProductService;
import com.assessment.ecommerce.dto.AddToKart;
import com.assessment.ecommerce.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("{cId}/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<Message> addToCart(@PathVariable(name = "cId") Integer cId, @RequestBody AddToKart addToKart){
        Customer customer= customerService.getCustomerById(cId);
        Product product=productService.getProductById(addToKart.getProductId());
        cartService.addToCart(addToKart,product,customer);
        System.out.println("product to add " + product.getName());
        return new ResponseEntity<>(new Message(true,"Product added to cart"),HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<CartDto> getCartItem(@PathVariable(name = "cId") Integer cId){
        Customer customer=customerService.getCustomerById(cId);
        CartDto cartDto=cartService.listCartItems(customer);
        return new ResponseEntity<CartDto>(cartDto, HttpStatus.OK);
    }

    @PutMapping("/update/{cid}")
    public ResponseEntity<Message> updateCartItem(@PathVariable(name = "cid") Integer cid,@RequestBody AddToKart addToKart){
        cartService.updateCartItem(cid,addToKart);
        return new ResponseEntity<>(new Message(true,"Product updated"),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> deleteByProductId(@PathVariable(name = "id") Integer pId,@PathVariable(name = "cId") Integer cId){
        cartService.deleteCartItem(pId,cId);
        return new ResponseEntity<>(new Message(true,"Item Deleted"),HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Message> deleteAllCartItems(@PathVariable(name = "cId") Integer cId){
        Customer customer=customerService.getCustomerById(cId);
        cartService.deleteAllItems(customer);
        return new ResponseEntity<>(new Message(true,"All Items Deleted"),HttpStatus.OK);
    }



}
