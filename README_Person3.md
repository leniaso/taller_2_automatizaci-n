# Persona 3 - Cart + Checkout step 1 (English, same conventions as the repo)

Copy `src/` over the project. Reused from teammates (nothing to create): `AddProducts`, `Product`, `CartBadge`,
`PageTitle`, login step "the user is logged in as {string}", catalog steps "the user has added ... to the cart".

| Guide task | Files |
|---|---|
| 3.1 Gherkin cart | features/cart/cart.feature |
| 3.2 UserInterface | CartPage, CheckoutInformationPage |
| 3.3 Tasks | GoToCart, RemoveProductFromCart, ContinueShopping, StartCheckout (+ CancelShippingInformation) |
| 3.4 Questions | ProductsInCart, CartIsEmpty, CartItemsTotal (+ ProductPriceInCart, ProductQuantityInCart) |
| 3.5 Checkout step 1 | features/checkout/shipping_information.feature, FillShippingInformation, ShippingInformation, CheckoutErrorMessage, FillField |
| 3.6 Exceptions | CartError, CheckoutError |
| Glue | CartStepDefinition, CheckoutStepDefinition, CartRunner, CheckoutRunner |

Run:
./gradlew clean test --tests "co.saucedemo.runners.cart.CartRunner"
./gradlew clean test --tests "co.saucedemo.runners.checkout.CheckoutRunner"

Verify on the real site: data-test locators, prices, error messages, and that CartBadge.count() returns 0 when there is no badge.
