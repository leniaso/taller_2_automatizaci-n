package co.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.saucedemo.userinterfaces.ProductDetailPage.ADD_TO_CART_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProductFromDetails implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ADD_TO_CART_BUTTON));
    }

    public static AddProductFromDetails now() {
        return instrumented(AddProductFromDetails.class);
    }
}