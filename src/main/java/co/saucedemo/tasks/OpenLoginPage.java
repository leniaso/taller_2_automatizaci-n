package co.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenLoginPage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().thePageNamed("pages.swaglabsUrl"));
    }

    public static OpenLoginPage now() {
        return instrumented(OpenLoginPage.class);
    }
}