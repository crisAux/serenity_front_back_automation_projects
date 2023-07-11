package co.com.certification.automation.tasks;

import co.com.certification.automation.exceptions.LandingPageExitoError;
import co.com.certification.automation.userinterface.ExitoMainPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerifyLoginTask implements Task {


    @Override
    @Step("Se verifica autenticacion")
    public <T extends Actor> void performAs(T theActor) {
        theActor.should(GivenWhenThen.seeThat(WebElementQuestion.the(ExitoMainPage.FORM_LOGIN_BUTTON), isVisible())
                .orComplainWith(LandingPageExitoError.class,
                        LandingPageExitoError.MESSAGE_FAILED_AUTHENTICATION));

    }

    public static VerifyLoginTask verifyLoginTask(){
        return instrumented(VerifyLoginTask.class);
    }
}
