package co.saucedemo.runners.checkout;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

// Shared folder: Person 3 (step 1) and Person 4 (step 2) put their features here. One runner only.
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/checkout",
        glue = "co.saucedemo.stepdefinitions",
        tags = "not @known_defect",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CheckoutRunner {}
