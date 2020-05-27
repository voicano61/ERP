package com.example.erp1.order;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class datasBean {
    @SerializedName("1")
    private market1Bean market1;
    @SerializedName("2")
    private market2Bean market2;
    @SerializedName("3")
    private market3Bean market3;
    @SerializedName("4")
    private market4Bean market4;
    @SerializedName("5")
    private market5Bean market5;

    public market1Bean getMarket1() {
        return market1;
    }

    public void setMarket1(market1Bean market1) {
        this.market1 = market1;
    }

    public market2Bean getMarket2() {
        return market2;
    }

    public void setMarket2(market2Bean market2) {
        this.market2 = market2;
    }

    public market3Bean getMarket3() {
        return market3;
    }

    public void setMarket3(market3Bean market3) {
        this.market3 = market3;
    }

    public market4Bean getMarket4() {
        return market4;
    }

    public void setMarket4(market4Bean market4) {
        this.market4 = market4;
    }

    public market5Bean getMarket5() {
        return market5;
    }

    public void setMarket5(market5Bean market5) {
        this.market5 = market5;
    }
}
