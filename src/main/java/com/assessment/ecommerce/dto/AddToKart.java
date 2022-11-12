package com.assessment.ecommerce.dto;

public class AddToKart {
   // private Integer id;
    private Integer productId;
    private Integer quantity;

    public AddToKart(){};

    @Override
    public String toString() {
        return "AddToKart{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }

    //    @Override
//    public String toString() {
//        return "addToKart{" +
//                "id=" + id +
//                ", productId=" + productId +
//                ", quantity=" + quantity +
//                '}';
//    }

//    public Integer getId() {
//        return id;
//    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
