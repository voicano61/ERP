package com.example.erp1.info;

import com.example.erp1.info.product.configProductBean;

public class developProductBean {
    private int id;
    private int userId;
    private int matchId;
    private int productId;
    private int startTime;
    private int finishTime;
    private int developingRemainder;
    private String createTime;
    private configProductBean configProduct;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public int getDevelopingRemainder() {
        return developingRemainder;
    }

    public void setDevelopingRemainder(int developingRemainder) {
        this.developingRemainder = developingRemainder;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public configProductBean getConfigProduct() {
        return configProduct;
    }

    public void setConfigProduct(configProductBean configProduct) {
        this.configProduct = configProduct;
    }
}
