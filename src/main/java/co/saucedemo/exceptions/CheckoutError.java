package co.saucedemo.exceptions;

/** Verification failure in the shipping information form. */
public class CheckoutError extends AssertionError {

    public static final String WRONG_ERROR_MESSAGE = "The error message of the shipping form is not the expected one";

    public CheckoutError(String message, Throwable cause) {
        super(message, cause);
    }
}
