package co.com.certification.automation.stepdefinitions;

import co.com.certification.automation.tasks.ArriveToExitoMainPageTask;
import co.com.certification.automation.tasks.LoginEmailPasswordTask;
import co.com.certification.automation.tasks.VerifyLoginTask;
import co.com.certification.automation.util.resources.LoginManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static co.com.certification.automation.model.builders.UserBuilder.theUser;
import static co.com.certification.automation.webHooks.WebCommonSteps.*;

public class LoginExitoStepDefinition  {



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
