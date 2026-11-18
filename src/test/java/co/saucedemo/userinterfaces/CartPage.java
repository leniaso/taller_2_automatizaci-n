package co.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

/** Locators of the cart page (/cart.html). */
public class CartPage {

    private CartPage() {
    }

    // Whole product row, located by its visible name ({0})
    private static final String ROW_BY_NAME =
            "//div[@data-test='inventory-item'][.//div[@data-test='inventory-item-name' and normalize-space()='{0}']]";

    public static final Target CART_ICON =
            Target.the("cart icon").locatedBy("[data-test='shopping-cart-link']");

    public static final Target PRODUCT_NAMES =
            Target.the("product names in the cart").locatedBy("[data-test='inventory-item-name']");

    public static final Target QUANTITIES =
            Target.the("product quantities in the cart").locatedBy("[data-test='item-quantity']");

    public static final Target PRODUCT_PRICE =
            Target.the("price of {0}").locatedBy(ROW_BY_NAME + "//div[@data-test='inventory-item-price']");

    public static final Target PRODUCT_QUANTITY =
            Target.the("quantity of {0}").locatedBy(ROW_BY_NAME + "//div[@data-test='item-quantity']");

    public static final Target REMOVE_BUTTON =
            Target.the("Remove button of {0}").locatedBy(ROW_BY_NAME + "//button[starts-with(@data-test,'remove')]");

    public static final Target CONTINUE_SHOPPING_BUTTON =
            Target.the("Continue Shopping button").locatedBy("[data-test='continue-shopping']");

    public static final Target CHECKOUT_BUTTON =
            Target.the("Checkout button").locatedBy("[data-test='checkout']");
}
