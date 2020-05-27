package com.example.erp1.index;

public class indexBean {
    private int resultCode;
    private indexDataBean data;
    private String resultMessage;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public indexDataBean getData() {
        return data;
    }

    public void setData(indexDataBean data) {
        this.data = data;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
