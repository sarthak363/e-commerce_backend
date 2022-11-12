package com.assessment.ecommerce.Service;

import com.assessment.ecommerce.Entity.Product;
import com.assessment.ecommerce.Expection.ProductNotExistException;
import com.assessment.ecommerce.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public List<Product> listProduct(){
        return productRepo.findAll();
    }

    public Product addProduct(Product product){
        return productRepo.save(product);
    }

    public Product getProductById(Integer pId){
        Optional<Product> optionalProduct=productRepo.findById(pId);
        if(!optionalProduct.isPresent()){
            throw new ProductNotExistException("Product id is invalid "+pId);
        }
        return optionalProduct.get();
    }

    public Product updateById(Integer pId,Product product){
        product.setProdId(pId);
        return productRepo.save(product);
    }




}
