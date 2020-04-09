package com.example.erp1.info;

import com.example.erp1.info.product.configProductBean;

public class productBean {
    private int id;
    private int productId;
    private int matchId;
    private int userid;
    private int inventoryNum;
    private String createTime;
    private int createUserId;
    private configProductBean configProduct;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getInventoryNum() {
        return inventoryNum;
    }

    public void setInventoryNum(int inventoryNum) {
        this.inventoryNum = inventoryNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    public configProductBean getConfigProduct() {
        return configProduct;
    }

    public void setConfigProduct(configProductBean configProduct) {
        this.configProduct = configProduct;
    }
}
