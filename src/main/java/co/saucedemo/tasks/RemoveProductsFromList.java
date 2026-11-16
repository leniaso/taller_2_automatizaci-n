package co.saucedemo.tasks;

import co.saucedemo.interactions.RemoveProductFromList;
import co.saucedemo.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RemoveProductsFromList implements Task {

    private final List<Product> products;

    public RemoveProductsFromList(List<Product> products) {
        this.products = products;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (Product product : products) {
            actor.attemptsTo(RemoveProductFromList.of(product));
        }
    }

    public static RemoveProductsFromList of(List<Product> products) {
        return instrumented(RemoveProductsFromList.class, products);
    }
}