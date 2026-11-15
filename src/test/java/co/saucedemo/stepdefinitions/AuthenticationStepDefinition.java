package co.saucedemo.stepdefinitions;

import co.saucedemo.models.User;
import co.saucedemo.questions.LoginErrorMessage;
import co.saucedemo.questions.LoginPageDisplayed;
import co.saucedemo.questions.PageTitle;
import co.saucedemo.tasks.Login;
import co.saucedemo.tasks.Logout;
import co.saucedemo.tasks.OpenLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AuthenticationStepDefinition {

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        OnStage.theActorInTheSpotlight().wasAbleTo(OpenLoginPage.now());
    }

    @Given("the user is logged in as {string}")
    public void theUserIsLoggedInAs(String username) {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                OpenLoginPage.now(),
                Login.withCredentials(User.withPublicPassword(username))
        );
    }

    @When("the user logs in as {string} with password {string}")
    public void theUserLogsInAs(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(Login.withCredentials(username, password));
    }

    @When("the user logs out")
    public void theUserLogsOut() {
        OnStage.theActorInTheSpotlight().attemptsTo(Logout.now());
    }

    @Then("the products page is displayed")
    public void theProductsPageIsDisplayed() {
        OnStage.theActorInTheSpotlight().should(seeThat(PageTitle.displayed(), equalTo("Products")));
    }

    @Then("the error message {string} is displayed")
    public void theErrorMessageIsDisplayed(String message) {
        OnStage.theActorInTheSpotlight().should(seeThat(LoginErrorMessage.displayed(), equalTo(message)));
    }

    @Then("the login page is displayed")
    public void theLoginPageIsDisplayed() {
        OnStage.theActorInTheSpotlight().should(seeThat(LoginPageDisplayed.value(), is(true)));
    }
}