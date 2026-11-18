package co.saucedemo.questions;

import co.saucedemo.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/** Displayed price (e.g. "$29.99") of a product inside the cart. */
public class ProductPriceInCart implements Question<String> {

    private final String productName;

    private ProductPriceInCart(String productName) {
        this.productName = productName;
    }

    public static ProductPriceInCart of(String productName) {
        return new ProductPriceInCart(productName);
    }

    @Override
    public String answeredBy(Actor actor) {
        return CartPage.PRODUCT_PRICE.of(productName).resolveFor(actor).getText().trim();
    }
}
