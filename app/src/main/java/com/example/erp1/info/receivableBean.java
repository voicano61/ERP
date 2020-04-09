package com.example.erp1.info;

public class receivableBean {
    private int id;
    private int userid;
    private int matchId;
    private int receivableValue;
    private int receivableRemainder;
    private String createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getReceivableValue() {
        return receivableValue;
    }

    public void setReceivableValue(int receivableValue) {
        this.receivableValue = receivableValue;
    }

    public int getReceivableRemainder() {
        return receivableRemainder;
    }

    public void setReceivableRemainder(int receivableRemainder) {
        this.receivableRemainder = receivableRemainder;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
