package com.assessment.ecommerce.Controller;

import com.assessment.ecommerce.Entity.Product;
import com.assessment.ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public String addProduct(@RequestBody Product product){
        return (productService.addProduct(product)).toString();
    }
    @GetMapping("/all")
    public List<Product> listAllProduct(){
        return (productService.listProduct());
    }

    @GetMapping("/{pId}")
    public String getProductById(@PathVariable Integer pId){
        return (productService.getProductById(pId)).toString();
    }

    @PutMapping("/update/{pId}")
    public String updateProductById(@PathVariable Integer pId,@RequestBody Product product){
        return (productService.updateById(pId,product)).toString();
    }



}
