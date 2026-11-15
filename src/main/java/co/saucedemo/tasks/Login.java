package co.saucedemo.tasks;

import co.saucedemo.interactions.EnterCredentials;
import co.saucedemo.interactions.PressLoginButton;
import co.saucedemo.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private final User user;

    public Login(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterCredentials.of(user),
                PressLoginButton.now()
        );
    }

    public static Login withCredentials(User user) {
        return instrumented(Login.class, user);
    }

    public static Login withCredentials(String username, String password) {
        return withCredentials(User.with(username, password));
    }
}