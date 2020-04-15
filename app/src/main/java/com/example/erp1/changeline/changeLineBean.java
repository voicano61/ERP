package com.example.erp1.changeline;

import com.example.erp1.info.productLineBean;

import java.util.List;

public class changeLineBean {
    private int resultCode;
    private List<productLineBean> data;
    private String resultMessage;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public List<productLineBean> getData() {
        return data;
    }

    public void setData(List<productLineBean> data) {
        this.data = data;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
