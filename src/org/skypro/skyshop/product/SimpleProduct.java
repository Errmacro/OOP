package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
    private int productPrice;

    public SimpleProduct(String productName, int productPrice) {
        super(productName, productPrice);
        this.productPrice = productPrice;
    }

    @Override
    public int getProductPrice() {
        return productPrice;
    }

    @Override
    public String getProductName() {
        return super.getProductName();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return productName+", цена - "+productPrice;
    }
}
