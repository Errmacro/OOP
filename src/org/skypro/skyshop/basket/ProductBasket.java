package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
import java.util.Arrays;

public class ProductBasket {
    private final Product[] products;
    private int size;

    public ProductBasket() {
        this.products = new Product[5];
        size=0;
    }

    public void addToBasket(String productName, int productPrice) {
        if (size<products.length){
            products[size]= new Product(productName,productPrice);
            size++;
        }
        if (size>=products.length){
            System.out.println("Невозможно добавить продукт");
        }
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
                    System.out.println(product.getProductName() + ": " + product.getProductPrice()+" р.");
                }

            }System.out.println("Итоговая сумма покупок: "+countTotalPrice()+" р.");
        }
    }

    public boolean findProduct(String productName){
        for (Product product : products) {
            if((product!=null)&&(productName.equals(product.getProductName()))){
                System.out.println("У вас уже есть такой товар");
                return true;
            }
        }System.out.println("Такого товара нет");
        return false;
    }


    public void cleanBasket(){
        Arrays.fill(products, null);
        System.out.println("Корзина пуста");
    }
}
