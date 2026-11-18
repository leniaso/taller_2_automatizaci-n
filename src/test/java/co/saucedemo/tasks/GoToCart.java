package co.saucedemo.tasks;

import co.saucedemo.userinterfaces.CartPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoToCart implements Task {

    public static GoToCart now() {
        return instrumented(GoToCart.class);
    }

    @Override
    @Step("{0} goes to the shopping cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CartPage.CART_ICON));
    }
}
