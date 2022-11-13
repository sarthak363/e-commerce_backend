package com.assessment.ecommerce.dto;

import java.util.List;

public class CartDto {
    private List<CartItemDto> cartItemDtos;
    private double totalProductCost;
    private double totalWeight;
    private int totalShippingCharge;

    private double discounted;
    private double totalPrice;
    public CartDto(List<CartItemDto> cartItemDtos, double totalCost,double totalWeight,int totalShippingCharge,double discounted,double totalPrice) {
        this.cartItemDtos = cartItemDtos;
        this.totalProductCost = totalCost;
        this.totalWeight = totalWeight;
        this.totalShippingCharge=totalShippingCharge;
        this.discounted=discounted;
        this.totalPrice=totalPrice;

    }

    public double getDiscounted() {
        return discounted;
    }

    public void setDiscounted(double discounted) {
        this.discounted = discounted;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalShippingCharge() {
        return totalShippingCharge;
    }

    public void setTotalShippingCharge(int totalShippingCharge) {
        this.totalShippingCharge = totalShippingCharge;
    }

    public List<CartItemDto> getCartItemDtos() {
        return cartItemDtos;
    }

    public void setCartItemDtos(List<CartItemDto> cartItemDtos) {
        this.cartItemDtos = cartItemDtos;
    }

    public double getTotalProductCost() {
        return totalProductCost;
    }

    public void setTotalProductCost(double totalProductCost) {
        this.totalProductCost = totalProductCost;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }
}
