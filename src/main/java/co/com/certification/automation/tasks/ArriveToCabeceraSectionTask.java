package co.com.certification.automation.tasks;

import co.com.certification.automation.exceptions.*;
import co.com.certification.automation.userinterface.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.HoverOverTarget;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ArriveToCabeceraSectionTask implements Task {
    private ExitoMainPage exitoMainPage;

    @Override
    @Step("Ingresar a la seccion de cabeceras de cama disponibles")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Open.browserOn(exitoMainPage),
                Click.on(ExitoMainPage.BUTTON_MENU_EXITO)
        );
        theActor.should(
                GivenWhenThen.seeThat(WebElementQuestion.the(ExitoMainPage.BUTTON_DORMITORIO), isVisible())
                .orComplainWith(LandingPageExitoError.class,
                        LandingPageExitoError.MAIN_MENU_NOT_LOADED)
        );
        theActor.attemptsTo((
                HoverOverTarget.over(ExitoMainPage.BUTTON_DORMITORIO)),
                Click.on(ExitoMainPage.BUTTON_CABECERAS),
                Click.on(ExitoMainPage.BUTTON_CLOSE_MENU),
                Wait.until(
                        WebElementQuestion.the(CabecerasPage.CABECERAS_REFERENCE) , WebElementStateMatchers.isEnabled()
                ).forNoMoreThan(30).seconds(),
                Wait.until(
                        WebElementQuestion.the(CabecerasPage.LAST_PRODUCT_SECTION) , WebElementStateMatchers.isEnabled()
                ).forNoMoreThan(30).seconds()

        );
    }

    public static ArriveToCabeceraSectionTask arriveToHeadersSection(){
        return instrumented(ArriveToCabeceraSectionTask.class);
    }


}
