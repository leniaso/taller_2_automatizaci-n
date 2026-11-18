package co.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

/** Locators of the shipping information form (/checkout-step-one.html). */
public class CheckoutInformationPage {

    private CheckoutInformationPage() {
    }

    public static final Target FIRST_NAME =
            Target.the("First Name field").locatedBy("[data-test='firstName']");

    public static final Target LAST_NAME =
            Target.the("Last Name field").locatedBy("[data-test='lastName']");

    public static final Target POSTAL_CODE =
            Target.the("Zip/Postal Code field").locatedBy("[data-test='postalCode']");

    public static final Target CONTINUE_BUTTON =
            Target.the("Continue button").locatedBy("[data-test='continue']");

    public static final Target CANCEL_BUTTON =
            Target.the("Cancel button").locatedBy("[data-test='cancel']");

    public static final Target ERROR_MESSAGE =
            Target.the("form error message").locatedBy("[data-test='error']");
}
