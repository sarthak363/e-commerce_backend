package com.assessment.ecommerce.Controller;

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
    public void addToCart(@PathVariable(name = "cId") Integer cId, @RequestBody AddToKart addToKart){
        Customer customer= customerService.getCustomerById(cId);
        Product product=productService.getProductById(addToKart.getProductId());
        cartService.addToCart(addToKart,product,customer);
        System.out.println("product to add " + product.getName());
    }
    @GetMapping
    public ResponseEntity<CartDto> getCartItem(@PathVariable(name = "cId") Integer cId){
        Customer customer=customerService.getCustomerById(cId);
        CartDto cartDto=cartService.listCartItems(customer);
        return new ResponseEntity<CartDto>(cartDto, HttpStatus.OK);
    }


}
