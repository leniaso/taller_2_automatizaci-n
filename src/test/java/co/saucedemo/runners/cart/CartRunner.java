package co.saucedemo.runners.cart;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/cart",
        glue = "co.saucedemo.stepdefinitions",
        tags = "not @known_defect",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CartRunner {}
