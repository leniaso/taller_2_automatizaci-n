package co.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import static co.saucedemo.userinterfaces.ProductDetailPage.NAME;
import static co.saucedemo.userinterfaces.ProductDetailPage.PRICE;

public class ProductDetail implements Question<String> {

    private final Target target;

    private ProductDetail(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        return target.resolveFor(actor).getText();
    }

    public static ProductDetail name() {
        return new ProductDetail(NAME);
    }

    public static ProductDetail price() {
        return new ProductDetail(PRICE);
    }
}
