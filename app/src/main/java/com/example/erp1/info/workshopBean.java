package com.example.erp1.info;

import com.example.erp1.info.workshop.configWorkshopBean;

public class workshopBean {
    private int id;
    private int workshopId;
    private int userid;
    private int matchId;
    private String buyingTime;
    private int payTime;
    private int workshopStatus;
    private int residualCapacity;
    private configWorkshopBean configWorkshop;
    private String workshopStatusDesc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(int workshopId) {
        this.workshopId = workshopId;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getBuyingTime() {
        return buyingTime;
    }

    public void setBuyingTime(String buyingTime) {
        this.buyingTime = buyingTime;
    }

    public int getPayTime() {
        return payTime;
    }

    public void setPayTime(int payTime) {
        this.payTime = payTime;
    }

    public int getWorkshopStatus() {
        return workshopStatus;
    }

    public void setWorkshopStatus(int workshopStatus) {
        this.workshopStatus = workshopStatus;
    }

    public int getResidualCapacity() {
        return residualCapacity;
    }

    public void setResidualCapacity(int residualCapacity) {
        this.residualCapacity = residualCapacity;
    }

    public configWorkshopBean getConfigWorkshop() {
        return configWorkshop;
    }

    public void setConfigWorkshop(configWorkshopBean configWorkshop) {
        this.configWorkshop = configWorkshop;
    }

    public String getWorkshopStatusDesc() {
        return workshopStatusDesc;
    }

    public void setWorkshopStatusDesc(String workshopStatusDesc) {
        this.workshopStatusDesc = workshopStatusDesc;
    }
}
