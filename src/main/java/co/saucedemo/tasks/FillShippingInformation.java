package co.saucedemo.tasks;

import co.saucedemo.interactions.FillField;
import co.saucedemo.models.ShippingInformation;
import co.saucedemo.userinterfaces.CheckoutInformationPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/** Fills the shipping form and presses Continue (lands on the overview when the data is valid). */
public class FillShippingInformation implements Task {

    private final ShippingInformation information;

    public FillShippingInformation(ShippingInformation information) {
        this.information = information;
    }

    public static FillShippingInformation with(ShippingInformation information) {
        return instrumented(FillShippingInformation.class, information);
    }

    @Override
    @Step("{0} fills the shipping information and continues")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                FillField.in(CheckoutInformationPage.FIRST_NAME).with(information.firstName()),
                FillField.in(CheckoutInformationPage.LAST_NAME).with(information.lastName()),
                FillField.in(CheckoutInformationPage.POSTAL_CODE).with(information.postalCode()),
                Click.on(CheckoutInformationPage.CONTINUE_BUTTON)
        );
    }
}
