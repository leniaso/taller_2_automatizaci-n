package co.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductDetailPage {

    public static final Target NAME =
            Target.the("product name").located(By.cssSelector("[data-test='inventory-item-name']"));

    public static final Target PRICE =
            Target.the("product price").located(By.cssSelector("[data-test='inventory-item-price']"));

    public static final Target ADD_TO_CART_BUTTON =
            Target.the("add to cart button").located(By.cssSelector("[data-test='add-to-cart']"));

    public static final Target BACK_TO_PRODUCTS_BUTTON =
            Target.the("back to products button").located(By.cssSelector("[data-test='back-to-products']"));

    private ProductDetailPage() {}
}