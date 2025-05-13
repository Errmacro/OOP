package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int size;

    public ProductBasket(int products) {
        this.products = new Product[products];
    }

    public void addToBasket(String productName, int productPrice) {
        if (size >= products.length) {
            System.out.println("Невозможно добавить товар. Корзина переполнена");
        }
        Product newProduct = new Product(productName, productPrice);
        products[size++] = newProduct;
    }

    public int countTotalPrice() {
        int sum = 0;
        for (Product product : products) {
            if (product != null) {
                sum += product.getProductPrice();
            }
        }
        return sum;
    }

    public void showTotalBasket() {
        if (size == 0) {
            System.out.println("В корзине пусто");
        } else {
            for (Product product : products) {
                if (product != null) {
                    System.out.println(product.getProductName() + ": " + product.getProductPrice());
                }

            }
        }
    }
}
