package com.example.erp1.info;

public class developIsoBean {
    private int id;
    private int userId;
    private int matchId;
    private int isoId;
    private int startTime;
    private int finishTime;
    private int developingRemainder;
    private String createTime;
    private int createUserId;
    private developIsoBean developIso;

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

    public int getIsoId() {
        return isoId;
    }

    public void setIsoId(int isoId) {
        this.isoId = isoId;
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

    public int getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    public developIsoBean getDevelopIso() {
        return developIso;
    }

    public void setDevelopIso(developIsoBean developIso) {
        this.developIso = developIso;
    }
}
