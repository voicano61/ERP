package com.example.erp1.info;

public class developMarketBean {
    private int id;
    private int userid;
    private int matchId;
    private int startTime;
    private int finishTime;

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

    public developMarketBean getDevelopMarket() {
        return developMarket;
    }

    public void setDevelopMarket(developMarketBean developMarket) {
        this.developMarket = developMarket;
    }

    private int developingRemainder;
    private String createTime;
    private developMarketBean developMarket;

}
