package com.example.erp1.developProduct;

public class productBean {
    private int productId;
    private String name;
    private int developingTime;
    private int developingCost;
    private int developingRemainder;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDevelopingTime() {
        return developingTime;
    }

    public void setDevelopingTime(int developingTime) {
        this.developingTime = developingTime;
    }

    public int getDevelopingCost() {
        return developingCost;
    }

    public void setDevelopingCost(int developingCost) {
        this.developingCost = developingCost;
    }

    public int getDevelopingRemainder() {
        return developingRemainder;
    }

    public void setDevelopingRemainder(int developingRemainder) {
        this.developingRemainder = developingRemainder;
    }
}
