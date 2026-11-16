package co.saucedemo.stepdefinitions;

import co.saucedemo.models.Product;
import co.saucedemo.questions.CartBadge;
import co.saucedemo.tasks.AddProducts;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CatalogStepDefinition {

    @When("the user adds {string} to the cart")
    public void theUserAddsToTheCart(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProducts.toCart(List.of(Product.named(productName))));
    }

    @When("the user adds the following products to the cart")
    public void theUserAddsTheFollowingProductsToTheCart(DataTable table) {
        List<Product> products = table.asList().stream().map(Product::named).toList();
        OnStage.theActorInTheSpotlight().attemptsTo(AddProducts.toCart(products));
    }

    @Then("the cart badge shows {int}")
    public void theCartBadgeShows(int expected) {
        OnStage.theActorInTheSpotlight().should(seeThat(CartBadge.count(), equalTo(expected)));
    }
}