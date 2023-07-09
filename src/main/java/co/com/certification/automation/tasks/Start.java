package co.com.certification.automation.tasks;

import co.com.certification.automation.exceptions.StartError;
import co.com.certification.automation.exceptions.UserModelCreationException;
import co.com.certification.automation.interactions.EnterAndHide;
import co.com.certification.automation.model.builders.UserBuilder;
import co.com.certification.automation.userinterface.ExitoMainPage;
import co.com.certification.automation.userinterface.MiCuentaPage;
import co.com.certification.automation.model.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class Start implements Task {

    private static final String USERNAME = "DEFAULT_USERNAME";
    private static final String USER_PASSWORD = "DEFAULT_PASSWORD";
    private final User user;
    private ExitoMainPage exitoMainPage;

    public Start(User user) {
        this.user = user;
    }

    @Override
    //@Step("{0} performs an authentication")
    public <T extends Actor> void performAs(T theActor) {



        theActor.should(GivenWhenThen.seeThat(WebElementQuestion.the(ExitoMainPage.FORM_LOGIN_BUTTON), isVisible())
                .orComplainWith(StartError.class,
                        StartError.MESSAGE_FAILED_AUTHENTICATION));


    }

    public static Start authenticating(User user) {
        return instrumented(Start.class, user);
    }

    public static Start withAnAuthenticatedDefaultUser() throws UserModelCreationException {
        return instrumented(Start.class, UserBuilder.theUser(USERNAME).withPassword(USER_PASSWORD));
    }

}
