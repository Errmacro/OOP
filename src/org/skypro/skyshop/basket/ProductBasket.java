package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.Searchable;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> products;


    public ProductBasket() {
        products = new ArrayList<>();
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

    public int countSpecial() {
        int count = 0;
        for (Product product : products) {
            if (product != null && product.isSpecial()) {
                count++;
            }
        }
        return count;
    }

    public void showTotalBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            for (Product product : products) {
                if (product != null) {
                    System.out.println(product);
                }

            }
            System.out.println("Общая стоимость корзины: " + countTotalPrice() + " р.");
        }
    }

    public boolean findProduct(String productName) {
        for (Product product : products) {
            if (product != null && product.getProductName().equalsIgnoreCase(productName)) {
                System.out.println("Товар " + product.getProductName() + " найден!");
                return true;
            }
        }
        System.out.println("Такого товара нет");
        return false;
    }

    public void showSpecialsQuantity() {
        System.out.println("Количество специальных товаров - " + countSpecial() + " позиций");
    }


    public void cleanBasket() {
        products.clear();
        System.out.println("Корзина пуста");
    }

    public void addToBasket(Product product) {
        if (product != null) {
            products.add(product);
            System.out.println("Товар " + product.getProductName() + " успешно добавлен в корзину");
        } else {
            System.out.println("Попытка добавить несуществующий продукт в корзину!");
        }
    }

    public List<Product> removeFromBasket(String productToRemove) {
        Iterator<Product> iterator = products.iterator();
        List<Product> removedProduct = new ArrayList<>();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductName().contains(productToRemove)) {
                removedProduct.add(product);
                iterator.remove();
            }
        }
        return removedProduct;
    }

    public void printRemoved(List<Product> removed){
        if (removed.isEmpty()){
            System.out.println("Список удаленных продуктов пуст");
        }else {
            System.out.println("Список удаленных продуктов: ");
            for (Product product : removed) {
                System.out.println(product.getProductName());
            }
        }
    }


}


