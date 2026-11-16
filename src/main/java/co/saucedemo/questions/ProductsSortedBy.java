package co.saucedemo.questions;

import co.saucedemo.models.SortOption;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static co.saucedemo.userinterfaces.InventoryPage.PRODUCT_NAMES;
import static co.saucedemo.userinterfaces.InventoryPage.PRODUCT_PRICES;

public class ProductsSortedBy implements Question<Boolean> {

    private final SortOption option;

    public ProductsSortedBy(SortOption option) {
        this.option = option;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return switch (option) {
            case NAME_A_TO_Z -> isSorted(names(actor), Comparator.<String>naturalOrder());
            case NAME_Z_TO_A -> isSorted(names(actor), Comparator.<String>reverseOrder());
            case PRICE_LOW_TO_HIGH -> isSorted(prices(actor), Comparator.<Double>naturalOrder());
            case PRICE_HIGH_TO_LOW -> isSorted(prices(actor), Comparator.<Double>reverseOrder());
        };
    }

    private List<String> names(Actor actor) {
        return PRODUCT_NAMES.resolveAllFor(actor).stream()
                .map(WebElementFacade::getText)
                .toList();
    }

    private List<Double> prices(Actor actor) {
        return PRODUCT_PRICES.resolveAllFor(actor).stream()
                .map(element -> Double.parseDouble(element.getText().replace("$", "").trim()))
                .toList();
    }

    private static <T> boolean isSorted(List<T> actual, Comparator<T> comparator) {
        List<T> expected = new ArrayList<>(actual);
        expected.sort(comparator);
        return !actual.isEmpty() && expected.equals(actual);
    }

    public static ProductsSortedBy option(SortOption option) {
        return new ProductsSortedBy(option);
    }
}