package co.com.certification.automation.tasks;

import co.com.certification.automation.exceptions.LandingPageExitoError;
import co.com.certification.automation.interactions.EnterAndHide;
import co.com.certification.automation.model.User;
import co.com.certification.automation.userinterface.ExitoMainPage;
import co.com.certification.automation.userinterface.MiCuentaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static net.serenitybdd.screenplay.Tasks.instrumented;
public class LoginEmailPasswordTask implements Task {

    private final User user;

    public LoginEmailPasswordTask(User user) {
        this.user = user;
    }

    @Override
   @Step("Se realiza la autenticacion")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Click.on(ExitoMainPage.FORM_LOGIN_BUTTON),
                Wait.until(
                        WebElementQuestion.the(MiCuentaPage.GO_TO_LOGIN_BUTTON) , WebElementStateMatchers.isEnabled()
                ).forNoMoreThan(30).seconds()
                );

        theActor.attemptsTo(
                Click.on(MiCuentaPage.GO_TO_LOGIN_BUTTON),
                Enter.theValue(user.getUsername()).into(MiCuentaPage.INPUT_EMAIL),
                EnterAndHide.theValue(user.getPassword()).as("a password").into(MiCuentaPage.INPUT_PASSWORD),
                Click.on(MiCuentaPage.SING_IN));
    }

    public static LoginEmailPasswordTask loginEmailPassword(User user){
        return instrumented(LoginEmailPasswordTask.class,user);
    }
}
