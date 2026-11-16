package co.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartHeader {

    public static final Target CART_LINK =
            Target.the("shopping cart link").located(By.cssSelector("[data-test='shopping-cart-link']"));

    public static final Target CART_BADGE =
            Target.the("shopping cart badge").located(By.cssSelector("[data-test='shopping-cart-badge']"));

    private CartHeader() {}
}