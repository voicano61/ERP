package com.example.erp1.purchase;

import com.example.erp1.info.materialBean;
import com.example.erp1.info.productBean;

import java.util.List;

public class dataBean {
    private List<productBean> product;
    private List<materialBean> material;

    public List<productBean> getProduct() {
        return product;
    }

    public void setProduct(List<productBean> product) {
        this.product = product;
    }

    public List<materialBean> getMaterial() {
        return material;
    }

    public void setMaterial(List<materialBean> material) {
        this.material = material;
    }
}
