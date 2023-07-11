package co.com.certification.automation.userinterface;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.List;

public class CabecerasPage {

    public static final Target CABECERAS_REFERENCE = Target.the("link for section cabecera")
            .located(By.cssSelector("a[href='/hogar/muebles/cabeceros']"));

    public static final Target LAST_PRODUCT_SECTION = Target.the("first product in inventary")
            .located(By.cssSelector("div[id='gallery-layout-container'] > div:nth-child(10) div[class*='button-modal']"));

    public static final List<WebElementFacade> getAllBuyButtons(Actor theActor){
        return BrowseTheWeb.as(theActor).findAll(By.cssSelector("div[id='gallery-layout-container'] div[class*='button-modal']"));
    }

}
