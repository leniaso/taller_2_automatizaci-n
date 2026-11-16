package co.saucedemo.tasks;

import co.saucedemo.interactions.SelectSortOption;
import co.saucedemo.models.SortOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SortProducts implements Task {

    private final SortOption option;

    public SortProducts(SortOption option) {
        this.option = option;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SelectSortOption.of(option));
    }

    public static SortProducts by(SortOption option) {
        return instrumented(SortProducts.class, option);
    }
}