package com.example.erp1.report;

public class profitBean {
    private int sales;
    private int directCost;
    private int comprehensiveCost;
    private int depreciationCost;
    private int financialCost;
    private int tax;
    private int grossProfit;
    private int profitBeforeTax;
    private int profitBeforeDepreciation;
    private int profitBeforeInterest;

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getDirectCost() {
        return directCost;
    }

    public void setDirectCost(int directCost) {
        this.directCost = directCost;
    }

    public int getComprehensiveCost() {
        return comprehensiveCost;
    }

    public void setComprehensiveCost(int comprehensiveCost) {
        this.comprehensiveCost = comprehensiveCost;
    }

    public int getDepreciationCost() {
        return depreciationCost;
    }

    public void setDepreciationCost(int depreciationCost) {
        this.depreciationCost = depreciationCost;
    }

    public int getFinancialCost() {
        return financialCost;
    }

    public void setFinancialCost(int financialCost) {
        this.financialCost = financialCost;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(int grossProfit) {
        this.grossProfit = grossProfit;
    }

    public int getProfitBeforeTax() {
        return profitBeforeTax;
    }

    public void setProfitBeforeTax(int profitBeforeTax) {
        this.profitBeforeTax = profitBeforeTax;
    }

    public int getProfitBeforeDepreciation() {
        return profitBeforeDepreciation;
    }

    public void setProfitBeforeDepreciation(int profitBeforeDepreciation) {
        this.profitBeforeDepreciation = profitBeforeDepreciation;
    }

    public int getProfitBeforeInterest() {
        return profitBeforeInterest;
    }

    public void setProfitBeforeInterest(int profitBeforeInterest) {
        this.profitBeforeInterest = profitBeforeInterest;
    }
}
