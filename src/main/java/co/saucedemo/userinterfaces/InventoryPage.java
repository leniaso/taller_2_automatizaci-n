package co.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventoryPage {

    public static final Target TITLE =
            Target.the("page title").located(By.cssSelector("[data-test='title']"));

    private InventoryPage() {}
}