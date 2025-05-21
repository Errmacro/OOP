package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket pul = new ProductBasket();
        SimpleProduct book=new SimpleProduct("Книга", 500);
        FixPriceProduct pencil = new FixPriceProduct("Ручка синяя", 85);
        SimpleProduct clue = new SimpleProduct("Клей", 110);
        DiscountedProduct markerSet = new DiscountedProduct("Набор фломастеров", 320,10);
        SimpleProduct copyBook= new SimpleProduct("Тетрадь", 30);
        SimpleProduct beer = new SimpleProduct("Пиво", 90);
        pul.addToBasket(book);
        pul.addToBasket(pencil);
        pul.addToBasket(clue);
        pul.addToBasket(markerSet);
        pul.addToBasket(copyBook);
        pul.showTotalBasket();
        pul.showSpecialsQuantity();
//        pul.addToBasket(beer);
        pul.findProduct("Тетрадь");
        pul.findProduct("Бумага цветная");
        pul.cleanBasket();
        pul.showTotalBasket();
        pul.findProduct("Тетрадь");
    }
}
