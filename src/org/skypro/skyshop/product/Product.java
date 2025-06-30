package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product implements Searchable {
    protected final String productName;


    public Product(String productName, int productPrice) {
        this.productName = productName;
        if ((productName == null)||(productName.isBlank())) {
            throw new IllegalArgumentException("Некорректное имя продукта");
        }
    }

    public String getProductName() {
        return productName;
    }

    public abstract int getProductPrice();

    @Override
    public abstract String toString();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return productName;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productName);
    }
}
