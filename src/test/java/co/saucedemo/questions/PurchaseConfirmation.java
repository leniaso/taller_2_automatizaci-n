package co.saucedemo.questions;

import co.saucedemo.userinterfaces.CheckoutCompletePage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

/** Confirmation header shown after finishing the purchase. */
public class PurchaseConfirmation {

    private PurchaseConfirmation() {
    }

    public static Question<String> message() {
        return actor -> Text.of(CheckoutCompletePage.CONFIRMATION_HEADER).answeredBy(actor);
    }
}
