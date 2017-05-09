package com.brovko.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "br_product_group")
public class ProductGroup implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue
    private long id;
    @Column(name = "br_group_title")
    private String groupTitle;
    @Column(name = "br_group_img_id")
    private int groupImgId;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "s_joined_category", joinColumns = @JoinColumn(name = "s_product_group_fk"), inverseJoinColumns = @JoinColumn(name = "s_category_fk"))
    Set<Category> categorySet;

    public ProductGroup() {
    }

    public ProductGroup(String groupTitle, int groupImgId, Set<Category> categorySet) {
        this.groupTitle = groupTitle;
        this.groupImgId = groupImgId;
        this.categorySet = categorySet;
    }

    public long getId() {
        return id;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public int getGroupImgId() {
        return groupImgId;
    }

    public void setGroupImgId(int groupImgId) {
        this.groupImgId = groupImgId;
    }

    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductGroup that = (ProductGroup) o;

        if (id != that.id) return false;
        if (groupImgId != that.groupImgId) return false;
        if (groupTitle != null ? !groupTitle.equals(that.groupTitle) : that.groupTitle != null) return false;
        return categorySet != null ? categorySet.equals(that.categorySet) : that.categorySet == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (groupTitle != null ? groupTitle.hashCode() : 0);
        result = 31 * result + groupImgId;
        result = 31 * result + (categorySet != null ? categorySet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductGroup{" +
                "id=" + id +
                ", groupTitle='" + groupTitle + '\'' +
                ", groupImgId=" + groupImgId +
                ", categorySet=" + categorySet +
                '}';
    }
}
