package co.saucedemo.tasks;

import co.saucedemo.userinterfaces.CartPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ContinueShopping implements Task {

    public static ContinueShopping now() {
        return instrumented(ContinueShopping.class);
    }

    @Override
    @Step("{0} chooses to continue shopping")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CartPage.CONTINUE_SHOPPING_BUTTON));
    }
}
