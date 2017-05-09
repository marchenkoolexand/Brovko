package com.brovko.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

public class Order implements Serializable {

    private Long id;
    private String name;
    private LocalDateTime orderDateAndTime;
    private User user;
    private Set<OrderLine> orderLineSet;
    private OrderStatus orderStatus;

    public Order() {
    }

    public Order(String name, User user, Set<OrderLine> orderLineSet, OrderStatus orderStatus) {
        this.name = name;
        this.user = user;
        this.orderLineSet = orderLineSet;
        this.orderStatus = orderStatus;
    }
}
