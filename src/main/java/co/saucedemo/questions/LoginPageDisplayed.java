package co.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.saucedemo.userinterfaces.LoginPage.LOGIN_BUTTON;

public class LoginPageDisplayed implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return LOGIN_BUTTON.resolveFor(actor).isVisible();
    }

    public static LoginPageDisplayed value() {
        return new LoginPageDisplayed();
    }
}