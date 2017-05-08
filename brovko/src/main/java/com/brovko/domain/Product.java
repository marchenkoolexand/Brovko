package com.brovko.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

public class Product {

    private long id;
    private String name;
    private BigDecimal price;
    private boolean isAvailableInStock;
    private List<Comment> commentList;
}
