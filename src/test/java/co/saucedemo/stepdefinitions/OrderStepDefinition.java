package co.saucedemo.stepdefinitions;

import co.saucedemo.exceptions.OrderError;
import co.saucedemo.models.ShippingInformation;
import co.saucedemo.questions.OrderSummary;
import co.saucedemo.questions.PurchaseConfirmation;
import co.saucedemo.tasks.BackHome;
import co.saucedemo.tasks.CancelPurchase;
import co.saucedemo.tasks.FillShippingInformation;
import co.saucedemo.tasks.FinishPurchase;
import co.saucedemo.tasks.GoToCart;
import co.saucedemo.tasks.StartCheckout;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import java.math.BigDecimal;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

/**
 * Checkout step two (order overview) and the purchase confirmation.
 * Reuses login, catalog, cart and shipping steps from the other modules.
 */
public class OrderStepDefinition {

    @Given("the user is on the order overview")
    public void theUserIsOnTheOrderOverview() {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                GoToCart.now(),
                StartCheckout.now(),
                FillShippingInformation.with(ShippingInformation.valid()));
    }

    @When("the user finishes the purchase")
    public void theUserFinishesThePurchase() {
        OnStage.theActorInTheSpotlight().attemptsTo(FinishPurchase.now());
    }

    @When("the user cancels the purchase")
    public void theUserCancelsThePurchase() {
        OnStage.theActorInTheSpotlight().attemptsTo(CancelPurchase.now());
    }

    @When("the user goes back home")
    public void theUserGoesBackHome() {
        OnStage.theActorInTheSpotlight().attemptsTo(BackHome.now());
    }

    @When("the user completes the checkout with valid shipping data")
    public void theUserCompletesTheCheckoutWithValidShippingData() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToCart.now(),
                StartCheckout.now(),
                FillShippingInformation.with(ShippingInformation.valid()));
    }

    @Then("the order summary lists the following products")
    public void theOrderSummaryListsTheFollowingProducts(DataTable table) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(OrderSummary.productNames(), containsInAnyOrder(table.asList().toArray(new String[0])))
                        .orComplainWith(OrderError.class, OrderError.WRONG_SUMMARY_PRODUCTS));
    }

    @Then("the item total is the sum of the product prices")
    public void theItemTotalIsTheSumOfTheProductPrices() {
        Actor actor = OnStage.theActorInTheSpotlight();
        BigDecimal sum = actor.asksFor(OrderSummary.sumOfProductPrices());
        actor.should(seeThat(OrderSummary.itemTotal(), comparesEqualTo(sum))
                .orComplainWith(OrderError.class, OrderError.WRONG_SUBTOTAL));
    }

    @Then("the order total is the item total plus the tax")
    public void theOrderTotalIsTheItemTotalPlusTheTax() {
        Actor actor = OnStage.theActorInTheSpotlight();
        BigDecimal expected = actor.asksFor(OrderSummary.itemTotal()).add(actor.asksFor(OrderSummary.tax()));
        actor.should(seeThat(OrderSummary.total(), comparesEqualTo(expected))
                .orComplainWith(OrderError.class, OrderError.WRONG_TOTAL));
    }

    @Then("the purchase confirmation {string} is displayed")
    public void thePurchaseConfirmationIsDisplayed(String message) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(PurchaseConfirmation.message(), equalTo(message))
                        .orComplainWith(OrderError.class, OrderError.WRONG_CONFIRMATION));
    }
}
