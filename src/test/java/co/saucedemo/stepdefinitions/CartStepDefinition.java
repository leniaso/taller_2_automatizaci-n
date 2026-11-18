package co.saucedemo.stepdefinitions;

import co.saucedemo.exceptions.CartError;
import co.saucedemo.interactions.ReloadPage;
import co.saucedemo.questions.CartBadge;
import co.saucedemo.questions.CartIsEmpty;
import co.saucedemo.questions.CartItemsTotal;
import co.saucedemo.questions.PageTitle;
import co.saucedemo.questions.ProductPriceInCart;
import co.saucedemo.questions.ProductQuantityInCart;
import co.saucedemo.questions.ProductsInCart;
import co.saucedemo.tasks.ContinueShopping;
import co.saucedemo.tasks.GoToCart;
import co.saucedemo.tasks.RemoveProductFromCart;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Cart steps. Adding products and the badge check ("the cart badge shows {int}")
 * are reused from CatalogStepDefinition.
 */
public class CartStepDefinition {

    @Given("the user is in the cart")
    public void theUserIsInTheCart() {
        OnStage.theActorInTheSpotlight().wasAbleTo(GoToCart.now());
    }

    @When("the user opens the cart")
    public void theUserOpensTheCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(GoToCart.now());
    }

    @When("the user removes {string} from the cart")
    public void theUserRemovesFromTheCart(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(RemoveProductFromCart.named(productName));
    }

    @When("the user continues shopping")
    public void theUserContinuesShopping() {
        OnStage.theActorInTheSpotlight().attemptsTo(ContinueShopping.now());
    }

    @When("the user reloads the page")
    public void theUserReloadsThePage() {
        OnStage.theActorInTheSpotlight().attemptsTo(ReloadPage.now());
    }

    @Then("the cart contains the following products")
    public void theCartContainsTheFollowingProducts(DataTable table) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ProductsInCart.names(), containsInAnyOrder(table.asList().toArray(new String[0])))
                        .orComplainWith(CartError.class, CartError.WRONG_PRODUCTS));
    }

    @Then("the cart shows {string} priced at {string} with quantity {string}")
    public void theCartShowsPricedAtWithQuantity(String productName, String price, String quantity) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ProductPriceInCart.of(productName), equalTo(price))
                        .orComplainWith(CartError.class, CartError.WRONG_DETAIL),
                seeThat(ProductQuantityInCart.of(productName), equalTo(quantity))
                        .orComplainWith(CartError.class, CartError.WRONG_DETAIL));
    }

    @Then("the cart is empty")
    public void theCartIsEmpty() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(CartIsEmpty.value(), is(true))
                        .orComplainWith(CartError.class, CartError.CART_NOT_EMPTY));
    }

    @Then("the cart item total is {int}")
    public void theCartItemTotalIs(int total) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(CartItemsTotal.value(), equalTo(total))
                        .orComplainWith(CartError.class, CartError.WRONG_TOTAL));
    }

    @Then("the cart badge matches the cart item total")
    public void theCartBadgeMatchesTheCartItemTotal() {
        int total = OnStage.theActorInTheSpotlight().asksFor(CartItemsTotal.value());
        OnStage.theActorInTheSpotlight().should(
                seeThat(CartBadge.count(), equalTo(total))
                        .orComplainWith(CartError.class, CartError.WRONG_BADGE));
    }

    @Then("the user is on the {string} page")
    public void theUserIsOnThePage(String title) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(PageTitle.displayed(), equalTo(title))
                        .orComplainWith(CartError.class, CartError.WRONG_PAGE));
    }
}
