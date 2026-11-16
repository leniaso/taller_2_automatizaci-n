package co.saucedemo.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static co.saucedemo.userinterfaces.CartHeader.CART_BADGE;

public class CartBadge implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        List<WebElementFacade> badge = CART_BADGE.resolveAllFor(actor);
        return badge.isEmpty() ? 0 : Integer.parseInt(badge.get(0).getText().trim());
    }

    public static CartBadge count() {
        return new CartBadge();
    }
}