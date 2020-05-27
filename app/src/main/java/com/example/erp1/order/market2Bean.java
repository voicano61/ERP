package com.example.erp1.order;

import java.util.List;

public class market2Bean {
    private int product;
    private List<ordersBean> orders;
    private int time;
    private int user;
    private List<usersBean> users;
    private int status;
    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public List<ordersBean> getOrders() {
        return orders;
    }

    public void setOrders(List<ordersBean> orders) {
        this.orders = orders;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public List<usersBean> getUsers() {
        return users;
    }

    public void setUsers(List<usersBean> users) {
        this.users = users;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
