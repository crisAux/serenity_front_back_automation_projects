package co.com.certification.automation.tasks;

import co.com.certification.automation.userinterface.ExitoMainPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenMainPageTask implements Task {

    private ExitoMainPage exitoMainPage;
    @Override
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Open.browserOn(exitoMainPage)
        );
    }

    public static OpenMainPageTask openPageExito(){
        return instrumented(OpenMainPageTask.class);
    }
}
