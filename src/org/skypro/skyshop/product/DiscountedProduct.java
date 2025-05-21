package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int productPrice;
    private int discount;

    public DiscountedProduct(String productName, int productPrice, int discount) {
        super(productName, productPrice);
        this.discount=discount;
        this.productPrice=productPrice;
    }

    @Override
    public int getProductPrice() {
        return productPrice - (productPrice * discount / 100);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Продукт со скидкой - "+productName+", "+getProductPrice()+" р. (скидка "+discount+"%)";
    }
}
