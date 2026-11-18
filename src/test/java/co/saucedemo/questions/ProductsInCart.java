package co.saucedemo.questions;

import co.saucedemo.userinterfaces.CartPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.stream.Collectors;

/** Names of the products in the cart, in the displayed order. */
public class ProductsInCart implements Question<List<String>> {

    public static ProductsInCart names() {
        return new ProductsInCart();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return CartPage.PRODUCT_NAMES.resolveAllFor(actor).stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }
}
