package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.Searchable;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products;


    public ProductBasket() {
        products = new HashMap<>();
    }

    public int countPrice() {
        return products.values().stream()
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .mapToInt(Product::getProductPrice)
                .sum();
    }

    private int countSpecial() {
        return (int) products.values().stream()
                .flatMap(List::stream)
                .filter(product -> product != null && product.isSpecial())
                .count();
    }

    public void showBasketContent() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        }else{
            products.values().stream()
                    .flatMap(List::stream)
                    .filter(Objects::nonNull)
                    .forEach(System.out::println);
            System.out.println("Общая стоимость корзины: " + countPrice() + " р.");
        }
    }

    public boolean findProduct(String productName) {
        boolean found = products.values().stream()
                .flatMap(List::stream)
                .anyMatch(product -> product != null && product.getProductName().equalsIgnoreCase(productName));
        if (found) {
            System.out.println("Товар " + productName + " найден!");
        } else {
            System.out.println("Такого товара нет");
        }
        return found;
    }

    public void showSpecialsQuantity() {
        System.out.println("Количество специальных товаров - " + countSpecial() + " позиций");
    }


    public void cleanBasket() {
        products.clear();
        System.out.println("Корзина пуста");
    }

    public void addToBasket(String name, Product product) {
        if (product != null) {
            List<Product> productList = products.getOrDefault(name, new ArrayList<>());//Разъяснить про computeIfAbsent;
            productList.add(product);
            products.put(name, productList);
            System.out.println("Товар " + product.getProductName() + " успешно добавлен в корзину " + name);
        } else {
            System.out.println("Попытка добавить несуществующий продукт в корзину!");
        }
    }

    public Map<String, List<Product>> removeFromBasket(String productToRemove) {
        Map<String, List<Product>> removedProducts = new HashMap<>();
        for (Map.Entry<String, List<Product>> entry : new ArrayList<>(products.entrySet())) {
            String category = entry.getKey();
            List<Product> items = entry.getValue();
            List<Product> removedFromCategory = new ArrayList<>();
            Iterator<Product> iterator = items.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getProductName().contains(productToRemove)) {
                    removedFromCategory.add(product);
                    iterator.remove();
                }
            }
            if (removedFromCategory.isEmpty()) {
                removedProducts.put(category, removedFromCategory);
            }
            if (items.isEmpty()) {
                products.remove(category);
            }

        }
        return removedProducts;
    }
}


