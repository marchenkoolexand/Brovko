package com.brovko.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderLine implements Serializable {

    private Product product;
    private int amount;
    private BigDecimal purchasePrice;

    public OrderLine() {
    }

    public OrderLine(Product product, int amount, BigDecimal purchasePrice) {
        this.product = product;
        this.amount = amount;
        this.purchasePrice = purchasePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderLine orderLine = (OrderLine) o;

        if (amount != orderLine.amount) return false;
        if (product != null ? !product.equals(orderLine.product) : orderLine.product != null) return false;
        return purchasePrice != null ? purchasePrice.equals(orderLine.purchasePrice) : orderLine.purchasePrice == null;
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + amount;
        result = 31 * result + (purchasePrice != null ? purchasePrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "product=" + product +
                ", amount=" + amount +
                ", purchasePrice=" + purchasePrice +
                '}';
    }
}
