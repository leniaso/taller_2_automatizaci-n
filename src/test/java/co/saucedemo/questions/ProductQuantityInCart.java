package co.saucedemo.questions;

import co.saucedemo.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/** Displayed quantity of a product inside the cart. */
public class ProductQuantityInCart implements Question<String> {

    private final String productName;

    private ProductQuantityInCart(String productName) {
        this.productName = productName;
    }

    public static ProductQuantityInCart of(String productName) {
        return new ProductQuantityInCart(productName);
    }

    @Override
    public String answeredBy(Actor actor) {
        return CartPage.PRODUCT_QUANTITY.of(productName).resolveFor(actor).getText().trim();
    }
}
