package co.saucedemo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.saucedemo.userinterfaces.SideMenu.LOGOUT_LINK;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SelectLogout implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOGOUT_LINK, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(LOGOUT_LINK)
        );
    }

    public static SelectLogout now() {
        return instrumented(SelectLogout.class);
    }
}