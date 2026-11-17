package co.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.saucedemo.userinterfaces.InventoryPage.PRODUCT_IMAGES;

public class DistinctProductImages implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return (int) PRODUCT_IMAGES.resolveAllFor(actor).stream()
                .map(image -> image.getAttribute("src"))
                .distinct()
                .count();
    }

    public static DistinctProductImages count() {
        return new DistinctProductImages();
    }
}