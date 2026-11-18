package co.saucedemo.questions;

import co.saucedemo.userinterfaces.CheckoutOverviewPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/** What the order overview shows: products, item total, tax and total. */
public class OrderSummary {

    private OrderSummary() {
    }

    /** Names of the products listed in the summary. */
    public static Question<List<String>> productNames() {
        return actor -> CheckoutOverviewPage.ITEM_NAMES.resolveAllFor(actor).stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    /** Sum of the individual prices listed in the summary. */
    public static Question<BigDecimal> sumOfProductPrices() {
        return actor -> CheckoutOverviewPage.ITEM_PRICES.resolveAllFor(actor).stream()
                .map(element -> parseAmount(element.getText()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /** "Item total: $39.98" gives 39.98. */
    public static Question<BigDecimal> itemTotal() {
        return actor -> parseAmount(Text.of(CheckoutOverviewPage.SUBTOTAL).answeredBy(actor));
    }

    /** "Tax: $3.20" gives 3.20. */
    public static Question<BigDecimal> tax() {
        return actor -> parseAmount(Text.of(CheckoutOverviewPage.TAX).answeredBy(actor));
    }

    /** "Total: $43.18" gives 43.18. */
    public static Question<BigDecimal> total() {
        return actor -> parseAmount(Text.of(CheckoutOverviewPage.TOTAL).answeredBy(actor));
    }

    /** Keeps only the digits and the dot of a text such as "Total: $43.18". */
    private static BigDecimal parseAmount(String text) {
        return new BigDecimal(text.replaceAll("[^0-9.]", ""));
    }
}
