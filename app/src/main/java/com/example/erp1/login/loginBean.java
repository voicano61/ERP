package com.example.erp1.login;

public class loginBean {
    private int resultCode;
    private dataBean data;

    public dataBean getData() {
        return data;
    }

    public void setData(dataBean data) {
        this.data = data;
    }

    private String resultMessage;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
