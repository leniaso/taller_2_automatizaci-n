package co.saucedemo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.saucedemo.userinterfaces.SideMenu.LOGOUT_LINK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectLogout implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LOGOUT_LINK));
    }

    public static SelectLogout now() {
        return instrumented(SelectLogout.class);
    }
}