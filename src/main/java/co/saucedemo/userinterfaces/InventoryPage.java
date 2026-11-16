package co.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventoryPage {

    public static final Target TITLE =
            Target.the("page title").located(By.cssSelector("[data-test='title']"));

    public static final Target PRODUCT_NAMES =
            Target.the("product names").located(By.cssSelector("[data-test='inventory-item-name']"));

    public static final Target PRODUCT_PRICES =
            Target.the("product prices").located(By.cssSelector("[data-test='inventory-item-price']"));

    public static final Target SORT_DROPDOWN =
            Target.the("sort dropdown").located(By.cssSelector("[data-test='product-sort-container']"));

    public static final Target ADD_TO_CART_BUTTON =
            Target.the("add to cart button of {0}").locatedBy(
                    "//div[@data-test='inventory-item']"
                    + "[.//div[@data-test='inventory-item-name'][normalize-space()='{0}']]"
                    + "//button[starts-with(@data-test,'add-to-cart')]");

    public static final Target REMOVE_BUTTON =
            Target.the("remove button of {0}").locatedBy(
                    "//div[@data-test='inventory-item']"
                    + "[.//div[@data-test='inventory-item-name'][normalize-space()='{0}']]"
                    + "//button[starts-with(@data-test,'remove')]");
                    
    public static final Target PRODUCT_LINK =
            Target.the("link of {0}").locatedBy(
                    "//a[.//div[@data-test='inventory-item-name'][normalize-space()='{0}']]");

    private InventoryPage() {}
}