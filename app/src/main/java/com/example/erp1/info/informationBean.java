package com.example.erp1.info;

public class informationBean {
    private int resultCode;
    private dataBean data;
    private String resultMessage;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public dataBean getData() {
        return data;
    }

    public void setData(dataBean data) {
        this.data = data;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
