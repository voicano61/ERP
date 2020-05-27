package com.example.erp1.order;

import java.util.HashMap;

public class dataBean {
//    HashMap<String,market1Bean> date=new HashMap<>(  );
    private datasBean dataBean;
    private String tip;
    private int status;

//    public HashMap<String, market1Bean> getDate() {
//        return date;
//    }
//
//    public void setDate(HashMap<String, market1Bean> date) {
//        this.date = date;
//    }

    public datasBean getDataBean() {
        return dataBean;
    }

    public void setDataBean(datasBean dataBean) {
        this.dataBean = dataBean;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
