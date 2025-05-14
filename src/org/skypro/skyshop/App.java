package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket pul = new ProductBasket();
        Product book=new Product("Книга", 2500);
        Product pencil = new Product("Ручка синяя", 85);
        Product clue = new Product("Клей", 110);
        Product markerSet = new Product("Набор фломастеров", 320);
        Product copyBook= new Product("Тетрадь", 30);
        Product beer = new Product("Пиво", 90);
        pul.addToBasket(book);
        pul.addToBasket(pencil);
        pul.addToBasket(clue);
        pul.addToBasket(markerSet);
        pul.addToBasket(copyBook);
        pul.showTotalBasket();
        pul.addToBasket(beer);
        pul.findProduct("Тетрадь");
        pul.findProduct("Бумага цветная");
        pul.cleanBasket();
        pul.showTotalBasket();
        pul.findProduct("Тетрадь");
    }
}
