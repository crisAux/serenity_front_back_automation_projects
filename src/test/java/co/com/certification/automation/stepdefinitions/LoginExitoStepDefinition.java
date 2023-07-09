package co.com.certification.automation.stepdefinitions;

import co.com.certification.automation.tasks.ArriveToExitoMainPageTask;
import co.com.certification.automation.tasks.LoginEmailPasswordTask;
import co.com.certification.automation.tasks.Start;
import co.com.certification.automation.tasks.VerifyLoginTask;
import co.com.certification.automation.util.resources.LoginManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;


import static co.com.certification.automation.model.builders.UserBuilder.theUser;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class LoginExitoStepDefinition {

    private static final String ACTOR_NAME = "Cesar";

    private static final LoginManager LOGIN_CREDENTIALS=LoginManager.getInstance();

    private static final String EXITO_USER = LOGIN_CREDENTIALS.getUsername();
    private static final String EXITO_PASSWORD = LOGIN_CREDENTIALS.getPassword();

    private Actor actor;

    @Managed
    private WebDriver driver;


    /**
     * El método "setTheStage()" se ejecuta antes de cada escenario de prueba y se encarga de
     * configurar el escenario para la ejecución de las pruebas. En este caso, se establece el
     * escenario en línea utilizando el elenco en línea (OnlineCast) proporcionado por la biblioteca Serenity BDD.
     * Luego, se verifica si el controlador utilizado es Opera.
      */
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        actor=Actor.named(ACTOR_NAME).whoCan(BrowseTheWeb.with(driver));
    }



    @Given("Cesar esta en la pagina principal de exito")
    public void cesarEstaEnLaPaginaPrincipalDeExito() {
       actor.wasAbleTo(
               ArriveToExitoMainPageTask.arriveToExitoMainPage());
    }

    @When("Cesar se autentica con su respectivo usuario y password")
    public void cesarSeAutenticaConSuRespectivoUsuarioYPassword() {
        actor.wasAbleTo(
                LoginEmailPasswordTask.loginEmailPassword(theUser(EXITO_USER)
                        .withPassword(EXITO_PASSWORD))
        );
    }

    @Then("Cesar Puede ingresar con exito a la plataforma del exito")
    public void cesarPuedeIngresarConExitoALaPlataformaDelExito() {
        actor.wasAbleTo(
                VerifyLoginTask.verifyLoginTask()
        );
    }
}
