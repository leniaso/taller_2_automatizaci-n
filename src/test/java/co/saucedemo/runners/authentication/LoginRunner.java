package co.saucedemo.runners.authentication;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/authentication",
        glue = "co.saucedemo.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class LoginRunner {}