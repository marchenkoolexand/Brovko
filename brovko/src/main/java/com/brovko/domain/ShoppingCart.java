package com.brovko.domain;

import java.io.Serializable;
import java.util.List;

public class ShoppingCart implements Serializable {

    List<OrderLine> orderLineList;

    public ShoppingCart() {
    }

    public ShoppingCart(List<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }

    public List<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "orderLineList=" + orderLineList +
                '}';
    }
}
