package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        ProductBasket pul = new ProductBasket();
        pul.addToBasket("Книга", 2500);
        pul.addToBasket("Ручка синяя", 85);
        pul.addToBasket("Клей", 110);
        pul.addToBasket("Набор фломастеров", 320);
        pul.addToBasket("Тетрадь", 30);
        pul.showTotalBasket();
        pul.addToBasket("Пиво", 90);
        pul.findProduct("Тетрадь");
        pul.findProduct("Бумага цветная");
        pul.cleanBasket();
        pul.showTotalBasket();
        pul.findProduct("Тетрадь");
    }
}
