package co.saucedemo.questions;

import co.saucedemo.userinterfaces.CheckoutInformationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/** Text of the shipping form error; empty string when no error is visible. */
public class CheckoutErrorMessage implements Question<String> {

    public static CheckoutErrorMessage displayed() {
        return new CheckoutErrorMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        var errors = CheckoutInformationPage.ERROR_MESSAGE.resolveAllFor(actor);
        return errors.isEmpty() ? "" : errors.get(0).getText().trim();
    }
}
