package co.com.certification.automation.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CabecerasPage {

    public static final Target CABECERAS_REFERENCE = Target.the("enlace for section cabecera")
            .located(By.cssSelector("a[href='/hogar/muebles/cabeceros']"));

   // "div[id='gallery-layout-container'] > div:nth-child(1) div[class*='button-modal']"
}
