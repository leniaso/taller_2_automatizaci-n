package co.saucedemo.tasks;

import co.saucedemo.interactions.OpenSideMenu;
import co.saucedemo.interactions.SelectLogout;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Logout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OpenSideMenu.now(),
                SelectLogout.now()
        );
    }

    public static Logout now() {
        return instrumented(Logout.class);
    }
}