package co.saucedemo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.saucedemo.userinterfaces.LoginPage.LOGIN_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PressLoginButton implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LOGIN_BUTTON));
    }

    public static PressLoginButton now() {
        return instrumented(PressLoginButton.class);
    }
}