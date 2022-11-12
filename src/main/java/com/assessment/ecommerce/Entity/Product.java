package com.assessment.ecommerce.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer prodId;
    @Column
    private String name;
    @Column
    private Double price;
    @Column
    private Double weight;
    @Column
    private String pin;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    private List<Cart> carts;


    public Product(){}

    public Product(String name, Double price, Double weight, String pin) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.pin = pin;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getProdId() {
        return prodId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
