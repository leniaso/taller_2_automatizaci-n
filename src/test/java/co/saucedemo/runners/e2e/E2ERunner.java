package co.saucedemo.runners.e2e;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/e2e",
        glue = "co.saucedemo.stepdefinitions",
        tags = "not @known_defect",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class E2ERunner {}
