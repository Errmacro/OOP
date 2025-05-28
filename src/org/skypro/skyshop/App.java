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
        Article livro = new Article("Крепость","Книга о поиске себя");
        Article cola = new Article("Клей канцелярский","Мощный клей - даже в воде не растворяется");
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
        wishList.addToSearchable(livro);
        wishList.addToSearchable(cola);

        String keyword = "Книга";
        String [] searchResult = wishList.searchByKeyword(keyword);
        for (String s : searchResult) {
            System.out.println(s);
        }
    }
}
