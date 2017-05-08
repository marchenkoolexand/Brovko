package com.brovko.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Set;

public class Order {

    private Long id;
    private String name;
    private LocalDateTime localDateTime;
    private User user;
    private Set<OrderLine> orderLineSet;
}
