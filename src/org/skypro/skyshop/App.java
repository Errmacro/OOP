package org.skypro.skyshop;
import org.skypro.skyshop.product.SearchEngine;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

public class App {
    public static void main(String[] args) {
        ProductBasket pul = new ProductBasket();
        SimpleProduct book=new SimpleProduct("Книга", 500);
        FixPriceProduct pencil = new FixPriceProduct("Ручка синяя", 85);
        SimpleProduct clue = new SimpleProduct("Клей", 110);
        DiscountedProduct markerSet = new DiscountedProduct("Набор фломастеров", 320,10);
        DiscountedProduct copyBook= new DiscountedProduct("Тетрадь", 30,5);
        Article livroFortress = new Article("Крепость","Книга о поиске себя");
        Article livroBridge = new Article("Мост на Дрине","Книга о вечности и людских судьбах");
        Article cola = new Article("Клей канцелярский","Мощный клей - даже в воде не растворяется");
        Article superCola = new Article("Клей момент","В два раза больше мощности!");
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


        wishList.showSearchable();//Проверяю все ли добавлено в массив
        String keyword = "книга";
        wishList.searchByKeyword(keyword);
    }
}
