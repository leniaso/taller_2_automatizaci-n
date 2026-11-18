package co.saucedemo.stepdefinitions;

import co.saucedemo.exceptions.CheckoutError;
import co.saucedemo.models.ShippingInformation;
import co.saucedemo.questions.CheckoutErrorMessage;
import co.saucedemo.tasks.CancelShippingInformation;
import co.saucedemo.tasks.FillShippingInformation;
import co.saucedemo.tasks.GoToCart;
import co.saucedemo.tasks.StartCheckout;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutStepDefinition {

    @Given("the user is on the shipping information form")
    public void theUserIsOnTheShippingInformationForm() {
        OnStage.theActorInTheSpotlight().wasAbleTo(GoToCart.now(), StartCheckout.now());
    }

    @When("the user fills the shipping information with {string}")
    public void theUserFillsTheShippingInformationWith(String caseName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FillShippingInformation.with(ShippingInformation.forCase(caseName)));
    }

    @When("the user cancels the shipping information form")
    public void theUserCancelsTheShippingInformationForm() {
        OnStage.theActorInTheSpotlight().attemptsTo(CancelShippingInformation.now());
    }

    @Then("the checkout error message {string} is displayed")
    public void theCheckoutErrorMessageIsDisplayed(String message) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(CheckoutErrorMessage.displayed(), equalTo(message))
                        .orComplainWith(CheckoutError.class, CheckoutError.WRONG_ERROR_MESSAGE));
    }
}
