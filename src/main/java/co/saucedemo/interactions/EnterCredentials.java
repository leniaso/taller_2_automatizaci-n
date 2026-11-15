package co.saucedemo.interactions;

import co.saucedemo.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;

import static co.saucedemo.userinterfaces.LoginPage.PASSWORD_FIELD;
import static co.saucedemo.userinterfaces.LoginPage.USERNAME_FIELD;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterCredentials implements Interaction {

    private final User user;

    public EnterCredentials(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.username()).into(USERNAME_FIELD),
                Enter.theValue(user.password()).into(PASSWORD_FIELD)
        );
    }

    public static EnterCredentials of(User user) {
        return instrumented(EnterCredentials.class, user);
    }
}