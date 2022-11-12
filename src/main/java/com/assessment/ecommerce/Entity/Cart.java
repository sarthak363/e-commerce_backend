package com.assessment.ecommerce.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @OneToOne(targetEntity = Customer.class,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false,name = "customer_ID")
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