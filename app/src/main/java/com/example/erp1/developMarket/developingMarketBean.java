package com.example.erp1.developMarket;

import com.example.erp1.info.developMarketBean;

import java.util.List;

public class developingMarketBean {
    private int resultCode;
    private List<developMarketBean>  data;
    private String resultMessage;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public List<developMarketBean> getData() {
        return data;
    }

    public void setData(List<developMarketBean> data) {
        this.data = data;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
