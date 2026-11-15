package co.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.saucedemo.userinterfaces.InventoryPage.TITLE;

public class PageTitle implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return TITLE.resolveFor(actor).getText();
    }

    public static PageTitle displayed() {
        return new PageTitle();
    }
}