package com.example.erp1.info;


import com.example.erp1.info.product.configProductBean;
import com.example.erp1.info.productLine.configProductLineBean;

public class productLineBean {
    private int id;
    private int productId;
    private int productLineId;
    private int userId;
    private int matchId;
    private int workshopId;
    private int depreciationExprense;
    private int finishTime;
    private int investmentAmount;
    private int startTime;
    private int intoProductionTime;
    private int productLineRemainder;
    private int turnOverTime;
    private String createTime;
    private configProductLineBean configProductLine;
    private configProductBean configProduct;
    private int status;
    private String statusString;

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

    public int getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(int productLineId) {
        this.productLineId = productLineId;
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

    public int getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(int workshopId) {
        this.workshopId = workshopId;
    }

    public int getDepreciationExprense() {
        return depreciationExprense;
    }

    public void setDepreciationExprense(int depreciationExprense) {
        this.depreciationExprense = depreciationExprense;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public int getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(int investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getIntoProductionTime() {
        return intoProductionTime;
    }

    public void setIntoProductionTime(int intoProductionTime) {
        this.intoProductionTime = intoProductionTime;
    }

    public int getProductLineRemainder() {
        return productLineRemainder;
    }

    public void setProductLineRemainder(int productLineRemainder) {
        this.productLineRemainder = productLineRemainder;
    }

    public int getTurnOverTime() {
        return turnOverTime;
    }

    public void setTurnOverTime(int turnOverTime) {
        this.turnOverTime = turnOverTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public configProductLineBean getConfigProductLine() {
        return configProductLine;
    }

    public void setConfigProductLine(configProductLineBean configProductLine) {
        this.configProductLine = configProductLine;
    }

    public configProductBean getConfigProduct() {
        return configProduct;
    }

    public void setConfigProduct(configProductBean configProduct) {
        this.configProduct = configProduct;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusString() {
        return statusString;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }
}
