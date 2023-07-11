package co.com.certification.automation.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CabecerasPage {

    public static final Target CABECERAS_REFERENCE = Target.the("link for section cabecera")
            .located(By.cssSelector("a[href='/hogar/muebles/cabeceros']"));

    public static final Target FIRST_PRODUCT_SECTION = Target.the("first product in inventary")
            .located(By.cssSelector("div[id='gallery-layout-container'] > div:nth-child(1) div[class*='button-modal']"));


}
