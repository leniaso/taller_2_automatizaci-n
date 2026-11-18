package co.saucedemo.questions;

import co.saucedemo.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/** true when the cart has no product rows. */
public class CartIsEmpty implements Question<Boolean> {

    public static CartIsEmpty value() {
        return new CartIsEmpty();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CartPage.PRODUCT_NAMES.resolveAllFor(actor).isEmpty();
    }
}
