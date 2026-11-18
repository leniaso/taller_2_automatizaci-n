package co.saucedemo.tasks;

import co.saucedemo.userinterfaces.CheckoutCompletePage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/** Returns to the products page from the purchase confirmation. */
public class BackHome implements Task {

    public static BackHome now() {
        return instrumented(BackHome.class);
    }

    @Override
    @Step("{0} goes back home after the purchase")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CheckoutCompletePage.BACK_HOME_BUTTON));
    }
}
