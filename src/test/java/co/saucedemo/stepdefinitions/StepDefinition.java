package co.saucedemo.stepdefinitions;
import co.saucedemo.utils.Delay;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


public class StepDefinition {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }

    @AfterStep
    public void pauseBetweenSteps() {
        Delay.pause();
    }

    @After
    public void tearDown() {
        OnStage.drawTheCurtain();
    }
}