package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        ProductBasket pul = new ProductBasket(5);
        pul.addToBasket("Книга", 2500);
        pul.addToBasket("Ручка синяя", 85);
        pul.showTotalBasket();
    }
}
