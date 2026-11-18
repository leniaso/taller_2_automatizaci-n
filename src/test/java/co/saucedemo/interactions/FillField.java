package co.saucedemo.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/** Types a value into a field; an empty value leaves the field untouched. */
public class FillField implements Interaction {

    private final Target field;
    private final String value;

    public FillField(Target field, String value) {
        this.field = field;
        this.value = value;
    }

    public static Builder in(Target field) {
        return new Builder(field);
    }

    @Override
    @Step("{0} fills the field with '#value'")
    public <T extends Actor> void performAs(T actor) {
        if (value != null && !value.isEmpty()) {
            actor.attemptsTo(Enter.theValue(value).into(field));
        }
    }

    public static class Builder {
        private final Target field;

        Builder(Target field) {
            this.field = field;
        }

        public FillField with(String value) {
            return instrumented(FillField.class, field, value);
        }
    }
}
