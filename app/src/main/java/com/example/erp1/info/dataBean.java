package com.example.erp1.info;

import java.util.List;

public class dataBean {
    private List<loanBean> loan;
    private List<productBean> product;
    private List<developIsoBean> developIso;
    private List<workshopBean> workshop;
    private financialBean financial;
    private List<receivableBean> receivable;
    private List<transportBean> transport;
    private List<developMarketBean> developMarket;
    private List<productLineBean> productLine;
    private List<developProductBean> developProduct;
    private String ops;
    private List<materialBean> material;
    private companyBean company;

    public List<loanBean> getLoan() {
        return loan;
    }

    public void setLoan(List<loanBean> loan) {
        this.loan = loan;
    }

    public List<productBean> getProduct() {
        return product;
    }

    public void setProduct(List<productBean> product) {
        this.product = product;
    }

    public List<developIsoBean> getDevelopIso() {
        return developIso;
    }

    public void setDevelopIso(List<developIsoBean> developIso) {
        this.developIso = developIso;
    }

    public List<workshopBean> getWorkshop() {
        return workshop;
    }

    public void setWorkshop(List<workshopBean> workshop) {
        this.workshop = workshop;
    }

    public financialBean getFinancial() {
        return financial;
    }

    public void setFinancial(financialBean financial) {
        this.financial = financial;
    }

    public List<receivableBean> getReceivable() {
        return receivable;
    }

    public void setReceivable(List<receivableBean> receivable) {
        this.receivable = receivable;
    }

    public List<transportBean> getTransport() {
        return transport;
    }

    public void setTransport(List<transportBean> transport) {
        this.transport = transport;
    }

    public List<developMarketBean> getDevelopMarket() {
        return developMarket;
    }

    public void setDevelopMarket(List<developMarketBean> developMarket) {
        this.developMarket = developMarket;
    }

    public List<productLineBean> getProductLine() {
        return productLine;
    }

    public void setProductLine(List<productLineBean> productLine) {
        this.productLine = productLine;
    }

    public List<developProductBean> getDevelopProduct() {
        return developProduct;
    }

    public void setDevelopProduct(List<developProductBean> developProduct) {
        this.developProduct = developProduct;
    }

    public String getOps() {
        return ops;
    }

    public void setOps(String ops) {
        this.ops = ops;
    }

    public List<materialBean> getMaterial() {
        return material;
    }

    public void setMaterial(List<materialBean> material) {
        this.material = material;
    }

    public companyBean getCompany() {
        return company;
    }

    public void setCompany(companyBean company) {
        this.company = company;
    }
}