package co.com.certification.automation.webHooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WebCommonSteps {

    public static Actor actor;

    @Managed
    public static WebDriver driver;

    private static final String ACTOR_NAME = "Cesar";



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
        driver.manage().window().maximize();
    }


}
