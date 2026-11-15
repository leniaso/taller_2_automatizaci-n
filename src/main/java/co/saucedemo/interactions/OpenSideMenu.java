package co.saucedemo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.saucedemo.userinterfaces.SideMenu.MENU_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenSideMenu implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(MENU_BUTTON));
    }

    public static OpenSideMenu now() {
        return instrumented(OpenSideMenu.class);
    }
}