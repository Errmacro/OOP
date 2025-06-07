package org.skypro.skyshop;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.SearchEngine;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

public class App {
    public static void main(String[] args) {
        ProductBasket pul = new ProductBasket();
        SimpleProduct book = null;
        try {
            book = new SimpleProduct("   ", 500);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }
        FixPriceProduct pencil = new FixPriceProduct("Ручка синяя", 85);
        SimpleProduct clue = null;
        try {
            clue = new SimpleProduct("Клей", -110);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }
        DiscountedProduct markerSet = new DiscountedProduct("Набор фломастеров", 320, 10);
        DiscountedProduct copyBook = null;
        try {
            copyBook = new DiscountedProduct("Тетрадь", 30, -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }
        Article livroFortress = new Article("Крепость", "Книга о поиске себя");
        Article livroBridge = new Article("Мост на Дрине", "Книга о вечности и людских судьбах");
        Article cola = new Article("Клей канцелярский", "Мощный клей - даже в воде не растворяется");
        Article superCola = new Article("Клей момент", "В два раза больше мощности");
//        pul.addToBasket(book);
//        pul.addToBasket(pencil);
//        pul.addToBasket(clue);
//        pul.addToBasket(markerSet);
//        pul.addToBasket(copyBook);
//        pul.showTotalBasket();
//        pul.showSpecialsQuantity();
//        pul.findProduct("Тетрадь");
//        pul.findProduct("Бумага цветная");
//        pul.cleanBasket();
//        pul.showTotalBasket();
//        pul.findProduct("Тетрадь");

        SearchEngine wishList = new SearchEngine();
        wishList.addToSearchable(book);
        wishList.addToSearchable(pencil);
        wishList.addToSearchable(clue);
        wishList.addToSearchable(markerSet);
        wishList.addToSearchable(copyBook);
        wishList.addToSearchable(livroFortress);
        wishList.addToSearchable(livroBridge);
        wishList.addToSearchable(cola);
        wishList.addToSearchable(superCola);


//        wishList.showSearchable();//Проверяю все ли добавлено в массив
        String keyword = "клей";
//        wishList.searchByKeyword(keyword);
        try {
            wishList.findBestMatch(keyword);
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        String term = "клей конторский";
        try {
            wishList.findBestMatch(term);
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }

}
