package co.saucedemo.tasks;

import co.saucedemo.userinterfaces.CartPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class StartCheckout implements Task {

    public static StartCheckout now() {
        return instrumented(StartCheckout.class);
    }

    @Override
    @Step("{0} starts the checkout from the cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CartPage.CHECKOUT_BUTTON));
    }
}
