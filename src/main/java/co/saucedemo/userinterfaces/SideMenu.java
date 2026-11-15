package co.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SideMenu {

    public static final Target MENU_BUTTON =
            Target.the("menu button").located(By.id("react-burger-menu-btn"));
    public static final Target LOGOUT_LINK =
            Target.the("logout link").located(By.cssSelector("[data-test='logout-sidebar-link']"));

    private SideMenu() {}
}