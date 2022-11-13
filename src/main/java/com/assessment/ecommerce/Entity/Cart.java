package com.assessment.ecommerce.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cart_Id;
    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "prodId")
    private Product product;
    private Integer quantity;

    @JsonIgnore
    @ManyToOne(targetEntity = Customer.class,fetch = FetchType.LAZY,optional = false)
    @JoinColumn(nullable = false,name = "customerId")
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Customer customer;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Cart(){};

    public Cart(Product product,Integer quantity, Customer customer) {
        this.product = product;
        this.customer = customer;
        this.quantity=quantity;
    }

    public Integer getCart_Id() {
        return cart_Id;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}