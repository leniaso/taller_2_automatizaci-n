package co.saucedemo.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/** Reloads the current page of the browser (F5). */
public class ReloadPage implements Interaction {

    public static ReloadPage now() {
        return instrumented(ReloadPage.class);
    }

    @Override
    @Step("{0} reloads the page")
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().navigate().refresh();
    }
}
