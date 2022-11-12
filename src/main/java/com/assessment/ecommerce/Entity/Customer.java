package com.assessment.ecommerce.Entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customer_ID;

    private String Name;
    private String pin;

    public Customer(){}

    public Customer(String name, String pin) {
        Name = name;
        this.pin = pin;
    }

    public Integer getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(Integer customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}