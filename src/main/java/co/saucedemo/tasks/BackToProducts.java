package co.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.saucedemo.userinterfaces.ProductDetailPage.BACK_TO_PRODUCTS_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BackToProducts implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BACK_TO_PRODUCTS_BUTTON));
    }

    public static BackToProducts now() {
        return instrumented(BackToProducts.class);
    }
}