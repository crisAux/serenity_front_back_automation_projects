package co.com.certification.automation.tasks;

import co.com.certification.automation.exceptions.LandingPageExitoError;
import co.com.certification.automation.userinterface.CabecerasPage;
import co.com.certification.automation.userinterface.ExitoMainPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ArriveToExitoMainPageTask implements Task {

    private ExitoMainPage exitoMainPage;
  @Override
  @Step("Ingresar a la pagina principal de exito.com")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Wait.until(
                        WebElementQuestion.the(ExitoMainPage.FORM_LOGIN_BUTTON) , WebElementStateMatchers.isEnabled()
                ).forNoMoreThan(30).seconds()
        );
    }

    public static ArriveToExitoMainPageTask arriveToExitoMainPage(){
        return instrumented(ArriveToExitoMainPageTask.class);
    }
}
