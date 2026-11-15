package co.saucedemo.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class StepDefinition {

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }

    @After
    public void cierre() {
        OnStage.drawTheCurtain();
    }
}
