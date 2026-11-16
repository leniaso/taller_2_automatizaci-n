package co.saucedemo.interactions;

import co.saucedemo.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.saucedemo.userinterfaces.InventoryPage.REMOVE_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RemoveProductFromList implements Interaction {

    private final Product product;

    public RemoveProductFromList(Product product) {
        this.product = product;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(REMOVE_BUTTON.of(product.name())));
    }

    public static RemoveProductFromList of(Product product) {
        return instrumented(RemoveProductFromList.class, product);
    }
}