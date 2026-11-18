package co.saucedemo.tasks;

import co.saucedemo.userinterfaces.CartPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/** Removes a product from the cart page, locating it by its name. */
public class RemoveProductFromCart implements Task {

    private final String productName;

    public RemoveProductFromCart(String productName) {
        this.productName = productName;
    }

    public static RemoveProductFromCart named(String productName) {
        return instrumented(RemoveProductFromCart.class, productName);
    }

    @Override
    @Step("{0} removes '#productName' from the cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CartPage.REMOVE_BUTTON.of(productName)));
    }
}
