package com.brovko.domain;

import com.brovko.converters.IntArrayToStringConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "br_products")
public class Product implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue
    private long id;
    @Column(name = "br_product_name")
    private String productName;
    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Brand productBrand;
    @Column(name = "br_product_model")
    private String model;
    @Column(name = "br_product_cat_id")
    private int categoryId;
    @Column(name = "br_product_price")
    private BigDecimal price;
    @Column(name = "br_product_price_currency")
    private String priceCurrency;
    @Column(name = "br_product_avaible")
    private boolean avaibleInStock;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "br_joined_comments", joinColumns = @JoinColumn(name = "br_product_fk"), inverseJoinColumns = @JoinColumn(name = "br_comment_fk"))
    private List<Comment> commentList;
    @Column(name = "br_product_characteristics")
    @ElementCollection
    private Map<String, String> characteristics;
    @Column
    @Convert(converter = IntArrayToStringConverter.class)
    private List<Integer> productImageIds;

    public Product() {
    }

    public Product(String productName, Brand productBrand, String model, int categoryId, BigDecimal price, String priceCurrency, boolean avaibleInStock, List<Comment> commentList, Map<String, String> characteristics, List<Integer> productImageIds) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.model = model;
        this.categoryId = categoryId;
        this.price = price;
        this.priceCurrency = priceCurrency;
        this.avaibleInStock = avaibleInStock;
        this.commentList = commentList;
        this.characteristics = characteristics;
        this.productImageIds = productImageIds;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Brand getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(Brand productBrand) {
        this.productBrand = productBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public boolean isAvaibleInStock() {
        return avaibleInStock;
    }

    public void setAvaibleInStock(boolean avaibleInStock) {
        this.avaibleInStock = avaibleInStock;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Map<String, String> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Map<String, String> characteristics) {
        this.characteristics = characteristics;
    }

    public List<Integer> getProductImageIds() {
        return productImageIds;
    }

    public void setProductImageIds(List<Integer> productImageIds) {
        this.productImageIds = productImageIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (categoryId != product.categoryId) return false;
        if (avaibleInStock != product.avaibleInStock) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (productBrand != null ? !productBrand.equals(product.productBrand) : product.productBrand != null)
            return false;
        if (model != null ? !model.equals(product.model) : product.model != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (priceCurrency != null ? !priceCurrency.equals(product.priceCurrency) : product.priceCurrency != null)
            return false;
        if (commentList != null ? !commentList.equals(product.commentList) : product.commentList != null) return false;
        if (characteristics != null ? !characteristics.equals(product.characteristics) : product.characteristics != null)
            return false;
        return productImageIds != null ? productImageIds.equals(product.productImageIds) : product.productImageIds == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productBrand != null ? productBrand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + categoryId;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (priceCurrency != null ? priceCurrency.hashCode() : 0);
        result = 31 * result + (avaibleInStock ? 1 : 0);
        result = 31 * result + (commentList != null ? commentList.hashCode() : 0);
        result = 31 * result + (characteristics != null ? characteristics.hashCode() : 0);
        result = 31 * result + (productImageIds != null ? productImageIds.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productBrand=" + productBrand +
                ", model='" + model + '\'' +
                ", categoryId=" + categoryId +
                ", price=" + price +
                ", priceCurrency='" + priceCurrency + '\'' +
                ", avaibleInStock=" + avaibleInStock +
                ", commentList=" + commentList +
                ", characteristics=" + characteristics +
                ", productImageIds=" + productImageIds +
                '}';
    }
}
