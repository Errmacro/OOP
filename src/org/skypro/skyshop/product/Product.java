package org.skypro.skyshop.product;

public abstract class Product {
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
}
