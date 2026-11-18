package co.saucedemo.tasks;

import co.saucedemo.userinterfaces.CheckoutOverviewPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/** Confirms the order from the overview page. */
public class FinishPurchase implements Task {

    public static FinishPurchase now() {
        return instrumented(FinishPurchase.class);
    }

    @Override
    @Step("{0} finishes the purchase")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CheckoutOverviewPage.FINISH_BUTTON));
    }
}
