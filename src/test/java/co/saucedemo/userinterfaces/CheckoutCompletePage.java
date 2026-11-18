package co.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

/** Locators of the purchase confirmation (/checkout-complete.html). */
public class CheckoutCompletePage {

    private CheckoutCompletePage() {
    }

    public static final Target CONFIRMATION_HEADER =
            Target.the("confirmation header").locatedBy("[data-test='complete-header']");

    public static final Target CONFIRMATION_TEXT =
            Target.the("confirmation text").locatedBy("[data-test='complete-text']");

    public static final Target BACK_HOME_BUTTON =
            Target.the("Back Home button").locatedBy("[data-test='back-to-products']");
}
