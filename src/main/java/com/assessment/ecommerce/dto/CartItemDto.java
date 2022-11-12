package com.assessment.ecommerce.dto;

import com.assessment.ecommerce.Entity.Cart;
import com.assessment.ecommerce.Entity.Product;

public class CartItemDto {
    private Integer id;
    private Integer quantity;
    private Product product;

    public CartItemDto(){}

    public CartItemDto(Cart cart) {
        this.id = cart.getCart_Id();
        this.quantity = cart.getQuantity();
        this.product = cart.getProduct();
    }

    @Override
    public String toString() {
        return "CartItemDto{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
