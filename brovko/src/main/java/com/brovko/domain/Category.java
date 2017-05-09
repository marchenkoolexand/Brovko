package com.brovko.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "br_category")
public class Category implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue
    private long id;
    @Column(name = "br_cat_title")
    private String title;
    @Column(name = "br_cat_img_id")
    private int categoryImgId;

    public Category(String title) {
        this.title = title;
    }

    public Category(String title, int categoryImgId) {
        this.title = title;
        this.categoryImgId = categoryImgId;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategoryImgId() {
        return categoryImgId;
    }

    public void setCategoryImgId(int categoryImgId) {
        this.categoryImgId = categoryImgId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (categoryImgId != category.categoryImgId) return false;
        return title != null ? title.equals(category.title) : category.title == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + categoryImgId;
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", categoryImgId=" + categoryImgId +
                '}';
    }
}
