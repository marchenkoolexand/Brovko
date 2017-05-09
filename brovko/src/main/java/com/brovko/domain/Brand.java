package com.brovko.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "br_brands")
public class Brand implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue
    private long id;
    @Column(name = "br_brand")
    private String brand;

    public Brand(String brand) {
        this.brand = brand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brand brand1 = (Brand) o;

        if (id != brand1.id) return false;
        return brand != null ? brand.equals(brand1.brand) : brand1.brand == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                '}';
    }
}
