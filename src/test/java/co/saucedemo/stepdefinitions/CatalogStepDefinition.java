package co.saucedemo.stepdefinitions;

import co.saucedemo.models.Product;
import co.saucedemo.models.SortOption;
import co.saucedemo.questions.CartBadge;
import co.saucedemo.questions.ProductCount;
import co.saucedemo.questions.ProductDetail;
import co.saucedemo.questions.ProductsSortedBy;
import co.saucedemo.tasks.AddProductFromDetails;
import co.saucedemo.tasks.AddProducts;
import co.saucedemo.tasks.BackToProducts;
import co.saucedemo.tasks.RemoveProductsFromList;
import co.saucedemo.tasks.SortProducts;
import co.saucedemo.tasks.ViewProductDetails;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import co.saucedemo.questions.DistinctProductImages;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CatalogStepDefinition {

    @Given("the user has added {string} to the cart")
    public void theUserHasAddedToTheCart(String productName) {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                AddProducts.toCart(List.of(Product.named(productName))));
    }

    @Given("the user has added the following products to the cart")
    public void theUserHasAddedTheFollowingProductsToTheCart(DataTable table) {
        OnStage.theActorInTheSpotlight().wasAbleTo(AddProducts.toCart(toProducts(table)));
    }

    @Given("the user is viewing the details of {string}")
    public void theUserIsViewingTheDetailsOf(String productName) {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                ViewProductDetails.of(Product.named(productName)));
    }

    @When("the user adds {string} to the cart")
    public void theUserAddsToTheCart(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProducts.toCart(List.of(Product.named(productName))));
    }

    @When("the user adds the following products to the cart")
    public void theUserAddsTheFollowingProductsToTheCart(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(AddProducts.toCart(toProducts(table)));
    }

    @When("the user removes {string} from the product list")
    public void theUserRemovesFromTheProductList(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RemoveProductsFromList.of(List.of(Product.named(productName))));
    }

    @When("the user sorts the products by {string}")
    public void theUserSortsTheProductsBy(String optionLabel) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SortProducts.by(SortOption.fromLabel(optionLabel)));
    }

    @When("the user opens the details of {string}")
    public void theUserOpensTheDetailsOf(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ViewProductDetails.of(Product.named(productName)));
    }

    @When("the user adds the product to the cart from its details page")
    public void theUserAddsTheProductToTheCartFromItsDetailsPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(AddProductFromDetails.now());
    }

    @When("the user goes back to the products")
    public void theUserGoesBackToTheProducts() {
        OnStage.theActorInTheSpotlight().attemptsTo(BackToProducts.now());
    }

    @Then("the cart badge shows {int}")
    public void theCartBadgeShows(int expected) {
        OnStage.theActorInTheSpotlight().should(seeThat(CartBadge.count(), equalTo(expected)));
    }

    @Then("the product list shows {int} products")
    public void theProductListShowsProducts(int expected) {
        OnStage.theActorInTheSpotlight().should(seeThat(ProductCount.listed(), equalTo(expected)));
    }

    @Then("the products are listed according to {string}")
    public void theProductsAreListedAccordingTo(String optionLabel) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ProductsSortedBy.option(SortOption.fromLabel(optionLabel)), is(true)));
    }

    @Then("the product details show {string} priced at {string}")
    public void theProductDetailsShowPricedAt(String name, String price) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ProductDetail.name(), equalTo(name)),
                seeThat(ProductDetail.price(), equalTo(price)));
    }

    @Then("the product list shows {int} different image(s)")
    public void theProductListShowsDifferentImages(int expected) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(DistinctProductImages.count(), equalTo(expected)));
    }
    
    private List<Product> toProducts(DataTable table) {
        return table.asList().stream().map(Product::named).toList();
    }
}