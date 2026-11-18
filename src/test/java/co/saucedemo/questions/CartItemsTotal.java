package co.saucedemo.questions;

import co.saucedemo.userinterfaces.CartPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/** Sum of the quantities of all the rows in the cart (0 when empty). */
public class CartItemsTotal implements Question<Integer> {

    public static CartItemsTotal value() {
        return new CartItemsTotal();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return CartPage.QUANTITIES.resolveAllFor(actor).stream()
                .map(WebElementFacade::getText)
                .mapToInt(text -> Integer.parseInt(text.trim()))
                .sum();
    }
}
