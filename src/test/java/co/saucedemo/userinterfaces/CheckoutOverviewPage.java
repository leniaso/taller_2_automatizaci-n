package co.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

/** Locators of the order overview (/checkout-step-two.html). */
public class CheckoutOverviewPage {

    private CheckoutOverviewPage() {
    }

    public static final Target ITEM_NAMES =
            Target.the("product names in the summary").locatedBy("[data-test='inventory-item-name']");

    public static final Target ITEM_PRICES =
            Target.the("product prices in the summary").locatedBy("[data-test='inventory-item-price']");

    public static final Target SUBTOTAL =
            Target.the("item total label").locatedBy("[data-test='subtotal-label']");

    public static final Target TAX =
            Target.the("tax label").locatedBy("[data-test='tax-label']");

    public static final Target TOTAL =
            Target.the("total label").locatedBy("[data-test='total-label']");

    public static final Target FINISH_BUTTON =
            Target.the("Finish button").locatedBy("[data-test='finish']");

    public static final Target CANCEL_BUTTON =
            Target.the("Cancel button").locatedBy("[data-test='cancel']");
}
