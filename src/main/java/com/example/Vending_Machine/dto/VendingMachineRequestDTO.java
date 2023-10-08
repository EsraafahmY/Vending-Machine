package com.example.Vending_Machine.dto;

public class VendingMachineRequestDTO {
    private String productId;
    private String amountOfProduct;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getAmountOfProduct() {
        return amountOfProduct;
    }

    public void setAmountOfProduct(String amountOfProduct) {
        this.amountOfProduct = amountOfProduct;
    }
}
