package org.skypro.skyshop.product;

public abstract class Product implements Searchable {
    protected final String productName;


    public Product(String productName, int productPrice) {
        this.productName = productName;

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
}
