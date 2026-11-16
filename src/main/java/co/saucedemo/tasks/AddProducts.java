package co.saucedemo.tasks;

import co.saucedemo.interactions.AddProductToCart;
import co.saucedemo.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProducts implements Task {

    private final List<Product> products;

    public AddProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (Product product : products) {
            actor.attemptsTo(AddProductToCart.of(product));
        }
    }

    public static AddProducts toCart(List<Product> products) {
        return instrumented(AddProducts.class, products);
    }
}