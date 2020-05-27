package com.example.erp1.order;

public class usersBean {
    private int productId;
    private int userId;
    private int matchId;
    private int ad;
    private int totalAd;
    private int sale;
    private int totalSale;
    private long adTime;
    private int chances;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public int getAd() {
        return ad;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public int getTotalAd() {
        return totalAd;
    }

    public void setTotalAd(int totalAd) {
        this.totalAd = totalAd;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(int totalSale) {
        this.totalSale = totalSale;
    }

    public void setAdTime(long adTime) {
        this.adTime = adTime;
    }

    public long getAdTime() {
        return adTime;
    }

    public int getChances() {
        return chances;
    }

    public void setChances(int chances) {
        this.chances = chances;
    }

}
