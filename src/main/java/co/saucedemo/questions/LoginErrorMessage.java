package co.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.saucedemo.userinterfaces.LoginPage.ERROR_MESSAGE;

public class LoginErrorMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return ERROR_MESSAGE.resolveFor(actor).getText();
    }

    public static LoginErrorMessage displayed() {
        return new LoginErrorMessage();
    }
}