package co.saucedemo.interactions;

import co.saucedemo.models.SortOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static co.saucedemo.userinterfaces.InventoryPage.SORT_DROPDOWN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectSortOption implements Interaction {

    private final SortOption option;

    public SelectSortOption(SortOption option) {
        this.option = option;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SelectFromOptions.byVisibleText(option.label()).from(SORT_DROPDOWN));
    }

    public static SelectSortOption of(SortOption option) {
        return instrumented(SelectSortOption.class, option);
    }
}
