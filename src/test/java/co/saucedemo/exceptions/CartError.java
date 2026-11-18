package co.saucedemo.exceptions;

/** Verification failure about the cart contents. */
public class CartError extends AssertionError {

    public static final String WRONG_PRODUCTS = "The products in the cart are not the expected ones";
    public static final String CART_NOT_EMPTY = "The cart was expected to be empty but it has products";
    public static final String WRONG_TOTAL = "The total number of items in the cart is not the expected one";
    public static final String WRONG_DETAIL = "The price or quantity of the product in the cart is not the expected one";
    public static final String WRONG_BADGE = "The cart badge does not match the items in the cart";
    public static final String WRONG_PAGE = "The user is not on the expected page";

    public CartError(String message, Throwable cause) {
        super(message, cause);
    }
}
