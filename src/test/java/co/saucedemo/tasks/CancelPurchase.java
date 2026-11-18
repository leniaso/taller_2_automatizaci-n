package co.saucedemo.tasks;

import co.saucedemo.userinterfaces.CheckoutOverviewPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/** Cancels the order from the overview page (SauceDemo returns to the products list). */
public class CancelPurchase implements Task {

    public static CancelPurchase now() {
        return instrumented(CancelPurchase.class);
    }

    @Override
    @Step("{0} cancels the purchase")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CheckoutOverviewPage.CANCEL_BUTTON));
    }
}
