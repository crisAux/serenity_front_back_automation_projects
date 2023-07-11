package co.com.certification.automation.tasks;

import co.com.certification.automation.exceptions.LandingPageExitoError;
import co.com.certification.automation.userinterface.CabecerasPage;
import co.com.certification.automation.userinterface.ExitoMainPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.HoverOverTarget;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ArriveToCabeceraSectionTask implements Task {

    @Override
    @Step("Ingresar a la seccion de cabeceras de cama disponibles")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Click.on(ExitoMainPage.BUTTON_MENU_EXITO)
        );
        theActor.should(
                GivenWhenThen.seeThat(WebElementQuestion.the(ExitoMainPage.BUTTON_DORMITORIO), isVisible())
                .orComplainWith(LandingPageExitoError.class,
                        LandingPageExitoError.MAIN_MENU_NOT_LOADED)
        );
        theActor.attemptsTo((
                HoverOverTarget.over(ExitoMainPage.BUTTON_DORMITORIO))
        );
        theActor.attemptsTo(
                Click.on(ExitoMainPage.BUTTON_CABECERAS)
        );
        theActor.attemptsTo(
                Click.on(ExitoMainPage.BUTTON_CLOSE_MENU)
        );

        theActor.should(
                GivenWhenThen.seeThat(WebElementQuestion.the(CabecerasPage.CABECERAS_REFERENCE))
        );


    }

    public static ArriveToCabeceraSectionTask arriveToHeadersSection(){
        return instrumented(ArriveToCabeceraSectionTask.class);
    }
}
