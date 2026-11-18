package co.saucedemo.tasks;

import co.saucedemo.userinterfaces.CheckoutInformationPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CancelShippingInformation implements Task {

    public static CancelShippingInformation now() {
        return instrumented(CancelShippingInformation.class);
    }

    @Override
    @Step("{0} cancels the shipping information form")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CheckoutInformationPage.CANCEL_BUTTON));
    }
}
