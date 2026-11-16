package co.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.saucedemo.userinterfaces.InventoryPage.PRODUCT_NAMES;

public class ProductCount implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return PRODUCT_NAMES.resolveAllFor(actor).size();
    }

    public static ProductCount listed() {
        return new ProductCount();
    }
}