package co.saucedemo.interactions;

import co.saucedemo.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.saucedemo.userinterfaces.InventoryPage.ADD_TO_CART_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProductToCart implements Interaction {

    private final Product product;

    public AddProductToCart(Product product) {
        this.product = product;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ADD_TO_CART_BUTTON.of(product.name())));
    }

    public static AddProductToCart of(Product product) {
        return instrumented(AddProductToCart.class, product);
    }
}