package co.saucedemo.tasks;

import co.saucedemo.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.saucedemo.userinterfaces.InventoryPage.PRODUCT_LINK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ViewProductDetails implements Task {

    private final Product product;

    public ViewProductDetails(Product product) {
        this.product = product;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(PRODUCT_LINK.of(product.name())));
    }

    public static ViewProductDetails of(Product product) {
        return instrumented(ViewProductDetails.class, product);
    }
}