package co.saucedemo.exceptions;

/** Verification failure in the order overview and the purchase confirmation. */
public class OrderError extends AssertionError {

    public static final String WRONG_SUMMARY_PRODUCTS = "The products in the order summary are not the expected ones";
    public static final String WRONG_SUBTOTAL = "The item total does not match the sum of the product prices";
    public static final String WRONG_TOTAL = "The order total is not the item total plus the tax";
    public static final String WRONG_CONFIRMATION = "The purchase confirmation message is not the expected one";

    public OrderError(String message, Throwable cause) {
        super(message, cause);
    }
}
