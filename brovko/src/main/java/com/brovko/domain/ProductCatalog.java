package com.brovko.domain;

import java.io.Serializable;
import java.util.Set;

public class ProductCatalog  implements Serializable {

    Set<ProductGroup> productGroup;

    public Set<ProductGroup> getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(Set<ProductGroup> productGroup) {
        this.productGroup = productGroup;
    }

}
