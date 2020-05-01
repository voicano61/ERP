package com.example.erp1.developingISO;

import com.example.erp1.info.developIsoBean;

import java.util.List;

public class developingIsoBean {
    private int resultCode;
    private List<developIsoBean> data;
    private String resultMessage;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public List<developIsoBean> getData() {
        return data;
    }

    public void setData(List<developIsoBean> data) {
        this.data = data;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
