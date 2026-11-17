package co.saucedemo.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

import static co.saucedemo.userinterfaces.InventoryPage.PRODUCT_BUTTON;
import static co.saucedemo.userinterfaces.InventoryPage.PRODUCT_PRICE;

public class ProductInList implements Question<String> {

    private final Target target;

    private ProductInList(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        List<WebElementFacade> elements = target.resolveAllFor(actor);
        return elements.isEmpty() ? "" : elements.get(0).getText();
    }

    public static ProductInList buttonOf(String productName) {
        return new ProductInList(PRODUCT_BUTTON.of(productName));
    }

    public static ProductInList priceOf(String productName) {
        return new ProductInList(PRODUCT_PRICE.of(productName));
    }
}