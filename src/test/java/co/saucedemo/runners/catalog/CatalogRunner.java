package co.saucedemo.runners.catalog;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/catalog",
        glue = "co.saucedemo.stepdefinitions",
        tags = "not @known_defect",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CatalogRunner {}