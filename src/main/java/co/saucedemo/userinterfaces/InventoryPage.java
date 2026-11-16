package co.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventoryPage {

    public static final Target TITLE =
            Target.the("page title").located(By.cssSelector("[data-test='title']"));

    public static final Target ADD_TO_CART_BUTTON =
            Target.the("add to cart button of {0}").locatedBy(
                    "//div[@data-test='inventory-item']"
                    + "[.//div[@data-test='inventory-item-name'][normalize-space()='{0}']]"
                    + "//button[starts-with(@data-test,'add-to-cart')]");

    private InventoryPage() {}
}